package Personajes;

import entidades.Llave;

import java.util.LinkedList;

/**
 * @author Adrián Fernández Ramos
 * @version 2.0
 */
public class Lannister extends Villanos {
    /**
     * Atributo que almacena todas las llaves que irá repartiendo a lo largo del mapa
     */
    private LinkedList<Llave> listaLlavesLannister = new LinkedList<Llave>();

    /**
     * Constructor de la clase Lannister
     */
    public Lannister() {
        super();
        this.listaLlavesLannister = new LinkedList<Llave>();
        crearLlavesLannister();
    }

    /**
     * Constructor parametrizado de la clase Lannister
     *
     * @param nombre
     * @param marca
     * @param turno
     */
    public Lannister(String nombre, char marca, int turno) {
        super(nombre, marca, turno);
        this.listaLlavesLannister = new LinkedList<Llave>();
        crearLlavesLannister();
    }

    /**
     * Método que crea todas las llaves del personaje Lannister
     */
    public void crearLlavesLannister() {
        int j = 1;
        for (int i = 0; i < 15; i++) {
            this.listaLlavesLannister.add(new Llave(j));
            j = j + 2;
        }
    }

    /**
     * Método que muestra todas las llaves del personaje Lannister
     */
    public void mostrarLlaves() {

        for (int i = 0; i < this.listaLlavesLannister.size(); i++) {
            System.out.println(this.listaLlavesLannister.get(i));
        }
    }

    /**
     * Devuelve la última llave del personaje Lannister
     *
     * @return aux
     */
    public Llave cogerUltimaLlave() {
        Llave aux;
        aux = this.listaLlavesLannister.pollLast();
        return aux;
    }

    /**
     * Acción que deja las llaves en las salas pares
     */
    @Override
    public void accionLlave() {
        Llave aux = new Llave();
        if (!this.listaLlavesLannister.isEmpty() && SalaActual.getId() % 2 == 0) {
            SalaActual.insertarLlaveSala(cogerUltimaLlave());
        }
    }


    /*public static void main(String[] args) {
        Lannister Eddard = new Lannister("Eddard", 'E',0);
        Llave aux = new Llave();
        Eddard.crearLlavesLannister();

        System.out.println(Eddard.listaLlavesLannister.size());
        aux = Eddard.cogerUltimaLlave();
        System.out.println(Eddard.listaLlavesLannister.size());


        System.out.println(aux.getId());
    }*/
}
