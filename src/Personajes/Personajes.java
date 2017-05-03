package Personajes;

import entidades.Mapa;
import entidades.Sala;

/**
 * Created by adri on 3/01/17.
 */
public abstract class Personajes {
    protected String nombre;
    protected char marca;
    protected int turno;
    protected Sala SalaActual;
    protected int[] coordenadasActuales;
    //TODO:Herencia y polimorfismo


    protected Mapa.Dir[] rutaPersonaje = new Mapa.Dir[200];


    public Personajes() {
        this.marca = 'P';
        this.nombre = "";
        this.turno = 0;
        this.SalaActual = new Sala();
        this.coordenadasActuales = new int[2];
        for (int i = 0; i < this.coordenadasActuales.length; i++) {
            this.coordenadasActuales[i] = 0;
        }

    }

    public Personajes(String nombre, char marca, int turno) {
        this.nombre = nombre;
        this.marca = marca;
        this.turno = turno;
        this.SalaActual = new Sala();
        this.coordenadasActuales = new int[2];
        for (int i = 0; i < this.coordenadasActuales.length; i++) {
            this.coordenadasActuales[i] = 0;
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getMarca() {
        return this.marca;
    }

    public void setMarca(char marca) {
        this.marca = marca;
    }

    public int getTurno() {
        return this.turno;
    }

    public void setTurno(int _turno) {
        this.turno = _turno;
    }

    public void asignarRuta(Mapa.Dir[] ruta1) {
        rutaPersonaje = ruta1;

    }

    public void DevolverRuta() {
        for (int i = 0; i < this.rutaPersonaje.length; i++) {
            System.out.println(this.rutaPersonaje[i]);
        }
    }

    public int[] getCoordenadasActuales() {
        return this.coordenadasActuales;
    }

    public void setCoordenadasActuales(int i, int j) {
        this.coordenadasActuales[0] = i;
        this.coordenadasActuales[1] = j;
    }

    public Sala getSalaActual() {
        return this.SalaActual;
    }

    public void asignarSala(Sala sala) {
        SalaActual = sala;
    }

    public void movimientoPersonaje() {

        Personajes p;
        Mapa miniMapa = Mapa.getInstanciaMapa();


        if (this.rutaPersonaje[turno] == Mapa.Dir.S) {
            // asignarSala(miniMapa[this.coordenadasActuales[0]][this.coordenadasActuales[1]]);
            if (SalaActual.existeSala()) {

                p = SalaActual.devolverPrimerPersonaje();
                this.coordenadasActuales = SalaActual.getCoordenadas();
                this.coordenadasActuales[0]++;
                //asignarSala(miniMapa[this.coordenadasActuales[0]][this.coordenadasActuales[1]]);
                SalaActual.insertarPersonajesSala(p);
                System.out.println("Movido hacia el sur");
            }


        }
        if (this.rutaPersonaje[turno] == Mapa.Dir.E) {
            //asignarSala(miniMapa[this.coordenadasActuales[0]][this.coordenadasActuales[1]]);
            if (SalaActual.existeSala()) {
                p = SalaActual.devolverPrimerPersonaje();
                this.coordenadasActuales = SalaActual.getCoordenadas();
                this.coordenadasActuales[1]++;
                //asignarSala(miniMapa[this.coordenadasActuales[0]][this.coordenadasActuales[1]]);
                SalaActual.insertarPersonajesSala(p);
                System.out.println("Movido hacia el Este");
            }

        }
        if (this.rutaPersonaje[turno] == Mapa.Dir.N) {
            //asignarSala(miniMapa[this.coordenadasActuales[0]][this.coordenadasActuales[1]]);
            if (SalaActual.existeSala()) {
                p = SalaActual.devolverPrimerPersonaje();
                this.coordenadasActuales = SalaActual.getCoordenadas();
                this.coordenadasActuales[0]--;
                //asignarSala(miniMapa[this.coordenadasActuales[0]][this.coordenadasActuales[1]]);
                SalaActual.insertarPersonajesSala(p);

                System.out.println("Movido hacia el norte");
            }

        }
        if (this.rutaPersonaje[turno] == Mapa.Dir.O) {
            // asignarSala(miniMapa[this.coordenadasActuales[0]][this.coordenadasActuales[1]]);
            if (SalaActual.existeSala()) {
                p = SalaActual.devolverPrimerPersonaje();
                this.coordenadasActuales = SalaActual.getCoordenadas();
                this.coordenadasActuales[1]--;
                // asignarSala(miniMapa[this.coordenadasActuales[0]][this.coordenadasActuales[1]]);
                SalaActual.insertarPersonajesSala(p);

                System.out.println("Movido hacia el Oeste");
            }

        }


    }


    public void incrementarTurnoPeronaje() {
        this.turno++;
    }

    abstract void accionPuerta();


}
