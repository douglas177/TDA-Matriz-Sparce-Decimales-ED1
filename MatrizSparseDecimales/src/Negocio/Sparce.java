/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author Douglas
 */
public class Sparce {

    int VFC[];
    Decimales VD[];
    float EP;
    int NFil;
    int NCol;
    int CantBit;
    int dim;

    public Sparce(int NFil, int NCol, float ep) {
        this.CantBit = CalcularNbit(NFil * NCol);
        //VFC = new VectorbitsGe(5,CantBit);
        VFC = new int[10];
        VD = new Decimales[10];
        this.NFil = NFil;
        this.NCol = NCol;
        this.EP = ep;
        this.dim = -1;

    }

    private int CalcularNbit(int cant) {
        int i = 0;
        while (Math.pow(2, i) < cant) {
            i++;
        }
        return (i);
    }

    public boolean vacia() {
        return (dim == -1);
    }

    public int dim() {
        return this.dim;
    }

    public int NFilas() {
        return this.NFil;
    }

    public int NCol() {
        return this.NCol;
    }

    public float EP() {
        return EP;
    }

    public void Insertar(int F, int C, Decimales D) {
        if ((F > NFil) || (C > NCol)) {
            System.out.println("fuera de rango");
            System.exit(1);
        } else {
            int FC = (F - 1) * NCol + C;
            if (vacia()) {
                System.out.println(D);
                if (!D.toString().equals(EP)) {
                    dim++;
                    VD[dim] = D;
                    VFC[dim] = FC;
                }
            } else {
                int x = buscarFC(F, C);
                if (x == -1) {
                    redimencionar();
                    dim++;
                    VD[dim] = D;
                    VFC[dim] = FC;
                } else {
                    if (D.toString().equals(EP)) {
                        VD[x] = D;
                    } else {
                        for (int i = x; i < dim; i++) {
                            VFC[i] = VFC[i + 1];
                            VD[i] = VD[i + 1];
                        }
                        dim--;
                    }
                }

            }
        }

    }

    private int buscarFC(int fila, int col) {
        int i = 0;
        int FC = (fila - 1) * NCol + col;
        while ((i <= dim) && (VFC[i] != FC)) {
            i++;
        }
        if (i <= dim) {
            return (i);
        } else {
            return (-1);
        }
    }

    /*private int BuscarFC(int fila, int col) {
        int i = 0;
        int FC = (fila - 1) * NCol + col;
        while ((i <= dim) && (VFC.Get(i + 1) != FC)) {
            i++;
        }
        if (i <= dim) {
            return (i);
        } else {
            return (-1);
        }
    }*/

 /*   private void Redimencionar() {
        if (dim == VFC.length - 1) {
            VectorbitsGe VFC1;
            float VD1[];
            VD1 = new float[VD.length];
            VFC1 = new int[VFC.length];
            System.arraycopy(VD, 0, VD1, dim, VD.length);
            System.arraycopy(VFC, 0, VFC1, dim, VFC.length);
            VD = new float[VD1.length + 10];
            VFC = new int[VFC1.length + 10];
            System.arraycopy(VD1, 0, VD, dim, VD.length);
            System.arraycopy(VFC1, 0, VFC, dim, VFC.length);
        }
    }
     */
    private void redimencionar() {
        if (dim == VFC.length - 1) {
            int VFC1[];
            float VD1[];
            VD1 = new float[VD.length];
            VFC1 = new int[VFC.length];
            System.arraycopy(VD, 0, VD1, dim, VD.length);
            System.arraycopy(VFC, 0, VFC1, dim, VFC.length);
            VD = new Decimales[VD1.length + 5];
            VFC = new int[VFC1.length + 5];
            System.arraycopy(VD1, 0, VD, dim, VD.length);
            System.arraycopy(VFC1, 0, VFC, dim, VFC.length);
        }
    }

    public String Get(int fila, int col) {
        int x = buscarFC(fila, col);
        if (x >= 0) {
            return VD[x].toString();
        } else {
            return String.valueOf(EP);
        }
    }

    public String toString() {
        String S = "";
        for (int i = 1; i <= NFil; i++) {
            for (int j = 1; j <= NCol; j++) {
                if (j < NCol) {
                    if (Get(i, j).equals(EP)) {
                        S = S +  (Get(i, j)) + "  -  ";
                    } else {
                        S = S + Get(i, j) + "  -  ";
                    }
                } else {
                    if (Get(i, j).equals(EP)) {
                        S = S + (Get(i, j));
                    } else {
                        S = S + Get(i, j);
                    }
                }
            }
            S = S + '\n';

        }
        return S;
    }

    public String toStringVFC() {
        String S = "[";
        for (int i = 0; i <= dim; i++) {
            if (VFC[i] != 0) {
                S = S + VFC[i] + " , ";
            }
        }
        if (S.length() != 1) {
            S = S.substring(0, S.length() - 3);
        }
        S = S + "]";
        return S;
    }

    public String toStringVD() {
        String S = "[";
        for (int i = 0; i <= dim; i++) {
            if (!VD[i].equals(EP)) {
                if (!VD[i].equals(EP)) {
                    S = S + VD[i] + " , ";
                }
            }
        }
        if (S.length() != 1) {
            S = S.substring(0, S.length() - 3);
        }
        S = S + "]";
        return S;
    }

}
