package entidades;

/**
 * Created by adri on 18/12/16.
 */
public class Mapa {
    private Sala[][] matrizSalas;
    private int Dim1;
    private int Dim2;

    public void setDim1(int Dim1) {
        this.Dim1 = Dim1;
    }

    public int getDim1() {
        return this.Dim1;
    }

    public void setDim2(int DIM2) {
        this.Dim2 = DIM2;
    }

    public int getDim2() {
        return this.Dim2;
    }

    public void setMatrizSalas() {
        int k = 0;
        for (int i = 0; i < this.Dim1; i++) {
            for (int j = 0; j < this.Dim2; j++) {
                this.matrizSalas[i][j] = new Sala(k);
            }
        }
    }

    //TODO:Reparto de llaves EC2, Creación implementación y prueba de los personajes y acciones personajes
    public void repartirLlaves() {

    }


}
