package Personajes;

import entidades.Llave;

import java.util.LinkedList;

/**
 * @author Adrián Fernández Ramos
 * @version 2.0
 */
public class Heroes extends Personajes {
    /**
     * Atributo que guardará las llaves que recogerán los personajes para poder intentar abrir la puerta
     */
    private LinkedList<Llave> llavesRecogidas = new LinkedList<Llave>();

    /**
     * Constructor de la clase Heroes
     */
    public Heroes() {
        super();
        this.llavesRecogidas = new LinkedList<Llave>();
    }

    /**
     * Constructor parametrizado de la clase Heroes
     *
     * @param nombre
     * @param marca
     * @param turno
     */

    public Heroes(String nombre, char marca, int turno) {
        super(nombre, marca, turno);
        this.llavesRecogidas = new LinkedList<Llave>();
    }

    /**
     * Devuelve la última llave que se ha recogido
     *
     * @return aux
     */
    public Llave cogerUltimaLlave() {
        Llave aux;
        aux = this.llavesRecogidas.pollLast();
        return aux;
    }

    /**
     * Muestra todas las llaves que tiene le personaje
     */

    public void mostrarLlaves() {
        for (int i = 0; i < this.llavesRecogidas.size(); i++) {
            if (this.llavesRecogidas.get(i) != null)
                System.out.println("Mis llaves son :" + this.llavesRecogidas.get(i).getId());
        }
    }

    /**
     * Si en la sala en la que estamos hay llaves se recogerá una de ellas
     */
    @Override
    public void accionLlave() {
        if (SalaActual.hayLlave()) {//existen llaves no salas
            this.llavesRecogidas.add(SalaActual.devolverPrimeraLlave());
            System.out.println("Hemos cogido llaves");
            this.mostrarLlaves();
        }

    }

    /**
     * Si hay una puerta en la sala en la que estamos se probará a abrirla con una de nuestras llaves
     */
    @Override
    public void accionPuerta() {
        if (SalaActual.getExistePuerta()) {
            SalaActual.probarLlaveSala(cogerUltimaLlave());
            if (SalaActual.estadoPuerta()) {

                System.out.println("Has abierto la puerta Enhorabuena");
            }
        }
    }
}
