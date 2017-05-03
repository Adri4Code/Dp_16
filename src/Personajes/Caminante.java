package Personajes;

import entidades.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by adri on 3/01/17.
 */
public class Caminante extends Villanos {
    //TODO:Finalizar Herencia en Caminante y Lannister
    private List<Personajes> personajesRecogidos = new LinkedList<Personajes>();

    public Caminante() {
        super();
        this.personajesRecogidos = new LinkedList<Personajes>();
    }

    public Caminante(String nombre, char marca, int turno) {
        super(nombre, marca, turno);
        this.personajesRecogidos = new LinkedList<Personajes>();
    }


    public void recogerPersonaje(Sala sala) {
        if (sala.hayPersonaje()) {
            this.personajesRecogidos.add(sala.devolverPrimerPersonaje());

        }
    }
}
