/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizsparsedecimales;

import Negocio.Decimales;
import Negocio.Sparce;

/**
 *
 * @author Usuario
 */
public class MatrizSparseDecimales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Decimales N = new Decimales(1, 4);
        Sparce A = new Sparce(4, 5, 0);
        A.Insertar(1, 2, N);
        A.Insertar(4, 5, N);
        System.out.println(A.toString());
    }
    
}
