package entidades;

import Personajes.Personajes;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by adri on 28/12/16.
 */
public class Sala {
    private int id;
    List<Llave> listaLlaves = new LinkedList<Llave>();
    Queue<Personajes> colaPersonajes = new LinkedList<Personajes>();
    private Puerta p = null;
    private boolean existePuerta = false;

    public Sala() {
        this.id = 0;
        this.p = null;
        this.existePuerta = false;
    }
    public Sala(int id) {
        this.id = id;
        if (id == 35) {
            this.p = new Puerta();
            this.existePuerta = true;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void insertarLlaveSala(Llave a) {
        this.listaLlaves.add(a);
    }

    public void mostrarLlavesSala() {
        for (int i = 0; i < listaLlaves.size(); i++) {
            System.out.println(listaLlaves.get(i));
        }
    }

    public void insertarPersonajesSala(Personajes p) {
        this.colaPersonajes.add(p);
    }

}
