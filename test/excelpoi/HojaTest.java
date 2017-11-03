/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelpoi;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test to test the operation of the Sheet class
 * Test para probar elfuncionamiento de la clase Hoja
 * @author Fermach
 */
public class HojaTest {
    
    public HojaTest() {
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
     * Test of getDato method, of class Hoja.
     */
    @Test
    public void testGetDato() {
        System.out.println("getDato");
        int fila = 0;
        int columna = 1;
        Hoja instance = new Hoja();
        instance.setDato("a", fila, columna);
        String expResult = "a";
        String result = instance.getDato(fila, columna);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDato method, of class Hoja.
     */
    @Test
    public void testSetDato() {
        System.out.println("setDato");
        String dato = "s";
        int fila = 1;
        int columna = 1;
        Hoja instance = new Hoja();
        instance.setDato(dato, fila, columna);
        
    }

    /**
     * Test of getNfilas method, of class Hoja.
     */
    @Test
    public void testGetNfilas() {
        System.out.println("getNfilas");
        Hoja instance = new Hoja();
        int expResult = 5;
        int result = instance.getNfilas();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setDatos method, of class Hoja.
     */
    @Test
    public void testSetDatos() {
        System.out.println("setDatos");
        String[][] datos = new String[3][3] ;
        datos[1][2]="s";
        datos[1][1]="h";
        Hoja instance = new Hoja();
        instance.setDatos(datos);
        
    }

    /**
     * Test of setnFilas method, of class Hoja.
     */
    @Test
    public void testSetnFilas() {
        System.out.println("setnFilas");
        int nFilas = 7;
        Hoja instance = new Hoja();
        instance.setnFilas(nFilas);
        
    }

    /**
     * Test of setnColumnas method, of class Hoja.
     */
    @Test
    public void testSetnColumnas() {
        System.out.println("setnColumnas");
        int nColumnas = 9;
        Hoja instance = new Hoja();
        instance.setnColumnas(nColumnas);

    }

    /**
     * Test of getNcolumnas method, of class Hoja.
     */
    @Test
    public void testGetNcolumnas() {
        System.out.println("getNcolumnas");
        Hoja instance = new Hoja();
        int expResult = 5;
        int result = instance.getNcolumnas();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getNombre method, of class Hoja.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Hoja instance = new Hoja();
        String expResult = "Sin_nombre";
        String result = instance.getNombre();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setNombre method, of class Hoja.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "nuevoNombre";
        Hoja instance = new Hoja();
        instance.setNombre(nombre);
        
    }

    /**
     * Test of compare method, of class Hoja.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        Hoja hoja = new Hoja();
        Hoja instance = new Hoja();
        boolean expResult = true;
        boolean result = instance.compare(hoja);
        assertEquals(expResult, result);
        
    }
    
}
