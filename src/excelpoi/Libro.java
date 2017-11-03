/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelpoi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * Clase que nos permite quear un objeto de tipo libro con
 * una serie de metods para alterar y modificar dicho objeto.
 * 
 * 
 * Class that allows us to burn a book type object with
 * a series of methods to alter and modify said object
 * 
 * @author Fermach
 * 
 * Github: Fermach
 */
public class Libro {
    private List<Hoja> listaHojas;
    private String nombre;

   
    public Libro(){
     this.listaHojas=new ArrayList<>();
     this.nombre = "sin_nombre.xlsx";
    
    }
     /**
     * 
     * @param listaHojas
     * @param nombre 
     */
    public Libro(List<Hoja> listaHojas, String nombre) {
        this.listaHojas = listaHojas;
        this.nombre = nombre;
    }
    /**
     * 
     * @return lista de hojas
     */
    public List<Hoja> getListaHojas() {
        return listaHojas;
    }

    /**
     * 
     * @param listaHojas 
     */
    public void setListaHojas(List<Hoja> listaHojas) {
        this.listaHojas = listaHojas;
    }
    /**
     * 
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * 
     * Method to export our book created
     * Método para exportar nuestri libro creado
     * @throws IOException 
     */
    public void saveBook() throws IOException{
    
        XSSFWorkbook wb =new XSSFWorkbook();
        Sheet sh;
        Row row;
        Cell cell;
        
        for( int i=0; i < listaHojas.size(); i++){
         sh = wb.createSheet(listaHojas.get(i).getNombre());
         for( int f=0; f < listaHojas.get(i).nFilas; f++ ){
            row= sh.createRow(f);
            for( int h =0; h < listaHojas.get(i).nColumnas; h++ ){
             cell =row.createCell(h);
             cell.setCellValue(listaHojas.get(i).getDato(f, h));
            }
         
         }
         
        }
        try (FileOutputStream out= new FileOutputStream(this.nombre)){
            //introducir un nombre valido
            String termination= this.nombre.substring(this.nombre.length()-5,this.nombre.length());
            System.out.println(termination);
            
            if(termination.equals(".xlsx") ){
            wb.write(out);
            }else{
             throw new InvalidNameException("Nombre de Archivo invalido");
            }
                
                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidNameException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            wb.close();
        }
    }
    
    /**
     * Method to load a book from an external source
     * Método para cargar un libro desde una fuente externa
     * @param inputFile 
     */
    public void loadBook(String inputFile) {
        try(FileInputStream fileInputStream = new FileInputStream(new File(inputFile));){
           
            XSSFWorkbook workbook= new XSSFWorkbook(fileInputStream);
            Hoja miHoja;
   
            Row fila;
            Sheet hoja;
            Cell celda;
            int numFilas=0;
            int numColumnas=0;
            int numHojas=0;
            
            Iterator libroIterator = workbook.iterator();
            
            // Recorremos el libro para captar el numero de filas y columnas
            while (libroIterator.hasNext()) {
                hoja= (Sheet) libroIterator.next();
                numHojas++;
                
                for( int i=0; i < hoja.getLastRowNum(); i++ ){
                    fila= hoja.getRow(i);
                    numFilas++;
                    for( int h =0; h <fila.getLastCellNum(); h++ ){
                        celda= fila.getCell(h);
                        numColumnas++;
                    }
                }
                //Creamos nuestra hoja  con el numero de fiilas y columnas de la hoja leida
                //le aplicamoscomo numbre hoja más el numero de hoja que ocupa en nuestro libro
                miHoja =new Hoja("Hoja_"+numHojas, numFilas, numColumnas);
                
                //volvemos a recorrer la hoja para copiar los datos del excel leido a nuestra hoja
                for( int i=0; i < hoja.getLastRowNum(); i++ ){
                    fila= hoja.getRow(i);
                    
                    for( int h =0; h <fila.getLastCellNum(); h++ ){
                        celda= fila.getCell(h);
                        
                       //recojo el valor de la celda,comprobando el tipo de dato
                       //y lo añado a mi lista
                        switch(celda.getCellType()){
                            
                            case(Cell.CELL_TYPE_STRING):
                                miHoja.setDato(celda.getStringCellValue(), i, h);
                                break;
                            case(Cell.CELL_TYPE_NUMERIC):
                                miHoja.setDato(""+celda.getNumericCellValue(), i, h);
                                break;
                            case(Cell.CELL_TYPE_FORMULA):
                                miHoja.setDato(celda.getCellFormula().toString(), i, h);
                                break;
                            case(Cell.CELL_TYPE_BOOLEAN):
                                miHoja.setDato(""+celda.getBooleanCellValue(), i, h);
                                break;
                            default:
                                miHoja.setDato("", i, h);
                                break;
                        
                        }
                    }
                }
                //añadimos nuestra hoja a la lista de hojas de nuestroobjeto libro
                //mientra el libro leido tenga hojas
                listaHojas.add(miHoja);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Libro.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        
    }

    @Override
    public String toString() {
        return "Libro{" + "listaHojas=" + listaHojas.toString() + ", nombre=" + nombre + '}';
    }
                
               
            
    
 }
            
        