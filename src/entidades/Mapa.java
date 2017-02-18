package entidades;

import Personajes.Stark;

/**
 * Created by adri on 18/12/16.
 */
public class Mapa {

    private int Dim1 = 0;
    private int Dim2 = 0;
    private Sala[][] matrizSalas = new Sala[6][6];
    Llave[] reparto = new Llave[45];
    private Sala salaGanadores = new Sala(1111);
    private int turno = 0;

    public Mapa() {
        this.Dim1 = 0;
        this.Dim2 = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                this.matrizSalas[i][j] = new Sala(7);

            }
        }
        this.salaGanadores = new Sala(1111);


    }

    public Mapa(int Dim1, int Dim2) {
        this.Dim1 = Dim1;
        this.Dim2 = Dim2;
        for (int i = 0; i < this.Dim1; i++) {
            for (int j = 0; j < this.Dim2; j++) {
                this.matrizSalas[i][j] = new Sala(7);

            }
        }
        this.salaGanadores = new Sala(1111);
    }


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
                k++;

            }
        }
    }

    public int getMatrizSalas() {
        int n = 0;
        for (int i = 0; i < this.Dim1; i++) {
            for (int j = 0; j < this.Dim2; j++) {
                n = this.matrizSalas[i][j].getId();
            }
        }
        return n;
    }

    public Sala getSalaGanadores() {
        return this.salaGanadores;
    }

    public void setSalaGanadores(Sala ganadores) {
        this.salaGanadores = ganadores;
    }

    public boolean haySala(int id) {
        boolean existe = false;
        for (int i = 0; i < this.getDim1(); i++) {
            for (int j = 0; j < this.getDim2(); j++) {
                if (id == this.matrizSalas[i][j].getId()) {
                    existe = true;
                } else {
                    existe = false;
                }
            }
        }
        return existe;
    }

    public void prepararReparto() {

        int i = 0;
        int j = 0;
        while (i < 45) {
            if (j % 2 != 0) {
                this.reparto[i] = new Llave(j);
                i++;
                this.reparto[i] = new Llave(j);
                j++;
                i++;
            } else {
                this.reparto[i] = new Llave(j);
                i++;
                j++;
            }

        }
        repartirLlaves();

    }

    public void repartirLlaves() {
        for (int i = 0; i < reparto.length; i++) {
            if (i >= 0 && i < 5) {
                this.matrizSalas[0][3].insertarLlaveSala(this.reparto[i]);

            }
            if (i >= 5 && i < 10) {
                this.matrizSalas[0][4].insertarLlaveSala(this.reparto[i]);

            }
            if (i >= 10 && i < 15) {

                this.matrizSalas[1][0].insertarLlaveSala(this.reparto[i]);
            }
            if (i >= 15 && i < 20) {
                this.matrizSalas[1][2].insertarLlaveSala(this.reparto[i]);

            }
            if (i >= 20 && i < 25) {

                this.matrizSalas[1][3].insertarLlaveSala(this.reparto[i]);
            }
            if (i >= 25 && i < 30) {

                this.matrizSalas[1][4].insertarLlaveSala(this.reparto[i]);
            }
            if (i >= 30 && i < 35) {

                this.matrizSalas[1][5].insertarLlaveSala(this.reparto[i]);
            }
            if (i >= 35 && i < 40) {

                this.matrizSalas[2][0].insertarLlaveSala(this.reparto[i]);
            }
            if (i >= 40 && i < 45) {
                this.matrizSalas[2][1].insertarLlaveSala(this.reparto[i]);

            }

        }

    }

    public void mostrarMapa() {
        for (int i = 0; i < getDim1(); i++) {
            for (int j = 0; j < getDim2(); j++) {
                System.out.println("Sala :");
                System.out.println(this.matrizSalas[i][j].getId());
                this.matrizSalas[i][j].mostrarPersonajeSala();
                if (this.matrizSalas[i][j].hayLlave()) {
                    System.out.println("Hay Llaves en esta sala");
                }
                System.out.println();


            }
        }
    }

    public boolean BuscarSala(Sala sala) {
        boolean existe = false;
        for (int i = 0; i < this.Dim1; i++) {
            for (int j = 0; j < this.Dim1; j++) {
                if (this.matrizSalas[i][j] == sala) {
                    existe = true;
                } else {
                    existe = false;
                }
            }

        }
        return existe;
    }

    public void incrementarTurno() {
        this.turno++;
    }


    public void simulacion() {
        int coorI = 0;
        int coorJ = 2;
        Dir[] S = {Dir.E, Dir.E};
        Stark Tony = new Stark("Ironman", 'T');
        /*Targaryen Clarke = new Targaryen("Emilie ", 'E');
        Caminante Bicho = new Caminante("Cr7", 'C');
        Lannister Blake = new Lannister("Griffin", 'B');*/
        this.matrizSalas[coorI][coorJ].insertarPersonajesSala(Tony);
        Tony.accionesStark(S, this.matrizSalas, coorI, coorJ);
//TODO:Hacer distintas pruebas con los personajes para ver si realizan bien sus acciones con el movimiento y ya estaría finalizada ec2


    }

    public enum Dir {S, E, N, O}


    public static void main(String[] args) {
        Mapa m = new Mapa(6, 6);

        m.setMatrizSalas();
        m.prepararReparto();
        m.simulacion();
        // m.mostrarMapa();


    }
}




