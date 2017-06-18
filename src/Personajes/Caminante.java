package Personajes;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Adrián Fernández Ramos
 * @version 2.0
 */
public class Caminante extends Villanos {
    /**
     * Atributo que irá almacenando todos los personajes que irá recogiendo nuestro caminante
     */
    private List<Personajes> personajesRecogidos = new LinkedList<Personajes>();

    /**
     * Constructor de la clase Caminante
     */
    public Caminante() {
        super();
        this.personajesRecogidos = new LinkedList<Personajes>();
    }

    /**
     * Constructor oarametrizado de la clase Caminante
     *
     * @param nombre
     * @param marca
     * @param turno
     */
    public Caminante(String nombre, char marca, int turno) {
        super(nombre, marca, turno);
        this.personajesRecogidos = new LinkedList<Personajes>();
    }

    /**
     * Lo hemos llamado accionLlave para hacer correctamente la herencia , pero en realidad recoge un personaje
     */
    @Override
    public void accionLlave() {
        if (SalaActual.hayPersonaje()) {
            this.personajesRecogidos.add(SalaActual.devolverPrimerPersonaje());

        }
    }
}
