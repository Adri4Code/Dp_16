package Personajes;

import entidades.Mapa;
import entidades.Sala;

import java.util.LinkedList;

/**
 * @author Adrián Fernández Ramos
 * @version 2.0
 */
public abstract class Personajes {
    /**
     * Nombre del personaje
     */
    protected String nombre;
    /**
     * Marca del personaje que aparecerá en el mapa
     */
    protected char marca;

    /**
     * Turno actual del personaje
     */
    protected int turno = 0;

    /**
     * Sala en la que se encontrará el personaje
     */
    protected Sala SalaActual;

    /**
     * Ruta que tendrá que seguir el personaje
     */
    protected LinkedList<String> Ruta = new LinkedList<String>();

    /**
     * Constructor del personaje
     */
    public Personajes() {
        this.marca = 'P';
        this.nombre = "";
        this.turno = 0;
        this.SalaActual = new Sala(45);

    }

    /**
     * Constructor parametrizado del personaje
     *
     * @param nombre
     * @param marca
     * @param turno
     */
    public Personajes(String nombre, char marca, int turno) {
        this.nombre = nombre;
        this.marca = marca;
        this.turno = turno;
        this.SalaActual = new Sala(45);
    }

    /**
     * Devuelve el nombre del personaje
     *
     * @return nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Fija el nombre al personaje
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la marca del personaje en cuestión
     * @return marca
     */
    public char getMarca() {
        return this.marca;
    }

    /**
     * Fija la marca que se requiera para el personaje en cuestión
     * @param marca
     */
    public void setMarca(char marca) {
        this.marca = marca;
    }

    /**
     * Devuelve el turno del personaje
     * @return turno
     */
    public int getTurno() {
        return this.turno;
    }

    /**
     * Fija el turno del personaje
     * @param _turno
     */
    public void setTurno(int _turno) {
        this.turno = _turno;
    }

    /**
     * Asigna la ruta en cuestión al personaje
     *
     * @param ruta1
     */
    public void asignarRuta(String[] ruta1) {
        for (int i = 0; i < ruta1.length; i++) {
            this.Ruta.addLast(ruta1[i]);
        }
    }

    /**
     * Devuelve la ruta del personaje
     *
     * @return
     */
    public LinkedList DevolverRuta() {
        return this.Ruta;
    }

    /**
     * Devuelve la sala en la que se encuentre el personaje
     * @return SalaActual
     */
    public Sala getSalaActual() {
        return this.SalaActual;
    }

    /**
     * Asigna la sala en la que se encuentre el personaje
     * @param sala
     */
    public void asignarSala(Sala sala) {

        this.SalaActual = sala;

    }

    /**
     * Método que hace que los personajes se muevan a través de
     * buscar salas y la ruta que tenga en cuestión en ese momento
     *
     */
    public void movimientoPersonaje() {

        Personajes p;
        Sala aux;
        Mapa m = Mapa.getInstanciaMapa();
        int numActual = 0;
        String movimiento = "";
        if (!this.Ruta.isEmpty()) {
            movimiento = this.Ruta.getFirst();
            this.Ruta.removeFirst();

            System.out.println("Soy el personaje " + this.getNombre() + " y me voy a mover ");
            if (movimiento == "S") {
                p = SalaActual.devolverPrimerPersonaje();

                if (m.existeSalaPorId(SalaActual.getId() + 6)) {

                    aux = m.buscarYDevolverSalaPorId(SalaActual.getId() + m.getDim1());
                    numActual = aux.getId();
                    System.out.println("La nueva sala es : " + numActual);
                    this.asignarSala(aux);
                    SalaActual.insertarPersonajesSala(p);
                    System.out.println("Movido hacia el sur ");
                } else {
                    System.out.println("La sala a la que se quiere mover el personaje no existe");
                }


            }
            if (movimiento == "E") {
                p = SalaActual.devolverPrimerPersonaje();
                if (m.existeSalaPorId(SalaActual.getId() + 1)) {
                    aux = m.buscarYDevolverSalaPorId(SalaActual.getId() + 1);
                    this.asignarSala(aux);
                    SalaActual.insertarPersonajesSala(p);
                    System.out.println("Movido hacia el sur ");
                } else {
                    System.out.println("La sala a la que se quiere mover el personaje no existe");
                }

            }
            if (movimiento == "N" ) {
                p = SalaActual.devolverPrimerPersonaje();
                if (m.existeSalaPorId(SalaActual.getId() - m.getDim1())) {
                    aux = m.buscarYDevolverSalaPorId(SalaActual.getId() - m.getDim1());
                    this.asignarSala(aux);
                    SalaActual.insertarPersonajesSala(p);
                    System.out.println("Movido hacia el sur ");
                } else {
                    System.out.println("La sala a la que se quiere mover el personaje no existe");
                }

            }
            if (movimiento == "O" ) {
                p = SalaActual.devolverPrimerPersonaje();
                if (m.existeSalaPorId(SalaActual.getId() - 1)) {
                    aux = m.buscarYDevolverSalaPorId(SalaActual.getId() - 1);
                    this.asignarSala(aux);
                    SalaActual.insertarPersonajesSala(p);
                    System.out.println("Movido hacia el sur ");
                } else {
                    System.out.println("La sala a la que se quiere mover el personaje no existe");
                }

            }

        }
    }

    /**
     * Acción correspondiente que tenga que hacer el personaje
     */
    abstract void accionPuerta();

    /**
     * Acción con llaves que tenga que hacer el personaje
     */
    abstract void accionLlave();

    /**
     * El conjunto de todas las acciones del personaje a la hora
     * de hacer la simulación de la EC2
     */
    public void accionesPersonaje() {
        Mapa m = Mapa.getInstanciaMapa();
        accionPuerta();
        movimientoPersonaje();
        accionLlave();

        this.turno++;
    }
}
