/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelpoi;
/**
 * This class stores text information from
 * a spreadsheet
 * 
 * Esta clase almacena información del texto de
 * una hoja de cálculo.
 *
 * @author Fermach
 * 
 * Github: Fermach
 */
public class Hoja {
    private String[][] datos;
    private String nombre;
    int nFilas;
    int nColumnas;

    /**
     * Crea una hoja de cálculo nueva
     */
    public Hoja() {
        this.datos = new String[5][5];
        this.nColumnas=5;
        this.nFilas=5;
        this.nombre = "Sin_nombre";
        
    }
    
    /**
     * Crea una hoja nueva de tamaño nFilas por nColumnas
     * Create a new sheet of size nFiles by nColumns
     * @param nFilas el número de filas
     * @param nColumnas el número de celdas que tiene cada fila
     */
    public Hoja(int nFilas, int nColumnas) {
        this.datos = new String[nFilas][nColumnas];
        this.nColumnas=nColumnas;
        this.nFilas=nFilas;
        this.nombre="";
    }
    
    public Hoja(String nombre, int nFilas, int nColumnas) {
        this.datos = new String[nFilas][nColumnas];
        this.nombre = nombre;
        this.nFilas=nFilas;
        this.nColumnas=nColumnas;
    }    


    public String getDato(int fila, int columna) {
      //to-do Excep si accedemos a una posicion no valida

        return datos[fila][columna];
    }

    public void setDato(String dato, int fila, int columna) {
        //to-do Excep si accedemos a una posicion no valida
        this.datos[fila][columna] = dato;
    }

    public int getNfilas() {
        return nFilas;
    }

    public void setDatos(String[][] datos) {
        this.datos = datos;
    }

    public void setnFilas(int nFilas) {
        this.nFilas = nFilas;
    }

    public void setnColumnas(int nColumnas) {
        this.nColumnas = nColumnas;
    }


    public int getNcolumnas() {
        return nColumnas;
    }

 
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    /**
     * Clase que nos permite comparar los datos de dos hojas
     * Class that allows us to compare the data of two sheets
     * @param hoja
     * @return 
     */
    public boolean compare(Hoja hoja){
       boolean iguales = true;
       
       if(this.nColumnas == hoja.getNcolumnas() && this.nFilas == hoja.getNfilas()){
         for(int i=0;i <this.nFilas; i++){
           for(int j=0;j<this.nColumnas;j++){
             if(this.datos[i][j].equals(hoja.getDato(i, j))){
             return false;
             
             }
           }
         }
       }else{
       iguales=false;
       }
       return iguales;

    }

    @Override
    public String toString() {
        return "Hoja{" + "datos=" + datos + ", nombre=" + nombre + ", nFilas=" + nFilas + ", nColumnas=" + nColumnas + '}';
    }
    
    
}

