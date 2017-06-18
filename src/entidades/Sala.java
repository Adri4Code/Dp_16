package entidades;

import Personajes.Personajes;

import java.util.LinkedList;

/**
 * @author Adrián Fernández Ramos
 * @version 2.0
 */
public class Sala {
    /**
     * Identificador propio de cada sala
     */
    private int id;
    /**
     * Lista de llaves correspondiente a cada sala
     */
    LinkedList<Llave> listaLlaves = new LinkedList<Llave>();
    /**
     * Lista de personajes que se insertarán en cada sala
     */
    LinkedList<Personajes> colaPersonajes = new LinkedList<Personajes>();
    /**
     * Puntero a puerta que se inicializará si el id corresponde a la sala con la puerta
     */
    private Puerta puerta = null;
    /**
     * Atributo que nos indica si en dicha sala existe una puerta
     */
    private boolean existePuerta;

    /**
     * Constructor de la sala
     */
    public Sala() {
        this.id = 0;
        this.listaLlaves = new LinkedList<Llave>();
        this.colaPersonajes = new LinkedList<Personajes>();
        this.puerta = null;
        this.existePuerta = false;
        if (id == 35) {
            this.puerta = new Puerta();
            this.existePuerta = true;
            this.reconfigurarPuertaSala();
        }
    }

    /**
     * Constructor parametrizado de la puerta
     */
    public Sala(int id) {
        this.id = id;
        this.existePuerta = false;
        this.listaLlaves = new LinkedList<Llave>();
        this.colaPersonajes = new LinkedList<Personajes>();
        if (id == 35) {
            this.puerta = new Puerta();
            this.existePuerta = true;
            this.reconfigurarPuertaSala();
        }
    }

    /**
     * Devuelve el id propio de la sala
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * fija el id puesto por parámetro
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Devuelve si existe o no la puerta
     * @return existePuerta
     */
    public boolean getExistePuerta() {
        return this.existePuerta;
    }

    /**
     * Fija el estado de abierta o cerrada en la puerta
     * @param a
     */
    public void setExistePuerta(boolean a) {
        this.existePuerta = a;
    }

    /**
     * Inserta una llave en la lista de llaves de la sala
     * @param a
     */
    public void insertarLlaveSala(Llave a) {
        this.listaLlaves.add(a);
    }

    /**
     *Muestra todos los id de las llaves de una sala concreta
     */
    public void mostrarLlavesSala() {
        Llave aux;
        if (!this.listaLlaves.isEmpty()) {
            for (int i = 0; i < this.listaLlaves.size(); i++) {
                aux = this.listaLlaves.get(i);
                System.out.println(aux.getId());

            }
        } else {
            System.out.println("No hay llaves en esta Sala");
        }
    }

    /**
     * Devuelve la primera llave de la sala
     * @return aux
     */
    public Llave devolverPrimeraLlave() {
        Llave aux = null;
        if (this.listaLlaves.size() != 0) {
            aux = this.listaLlaves.pollFirst();
        }
        return aux;
    }

    /**
     * Indica si en la sala en cuestión hay una llave o llaves o no
     * @return true || false
     */
    public boolean hayLlave() {

        if (!this.listaLlaves.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Inserta el personaje de forma ordenada actuando de cola
     * @param p
     */
    public void insertarPersonajesSala(Personajes p) {
        this.colaPersonajes.addLast(p);
    }

    /**
     * Devuelve true o false en casa de que haya o no un personaje insertado en la sala
     * @return existe
     */
    public boolean hayPersonaje() {
        boolean existe;
        if (!this.colaPersonajes.isEmpty()) {
            existe = true;
        } else {
            existe = false;
        }
        return existe;
    }

    /**
     * Devuelve el primer personaje que haya sido insertado en la sala
     * @return p
     */
    public Personajes devolverPrimerPersonaje() {
        Personajes p = null;
        if (!this.colaPersonajes.isEmpty()) {
            p = this.colaPersonajes.pollFirst();
        }
        return p;
    }

    /**
     * Muestra los personajes que haya en la sala
     */
    public void mostrarPersonajeSala() {
        if (hayPersonaje() && this.colaPersonajes != null)
            for (int i = 0; i < this.colaPersonajes.size(); i++) {
                System.out.println(this.colaPersonajes.get(i));
            }
        else {
            //System.out.println("No hay ningún personaje en la sala");
        }
    }

    /**
     * Prueba una llave en la configuración de la puerta
     * @param llave
     */
    public void probarLlaveSala(Llave llave) {
        if (this.existePuerta) {
            this.puerta.probarLlave(llave);
        }
    }

    /**
     * Devueleve el estado en el cual esté la puerta
     * @return estadoPuerta
     */
    public boolean estadoPuerta() {
        return this.puerta.getEstadoPuerta();
    }

    /**
     * Reconfigura el estado de la puerta
     */
    public void reconfigurarPuertaSala() {
        if (this.existePuerta) {
            this.puerta.pconfigurar();
        }
    }

    /**
     * Dice si existe o no una sala muy útil a la hora de realizar movimientos
     * @return true || false
     */
    public boolean existeSala() {
        boolean existe = false;
        if (this.id > 0 && this.id < 36) {
            existe = true;
        } else {
            existe = false;
        }

        return existe;
    }


    /**
     * Devuelve el primer personaje de la sala si se ha insertado
     *
     * @return aux
     */
    public Personajes getFrente() {
        Personajes aux = null;
        if (this.colaPersonajes.peekFirst() != null)
            aux = this.colaPersonajes.pollFirst();
        return aux;
    }

    /**
     * algoritmo de simulación de la EC2
     */
    public void simular() {
        Mapa m = Mapa.getInstanciaMapa();
        Personajes p;
        int cont = 0;
        while (cont < this.colaPersonajes.size()) {
            p = this.colaPersonajes.peekFirst();
            if (p != null) {
                if (p.getTurno() == m.getTurno()) {
                    p.accionesPersonaje();
                }
            }
            cont++;
        }
    }
}

