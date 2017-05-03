package Personajes;

/**
 * Created by adri on 27/04/17.
 */
public class Villanos extends Personajes {
    @Override
    public void accionPuerta() {
        if (SalaActual.getExistePuerta()) {
            SalaActual.reconfigurarPuertaSala();
            movimientoPersonaje();
        }
    }
}
