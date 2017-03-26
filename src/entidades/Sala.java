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

    public Llave devolverPrimeraLlave() {
        Llave aux = this.listaLlaves.get(0);
        this.listaLlaves.remove(0);
        return aux;
    }

    public boolean hayLlave() {

        if (!this.listaLlaves.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void insertarPersonajesSala(Personajes p) {
        this.colaPersonajes.add(p);
    }


    public boolean hayPersonaje() {
        boolean existe;
        if (!this.colaPersonajes.isEmpty()) {
            existe = true;
        } else {
            existe = false;
        }
        return existe;
    }

    public Personajes devolverPrimerPersonaje() {
        Personajes p = null;
        if (!this.colaPersonajes.isEmpty()) {
            p = this.colaPersonajes.poll();
        }
        return p;
    }

    public void mostrarPersonajeSala() {
        if (hayPersonaje() && this.colaPersonajes != null)
            System.out.println(this.colaPersonajes.peek());
        else {
            System.out.println("No hay ningún personaje en la sala");
        }
    }

    public void probarLlaveSala(Llave llave) {
        if (this.existePuerta) {
            this.puerta.probarLlave(llave);
        }
    }

    public boolean estadoPuerta() {
        return this.puerta.getEstadoPuerta();
    }

    public void reconfigurarPuertaSala() {
        if (this.existePuerta) {
            this.puerta.pconfigurar();
        }
    }

    public boolean existeSala() {
        boolean existe = false;
        if (this.id > 0 && this.id < 36)
            existe = true;
        else
            existe = false;

        return existe;
    }

    //TODO:Métdo existe puerta


}
