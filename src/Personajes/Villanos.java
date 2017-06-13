package Personajes;

/**
 * Created by adri on 27/04/17.
 */
public class Villanos extends Personajes {
    public Villanos() {
        super();
    }

    public Villanos(String nombre, char marca, int turno) {
        super(nombre, marca, turno);
    }

    public void CerrarPuerta() {

    }
    @Override
    public void accionPuerta() {
        if (SalaActual.getExistePuerta()) {
            SalaActual.reconfigurarPuertaSala();
            movimientoPersonaje();
        }
    }
}
