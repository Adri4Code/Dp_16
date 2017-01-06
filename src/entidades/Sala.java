package entidades;

import Personajes.*;

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
    private Puerta puerta = null;
    private boolean existePuerta;

    public Sala() {
        this.id = 0;
        this.listaLlaves = new LinkedList<Llave>();
        this.colaPersonajes = new LinkedList<Personajes>();
        this.puerta = null;
        this.existePuerta = false;
    }

    public Sala(int id) {
        this.id = id;
        this.existePuerta = false;
        this.listaLlaves = new LinkedList<Llave>();
        this.colaPersonajes = new LinkedList<Personajes>();
        if (id == 35) {
            this.puerta = new Puerta();
            this.existePuerta = true;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getExistePuerta() {
        boolean existe = false;
        if (this.id == 35) {
            existe = true;
            this.existePuerta = existe;
        }
        return this.existePuerta;
    }

    public void setExistePuerta(boolean a) {
        this.existePuerta = a;
    }

    public void insertarLlaveSala(Llave a) {
        this.listaLlaves.add(a);
    }

    public void mostrarLlavesSala() {
        for (int i = 0; i < listaLlaves.size(); i++) {
            System.out.println(listaLlaves.get(i));
        }
    }

    public Llave devolverPrimeraLlave() {
        Llave aux = this.listaLlaves.get(0);
        this.listaLlaves.remove(0);
        return aux;
    }

    public boolean hayLlave() {
        boolean existe;
        if (this.listaLlaves.isEmpty()) {
            existe = false;
        } else {
            existe = true;
        }
        return existe;
    }

    public void insertarPersonajesSala(Personajes p) {
        this.colaPersonajes.add(p);
    }


    public boolean hayPersonaje() {
        boolean existe;
        if (this.colaPersonajes.isEmpty()) {
            existe = false;
        } else {
            existe = true;
        }
        return existe;
    }

    public Personajes devolverPrimerPersonaje() {
        Personajes aux = this.colaPersonajes.peek();
        this.colaPersonajes.remove();
        return aux;
    }

    public void probarLlaveSala(Llave llave) {
        if (this.existePuerta) {
            this.puerta.probarLlave(llave);
        }
    }

    public void reconfigurarPuertaSala() {
        if (this.existePuerta) {
            this.puerta.pconfigurar();
        }
    }


}
