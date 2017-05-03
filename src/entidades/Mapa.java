package entidades;

import Personajes.Targaryen;

/**
 * Created by adri on 18/12/16.
 */
public class Mapa {

    private int Dim1 = 0;
    private int Dim2 = 0;
    private Sala[][] matrizSalas = null;

    private Sala salaGanadores = new Sala(1111);
    private int turno = 0;
    private static Mapa mapa = null;

    //Constructores
    private Mapa() {
        this.Dim1 = 0;
        this.Dim2 = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matrizSalas[i][j] = new Sala(7);

            }
        }
        this.salaGanadores = new Sala(1111);
        this.turno = 0;


    }

    public static Mapa getInstanciaMapa() {
        if (mapa == null) {
            mapa = new Mapa();
        }
        return mapa;
    }


    private Mapa(int Dim1, int Dim2) {
        this.Dim1 = Dim1;
        this.Dim2 = Dim2;
        for (int i = 0; i < this.Dim1; i++) {
            for (int j = 0; j < this.Dim2; j++) {
                // matrizSalas[i][j] = new Sala(7);
                getInstanciaMapa();
            }
        }
        this.salaGanadores = new Sala(1111);
        this.turno = 0;
    }

    public static Mapa getMapaDim(int dim1, int dim2) {
        if (mapa == null) {
            mapa = new Mapa(dim1, dim2);
        }
        return mapa;
    }

    //Getters and Setters
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
                matrizSalas[i][j] = new Sala(k);
                matrizSalas[i][j].setCoordenadas(i, j);
                k++;

            }
        }
    }

    public Sala getSalaGanadores() {
        return this.salaGanadores;
    }

    public void setSalaGanadores(Sala ganadores) {
        this.salaGanadores = ganadores;
    }

    public int getTurno() {
        return this.turno;
    }

    public void setTurno(int _turno) {
        this.turno = _turno;
    }


    //Módulos para distintas acciones
    public boolean haySala(int id) {
        boolean existe = false;
        for (int i = 0; i < this.getDim1(); i++) {
            for (int j = 0; j < this.getDim2(); j++) {
                if (id == matrizSalas[i][j].getId())
                    existe = true;
                else
                    existe = false;

            }
        }
        return existe;
    }

    public void prepararReparto() {
        Llave[] reparto = new Llave[45];

        int i = 0;
        int j = 0;
        while (i < 45) {
            if (j % 2 != 0) {
                reparto[i] = new Llave(j);
                i++;
                reparto[i] = new Llave(j);
                j++;
                i++;
            } else {
                reparto[i] = new Llave(j);
                i++;
                j++;
            }

        }
        for (int k = 0; k < reparto.length; k++) {
            if (k >= 0 && k < 5) {
                matrizSalas[0][3].insertarLlaveSala(reparto[k]);

            }
            if (k >= 5 && k < 10) {
                matrizSalas[0][4].insertarLlaveSala(reparto[k]);

            }
            if (k >= 10 && k < 15) {

                matrizSalas[1][0].insertarLlaveSala(reparto[k]);
            }
            if (k >= 15 && k < 20) {
                matrizSalas[1][2].insertarLlaveSala(reparto[k]);

            }
            if (k >= 20 && k < 25) {

                matrizSalas[1][3].insertarLlaveSala(reparto[k]);
            }
            if (k >= 25 && k < 30) {

                matrizSalas[1][4].insertarLlaveSala(reparto[k]);
            }
            if (k >= 30 && k < 35) {

                matrizSalas[1][5].insertarLlaveSala(reparto[k]);
            }
            if (k >= 35 && k < 40) {

                matrizSalas[2][0].insertarLlaveSala(reparto[k]);
            }
            if (k >= 40 && k < 45) {
                matrizSalas[2][1].insertarLlaveSala(reparto[k]);

            }

        }


    }


    public void mostrarMapa() {
        System.out.println("(turno: " + this.getTurno() + " )");
        System.out.println("(mapa : " + this.devolverSalaConPuerta() + ")");
        System.out.println("(puerta:" + this.buscarPuertaYMostrarEstado());//mostrar altura de apertura , llaves cerradura, llaves probadas
        for (int i = 0; i < getDim1(); i++) {
            for (int j = 0; j < getDim2(); j++) {
                if (matrizSalas[i][j].existeSala())
                    System.out.println("Sala :" + matrizSalas[i][j].getId());
                // matrizSalas[i][j].mostrarCoordenadas();
                //matrizSalas[i][j].mostrarLlavesSala();
                matrizSalas[i][j].mostrarPersonajeSala();
                if (matrizSalas[i][j].hayLlave())
                    //    System.out.println("Hay Llaves en esta sala");
                    System.out.println();


            }
        }
    }

    public String buscarPuertaYMostrarEstado() {
        for (int i = 0; i < this.Dim1; i++) {
            for (int j = 0; j < this.Dim2; j++) {
                if (matrizSalas[i][j].getExistePuerta()) {
                    if (matrizSalas[i][j].estadoPuerta()) {
                        return "abierta";
                    } else {
                        return "cerrada";
                    }
                }
            }
        }
        return "no se ha encontrado la puerta";
    }

    public int devolverSalaConPuerta() {
        int x = 0;
        for (int i = 0; i < this.Dim1; i++) {
            for (int j = 0; j < this.Dim2; j++) {
                if (matrizSalas[i][j].getExistePuerta()) {
                    x = matrizSalas[i][j].getId();

                }
            }
        }
        return x;
    }

    public boolean BuscarSala(Sala sala) {
        boolean existe = false;
        for (int i = 0; i < this.Dim1; i++) {
            for (int j = 0; j < this.Dim1; j++) {
                if (matrizSalas[i][j] == sala)
                    existe = true;
                else
                    existe = false;

            }

        }
        return existe;
    }

    public void crearYSituarPersonajes() {
        /*Targaryen Daenerys = new Targaryen("Daenerys", 'D', 0);
        matrizSalas[0][0].insertarPersonajesSala(Daenerys);*/
       /* Stark Arya = new Stark("Arya", 'A', 0);
        matrizSalas[0][0].insertarPersonajesSala(Arya);
        Caminante White = new Caminante("White", 'W', 0);
        matrizSalas[5][0].insertarPersonajesSala(White);
        Lannister Tyrion = new Lannister("Tyrion", 'T', 0);
        matrizSalas[5][5].insertarPersonajesSala(Tyrion);*/

    }

    public void ordenMoverYActuar() {
        for (int i = 0; i < this.Dim1; i++) {
            for (int j = 0; j < this.Dim2; j++) {
                while (matrizSalas[i][j].hayPersonaje()) {
                    //accionespersonaje
                }
            }
        }
    }


    public void simulacion() {
        while (this.turno <= 50 || matrizSalas[5][5].estadoPuerta()) {
            procesoSimulador();

            incrementarTurno();
        }


    }


    public void incrementarTurno() {
        this.turno++;
    }

    public enum Dir {S, E, N, O}


    public void pruebaRuta() {
        int coorI = 0;
        int coorJ = 0;
        Targaryen Daenerys = new Targaryen("Daenerys", 'D', 0);
        Dir[] direccionesT = new Dir[]{Dir.E, Dir.S, Dir.S, Dir.S, Dir.O, Dir.S, Dir.E, Dir.E, Dir.N, Dir.E, Dir.S, Dir.S, Dir.E, Dir.E};
        matrizSalas[coorI][coorJ].insertarPersonajesSala(Daenerys);
        Daenerys.asignarSala(matrizSalas[coorI][coorJ]);
        Daenerys.asignarRuta(direccionesT);
        Daenerys.accionesPersonaje();
        Daenerys.mostrarLlaves();


    }

    public Sala buscarYDevolverSalaPorId(int id) {
        Sala aux = null;
        for (int i = 0; i < this.Dim1; i++) {
            for (int j = 0; j < this.Dim2; j++) {
                if (matrizSalas[i][j].getId() == id) {
                    aux = matrizSalas[i][j];
                    // System.out.println("Tu Sala se ha encontrado y es la sala: " + aux.getId());
                }
            }
        }
        return aux;
    }

    public void procesoSimulador() {
        for (int i = 0; i < this.Dim1; i++) {
            for (int j = 0; j < this.Dim2; j++) {
                //personajes acciones
            }
        }
    }


    public static void main(String[] args) {
        Mapa m = new Mapa(6, 6);

        m.setMatrizSalas();

        m.prepararReparto();
        //m.crearYSituarPersonajes();

        m.pruebaRuta();

        m.mostrarMapa();
        m.simulacion();


    }
}




