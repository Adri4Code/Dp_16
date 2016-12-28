package entidades;

/**
 * Created by adri on 18/12/16.
 */

/**
 * Implementación de la clase Llave
 *
 * @author adri
 * @version 1.1
 */
public class Llave implements Comparable<Llave> {
    /**
     * Identificador de la Llave
     */
    private int id;

    /**
     * Constructor por defecto de la clase
     */
    public Llave() {
        this.id = 0;
    }

    /**
     * Crea una llave a través de los datos pasados por parámetro
     * @param ID
     */
    public Llave(int ID) {
        this.id = ID;
    }

    /**
     * Establece el identificador que quieras a una llave
     * @param ID
     */
    public void setId(int ID) {
        this.id = ID;
    }

    /**
     * Devuelve el identificador de la llave
     * @return Identificador de la llave
     */
    public int getId() {
        return this.id;
    }

    /**
     * Compara dos llaves y devuelve un entero en función de su valor
     * @param o una llave cualquiera
     * @return 1 si es mayor 0 si es igual -1 si es menor
     */
    @Override
    public int compareTo(Llave o) {
        if (this.id == o.id) {
            return 0;
        }
        if (this.id > o.id)
            return 1;
        else
            return -1;


    }


    /**
     * Compara si dos llaves son iguales o no lo son
     * @param obj una llave cualquiera
     * @return true || false
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Llave)) return false;
        if (((Llave) obj).id == this.id) return true;
        return super.equals(obj);
    }


}
