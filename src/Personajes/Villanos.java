package Personajes;

/**
 * @author Adrián Fernández Ramos
 * @version 2.0
 */
public abstract class Villanos extends Personajes {
    /**
     * Consructor de la clase Villanos
     */
    public Villanos() {
        super();
    }

    /**
     * Consructor parametrizado de la clase Villanos
     *
     * @param nombre
     * @param marca
     * @param turno
     */
    public Villanos(String nombre, char marca, int turno) {
        super(nombre, marca, turno);
    }

    /**
     * Acción con respecto a la puerta que realizarán los Villanos
     */
    @Override
    public void accionPuerta() {
        if (SalaActual.getExistePuerta()) {
            SalaActual.reconfigurarPuertaSala();
        }
    }


}
