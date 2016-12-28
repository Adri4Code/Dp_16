package entidades;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by adri on 28/12/16.
 */
public class Sala {
    private int id;
    List<Llave> listaLlaves = new LinkedList<Llave>();
    private Puerta p = null;

    public Sala() {
        this.id = 0;
        this.p = null;
    }
    public Sala(int id) {
        this.id = id;
        if (id == 35) {
            this.p = new Puerta();
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
}
