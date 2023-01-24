/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Usuario
 */
public class Decimales {
    int Entero;
    int Decimal;

    public Decimales(int Entero, int Decimal) {
        this.Entero = Entero;
        this.Decimal = Decimal;
    }


    public int getEntero() {
        return Entero;
    }

    public float getDecimal() {
        return Decimal;
    }

    public void setEntero(int Entero) {
        this.Entero = Entero;
    }

    public void setDecimal(int Decimal) {
        this.Decimal = Decimal;
    }

    @Override
    public String toString() {
        return + Entero + "." + Decimal;
    }
    public static void main(String[] args) {
        Decimales A = new Decimales(142, 57);
        System.out.println(A.toString());
    }
    
    
    
}
