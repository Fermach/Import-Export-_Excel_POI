/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excelpoi;

/**
 * Excepcion para capturar los archivos con nombre invalido
 * Exception to capture files with invalid name
 * @author Fermach
 */
public class InvalidNameException extends Exception {

    public InvalidNameException() {
    }
    /**
     * Constructs an instance of <code>ExcelUtilException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidNameException(String msg) {
        super("ExcelAPI: "+msg);
    }
}
