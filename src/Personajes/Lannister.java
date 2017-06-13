package Personajes;

import entidades.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by adri on 3/01/17.
 */
public class Lannister extends Villanos {
    private List<Llave> listaLlavesLannister = new LinkedList<Llave>();

    public Lannister() {
        super();
        this.listaLlavesLannister = new LinkedList<Llave>();
    }

    public Lannister(String nombre, char marca, int turno) {
        super(nombre, marca, turno);
        this.listaLlavesLannister = new LinkedList<Llave>();
    }


    public void crearLlavesLannister() {
        int j = 1;
        for (int i = 0; i < 15; i++) {
            this.listaLlavesLannister.add(new Llave(j));
            j = j + 2;
        }
    }

    public void mostrarLlaves() {

        for (int i = 0; i < this.listaLlavesLannister.size(); i++) {
            System.out.println(this.listaLlavesLannister.get(i));
        }
    }


    public Llave cogerUltimaLlave() {
        Llave aux = new Llave();
        for (int i = 0; i < this.listaLlavesLannister.size(); i++) {
            if (i + 1 == this.listaLlavesLannister.size()) {
                aux = this.listaLlavesLannister.get(i);
                this.listaLlavesLannister.remove(i);
            }
        }
        return aux;
    }


    public void perderLlave(Sala sala) {
        Llave aux = new Llave();
        if (!this.listaLlavesLannister.isEmpty() && sala.getId() % 2 == 0) {
            sala.insertarLlaveSala(cogerUltimaLlave());
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
