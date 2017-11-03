/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelpoi;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test to test the operation of the Sheet class
 * Test para probar el funcionamiento de la clase Libro
 * @author Fermach
 */
public class LibroTest {
    
    public LibroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getListaHojas method, of class Libro.
     */
    @Test
    public void testGetListaHojas() {
        System.out.println("getListaHojas");
        Libro instance = new Libro();
        List<Hoja> result = instance.getListaHojas();
        System.out.println(result);
    }

    /**
     * Test of setListaHojas method, of class Libro.
     */
    @Test
    public void testSetListaHojas() {
        System.out.println("setListaHojas");
        Hoja hoja_1= new Hoja("hoja_1", 2, 2);
          hoja_1.setDato("A", 0,0);
          hoja_1.setDato("B", 0,1);
          hoja_1.setDato("C", 1,0);
          hoja_1.setDato("D", 1,1);
          
          Hoja hoja_2= new Hoja("hoja_2", 3, 3);
          hoja_2.setDato("E", 0,0);
          hoja_2.setDato("F", 0,1);
          hoja_2.setDato("G", 1,0);
          hoja_2.setDato("H", 1,1);
          
          
          Hoja hoja_3= new Hoja("hoja_3", 3, 3);
          hoja_3.setDato("I", 0,0);
          hoja_3.setDato("J", 0,1);
          hoja_3.setDato("K", 1,0);
          hoja_3.setDato("L", 1,1);
          
          
          Hoja hoja_4= new Hoja("hoja_4", 3, 3);
          hoja_4.setDato("M", 0,0);
          hoja_4.setDato("N", 0,1);
          hoja_4.setDato("ENIE", 1,0);
          hoja_4.setDato("O", 1,1);
          
          List<Hoja> listaHojas = new ArrayList();
          
          listaHojas.add(hoja_1);
          listaHojas.add(hoja_2);
          listaHojas.add(hoja_3);
          listaHojas.add(hoja_4);
          
        Libro miLibro = new Libro();
        miLibro.setListaHojas(listaHojas);
        System.out.println(miLibro);
    }

    /**
     * Test of getNombre method, of class Libro.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Libro instance = new Libro();
        String expResult = "sin_nombre.xlsx";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setNombre method, of class Libro.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "nuevoNombre.xlsx";
        Libro instance = new Libro();
        instance.setNombre(nombre);
        System.out.println(instance);
        
    }

    /**
     * Test of saveBook method, of class Libro.
     */
    @Test
    public void testSaveBook() throws Exception {
        System.out.println("saveBook");
        
        Hoja hoja_1= new Hoja("hoja_1", 2, 2);
          hoja_1.setDato("A", 0,0);
          hoja_1.setDato("B", 0,1);
          hoja_1.setDato("C", 1,0);
          hoja_1.setDato("D", 1,1);
          
          Hoja hoja_2= new Hoja("hoja_2", 3, 3);
          hoja_2.setDato("E", 0,0);
          hoja_2.setDato("F", 0,1);
          hoja_2.setDato("G", 1,0);
          hoja_2.setDato("H", 1,1);
          
          
          Hoja hoja_3= new Hoja("hoja_3", 3, 3);
          hoja_3.setDato("I", 0,0);
          hoja_3.setDato("J", 0,1);
          hoja_3.setDato("K", 1,0);
          hoja_3.setDato("L", 1,1);
          
          
          Hoja hoja_4= new Hoja("hoja_4", 3, 3);
          hoja_4.setDato("M", 0,0);
          hoja_4.setDato("N", 0,1);
          hoja_4.setDato("ENIE", 1,0);
          hoja_4.setDato("O", 1,1);
          
          List<Hoja> listaHojas = new ArrayList();
          
          listaHojas.add(hoja_1);
          listaHojas.add(hoja_2);
          listaHojas.add(hoja_3);
          listaHojas.add(hoja_4);
          
          Libro miLibro = new Libro(listaHojas, "src/output/miLibro.xlsx");
          miLibro.saveBook();
            }
    

    /**
     * Test of loadBook method, of class Libro.
     */
    @Test
    public void testLoadBook() {
        System.out.println("loadBook");
        String inputFile = "src/input/InputExcel.xlsx";
        Libro instance = new Libro();
        instance.loadBook(inputFile);
        System.out.println(instance);
    }

   
    
}
