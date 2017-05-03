package Personajes;

import entidades.Llave;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by adri on 27/04/17.
 */
public class Heroes extends Personajes {
    private List<Llave> llavesRecogidas = new LinkedList<Llave>();

    public Heroes() {
        super();
        this.llavesRecogidas = new LinkedList<Llave>();
    }

    public Heroes(String nombre, char marca, int turno) {
        super(nombre, marca, turno);
        this.llavesRecogidas = new LinkedList<Llave>();
    }

    public Llave cogerUltimaLlave() {
        Llave aux = new Llave();

        for (int i = 0; i < this.llavesRecogidas.size(); i++) {
            if (i + 1 == this.llavesRecogidas.size()) {
                aux = this.llavesRecogidas.get(i);
                this.llavesRecogidas.remove(i);
            }
        }
        return aux;
    }

    public void mostrarLlaves() {
        for (int i = 0; i < this.llavesRecogidas.size(); i++) {
            System.out.println(this.llavesRecogidas.get(i));
        }
    }

    public void recogerLlave() {
        if (SalaActual.existeSala()) {
            this.llavesRecogidas.add(SalaActual.devolverPrimeraLlave());
            System.out.println("Hemos cogido llaves");
            //this.mostrarLlaves();
        }

    }

    @Override
    public void accionPuerta() {
        if (SalaActual.getExistePuerta()) {
            SalaActual.probarLlaveSala(cogerUltimaLlave());
            if (SalaActual.estadoPuerta()) {
                System.out.println("Has abierto la puerta Enhorabuena");
            }
        } else {//En cada turno solo puedo probar una llave
            movimientoPersonaje();
        }
    }
}
