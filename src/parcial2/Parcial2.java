/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;
import CargaData.*;
import datos.*;
import java.util.*;

/**
 *
 * @author Estudiante
 */
public class Parcial2 {
    
    /**
     * @author Jose Daniel Yara Sepúlveda
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CargaDatos cr = new CargaDatos();
        FincaRaiz fr = new FincaRaiz();
        cr.cargarDatos("datos.csv");
        String t = cr.listarInmuebles();
        System.out.println(t);
        
    }
    
}
