package entidades;

import Personajes.Caminante;
import Personajes.Lannister;
import Personajes.Stark;
import Personajes.Targaryen;

/**
 * @author Adrián Fernández Ramos
 * @version 2.0
 */
public class Mapa {
    /**
     * Atributo con el que definiremos la primera dimensión del tablero del mapa
     */
    private int Dim1;
    /**
     * Atributo con el que definiremos la segunda dimensión del tablero del mapa
     */
    private int Dim2;
    /**
     * Matriz de Salas en la que se realizarán todas las acciones correspondientes
     */
    private Sala[][] matrizSalas;
    /**
     * Sala en la que se introducirán los ganadores del juego
     */
    Sala salaGanadores = new Sala(1111);
    /**
     * Turno correspondiente para el mapa
     */
    private int turno = 0;
    /** Atributo de la clase mapa de tipo mapa para poder devolver la instancia a partir del patrón Singleton*/
    private static Mapa mapa = null;

    /**
     * Constructor privado sin parametrizar
     */
    private Mapa() {
        this.Dim1 = 6;
        this.Dim2 = 6;
        int k = 0;
        this.matrizSalas = new Sala[Dim1][Dim2];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                this.matrizSalas[i][j] = new Sala(k);
                k++;

            }
        }
        this.salaGanadores = new Sala(1111);
        this.turno = 0;


    }

    /** Crea el mapa si no está creado por el contrario , lo devuelve
     * @return mapa
     * */
    public static Mapa getInstanciaMapa() {
        if (mapa == null) {
            mapa = new Mapa();
        }

        return mapa;
    }

    /**
     * Constructor privado y parametrizado para la creación correcta del mapa
     * @param Dim1
     * @param Dim2
     */
    private Mapa(int Dim1, int Dim2) {
        int k = 0;
        this.matrizSalas = new Sala[Dim1][Dim2];
        setDim1(Dim1);
        setDim2(Dim2);
        for (int i = 0; i < this.getDim1(); i++) {
            for (int j = 0; j < this.getDim2(); j++) {
                this.matrizSalas[i][j] = new Sala(k);
                k++;
            }
        }
        this.salaGanadores = new Sala(1111);
        this.turno = 0;
    }

    /**
     * Si el mapa no está creado crea uno nuevo , en caso contrario lo devuelve para poder manejarlo
     * @param dim1
     * @param dim2
     * @return mapa
     */
    public static Mapa getInstanciaMapaDim(int dim1, int dim2) {
        if (mapa == null) {
            mapa = new Mapa(dim1, dim2);
        }
        return mapa;
    }


    //Getters and Setters

    /**
     *  Fija la primera dimensión que queramos en el mapa
     * @param Dim1
     */
    public void setDim1(int Dim1) {
        this.Dim1 = Dim1;
    }

    /**
     * Devuelve la primera dimensión actual del mapa
     * @return Dim1
     */
    public int getDim1() {
        return this.Dim1;
    }

    /**
     *  Fija la segunda dimensión que queramos en el mapa
     * @param DIM2
     */
    public void setDim2(int DIM2) {
        this.Dim2 = DIM2;
    }

    /**
     * Devuelve la segunda dimensión actual del mapa
     * @return Dim1
     */
    public int getDim2() {
        return this.Dim2;
    }

    /**
     * Devuelve la sala en la que se encuentran los ganadores del juego
     * @return salaGanadores
     */
    public Sala getSalaGanadores() {
        return this.salaGanadores;
    }

    /**
     * Fija la sala de ganadores que queramos
     * @param ganadores
     */
    public void setSalaGanadores(Sala ganadores) {
        this.salaGanadores = ganadores;
    }

    /**
     * Devuelve el turno actual que tenga el mapa
     * @return turno
     */
    public int getTurno() {
        return this.turno;
    }

    /**
     *Fija el turno que queramos para el mapa
     * @param _turno
     */
    public void setTurno(int _turno) {
        this.turno = _turno;
    }


    //Módulos para distintas acciones


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

    /**
     * Muestra todas la connotaciones importantes a mostrar en el mapa
     */
    public void mostrarMapa() {
        System.out.println("(turno: " + this.getTurno() + " )");
        System.out.println("(mapa : " + this.devolverSalaConPuerta() + ")");
        System.out.println("(puerta:" + this.buscarPuertaYMostrarEstado());//mostrar altura de apertura , llaves cerradura, llaves probadas
        for (int i = 0; i < getDim1(); i++) {
            for (int j = 0; j < getDim2(); j++) {
                if (this.matrizSalas[i][j].existeSala())
                    System.out.println("Sala :" + this.matrizSalas[i][j].getId());
                //matrizSalas[i][j].mostrarCoordenadas();
                // matrizSalas[i][j].mostrarLlavesSala();
                matrizSalas[i][j].mostrarPersonajeSala();
                if (matrizSalas[i][j].hayLlave()) {
                    System.out.println("Hay Llaves en esta sala");
                    matrizSalas[i][j].mostrarLlavesSala();
                    System.out.println();
                }


            }
        }
    }

    /**
     *
     * @return "abierta" || "cerrada" || "no se ha encontrado la puerta"
     */
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

    /**
     * Devuelve el id de la sala la cual tenga la puerta
     * @return x
     */
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

    /**
     * Creamos y situamos los personajes
     */
    public void crearYSituarPersonajes() {
        Sala aux;
        Targaryen Daenerys = new Targaryen("Daenerys", 'D', 0);
        String[] direccionesT = new String[]{"E", "S", "S", "S", "O", "S",
                "E", "E", "N", "E", "S", "S", "E", "E"};
        Daenerys.asignarRuta(direccionesT);

        Daenerys.asignarSala(buscarYDevolverSalaPorId(0));
        matrizSalas[0][0].insertarPersonajesSala(Daenerys);


        Stark Arya = new Stark("Arya", 'A', 0);
        String[] direccionesS = new String[]{"S", "S", "E", "E", "N", "E",
                "N", "E", "S", "E", "S", "S", "O", "S", "E", "S"};
        Arya.asignarRuta(direccionesT);
        Arya.asignarSala(buscarYDevolverSalaPorId(0));
        matrizSalas[0][0].insertarPersonajesSala(Arya);

        Caminante White = new Caminante("White", 'W', 0);
        String[] direccionesC = new String[]{"N", "N", "N", "E", "S", "E",
                "N", "N", "E", "N", "E", "E", "S", "S", "S", "S", "S"};
        White.asignarRuta(direccionesT);
        White.asignarSala(buscarYDevolverSalaPorId(30));
        matrizSalas[0][5].insertarPersonajesSala(White);

        Lannister Tyrion = new Lannister("Tyrion", 'T', 0);
        String[] direccionesL = new String[]{"N", "N", "O", "N", "N", "O",
                "S", "O", "O", "N", "N", "O", "S", "S", "S", "S", "S", "E", "E", "E", "E", "E"};
        Tyrion.asignarRuta(direccionesT);
        Tyrion.asignarSala(buscarYDevolverSalaPorId(35));
        matrizSalas[5][5].insertarPersonajesSala(Tyrion);
    }

    /**
     * Devuelve el número de salas del mapa
     *
     * @return num
     */
    public int obtenerNumeroDeSalas() {
        int num = 0;
        for (int i = 0; i < this.Dim1; i++) {
            for (int j = 0; j < this.Dim2; j++) {
                if (matrizSalas[i][j].existeSala())
                    num++;
            }

        }
        return num;
    }

    /**
     * Busca la sala en la cual está la puerta y devuelve el estado de la puerta
     *
     * @return aux
     */
    public Sala buscarPuertaYDevolverEstado() {
        Sala aux = null;
        Mapa m = getInstanciaMapa();
        for (int i = 0; i < m.getDim1(); i++) {
            for (int j = 0; j < m.getDim2(); j++) {
                if (matrizSalas[i][j].getExistePuerta()) {
                    System.out.println("La puerta ha sido encontrada ");
                    boolean enc = false;
                    aux = buscarYDevolverSalaPorId(matrizSalas[i][j].getId());
                    enc = aux.getExistePuerta();
                    if (enc) {
                        System.out.println("La sala con la puerta es " + aux.getId());
                    }
                }

            }
        }
        return aux;
    }

    /**
     * Algoritmo de simulación de la EC2
     */
    public void simulacion() {
        mostrarMapa();
        int contador = 0;
        Sala salaConPuerta = null;
        salaConPuerta = buscarPuertaYDevolverEstado();
        while (this.turno < 50 && !salaConPuerta.estadoPuerta()) {
            contador = 0;
            while (contador < obtenerNumeroDeSalas()) {
                Sala s = buscarYDevolverSalaPorId(contador);
                s.simular();
                contador++;
            }


            turno++;
        }


    }


    /**
     * Busca una sala por id y devuelve true en caso de que exista
     *
     * @param id
     * @return true || false
     */
    public boolean existeSalaPorId(int id) {
        boolean existe = false;
        for (int i = 0; i < this.Dim1; i++) {
            for (int j = 0; j < this.Dim2; j++) {
                if (matrizSalas[i][j].getId() == id) {
                    existe = true;
                }
            }

        }
        return existe;
    }

    /**
     * Busca una sala por id y en caso de encontrarla la devuelve
     * @param id
     * @return aux
     */
    public Sala buscarYDevolverSalaPorId(int id) {
        Sala aux = new Sala(99);
        for (int i = 0; i < this.Dim1; i++) {
            for (int j = 0; j < this.Dim2; j++) {
                if (matrizSalas[i][j].getId() == id) {
                    aux = matrizSalas[i][j];
                }
            }
        }
        return aux;
    }


    public static void main(String[] args) {
        Mapa m = null;
        Sala aux = null;
        m = getInstanciaMapaDim(6, 6);
        System.out.println("Turno del mapa:" + m.getTurno());
        m.prepararReparto();
        m.crearYSituarPersonajes();
        m.simulacion();
        m.mostrarMapa();


    }
}




