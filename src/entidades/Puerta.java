package entidades;

/**
 * Created by adri on 18/12/16.
 */

/**
 * Implemetación de la clase Puerta
 *
 * @author adri
 * @version 1.1
 */
public class Puerta {
    /**
     * Arbol de llaves , el cual , forma la cerradura de la puerta
     */
    private Arbol<Llave> cerradura = new Arbol<Llave>();
    /**
     * Arbol de llaves probadas para intentar abrir la puerta
     */
    private Arbol<Llave> probadas = new Arbol<Llave>();
    /**
     * Atributo que indica si la puerta esta cerrada o abierta
     */
    private boolean abiertaCerradura = false;
    /**
     * Vector de llaves con el cual se forma la cerradura
     */
    Llave[] impares = {new Llave(1), new Llave(3), new Llave(5), new Llave(7), new Llave(9),
            new Llave(11), new Llave(13), new Llave(15), new Llave(17), new Llave(19),
            new Llave(21), new Llave(23), new Llave(25), new Llave(27), new Llave(29)};
    /**
     * Atributo entero con el que se compara la profundidad del arbol
     */
    private int profundidad;

    /**
     * Constructor por defecto de la Puerta
     */
    public Puerta() {
        this.profundidad = 0;
        this.cerradura = new Arbol<Llave>();
        this.probadas = new Arbol<Llave>();
        this.abiertaCerradura = false;
    }

    /**
     * Devuelve la constante que hayamos fijado para compararla con la profundidad del arbol
     * @return profundidad
     */
    public int getProfundidad() {
        return this.profundidad;
    }

    /**
     * Fija la constante  para compararla con la profundidad del arbol
     * @param profundidad
     */

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    /**
     * Devuelve el estado de la puerta si esta abierta o cerrada
     *
     * @return el estado de mi puerta
     */
    public boolean getEstadoPuerta() {
        return this.abiertaCerradura;
    }

    /**
     * Fijamos como queremos que este la puerta cerrada o abierta
     *
     * @param estadoPuerta
     */
    public void setEstadoPuerta(boolean estadoPuerta) {
        this.abiertaCerradura = estadoPuerta;
    }

    /**
     * Método previo para configurar las llaves de la cerradura
     */
    public void pconfigurar() {

        int primero = 0;
        int ultimo = 14;
        this.configurar(this.impares, primero, ultimo);
    }

    /**
     * Configura las llaves en el orden que necesitamos para insertarlos después en nuestro arbol cerradura
     * @param v vector de llaves
     * @param primero primera posicion del vector
     * @param ultimo ultima posicion del vector
     */
    public void configurar(Llave[] v, int primero, int ultimo) {

        int mitad = (primero + ultimo) / 2;

        this.cerradura.insertar(new Llave(v[mitad].getId()));

        if (primero != ultimo) {
            configurar(v, primero, mitad - 1);
            configurar(v, mitad + 1, ultimo);
        }
    }


    /**
     * Prueba una llave para intentar abrir la cerradura según las condiciones impuestas
     * @param x la llave a probar
     * @return true || false
     */
    public boolean probarLlave(Llave x) {

        //System.out.println("Altura cerradura");
        //System.out.println(this.cerradura.profundidad(this.cerradura));
        //System.out.println("Llaves finales ");
        //System.out.println(this.cerradura.nodosFinales(this.cerradura));
        //System.out.println("Llaves internas ");
        //System.out.println(this.cerradura.nodosInternos(this.cerradura));
        boolean abierta = false;
        setProfundidad(4);
        if (this.cerradura.pertenece(x)) {
            this.cerradura.borrar(x);
            this.probadas.insertar(x);


            if (this.cerradura.profundidad(this.cerradura) < this.getProfundidad()
                    && this.cerradura.nodosFinales(this.cerradura) <= this.cerradura.nodosInternos(this.cerradura)) {
                System.out.println("La puerta se ha abierto ");

                this.abiertaCerradura = true;
            }


        } else {
            //System.out.println("Altura probadas");
            //System.out.println(this.probadas.profundidad(this.probadas));
            //System.out.println("Llaves finales ");
            //System.out.println(this.probadas.nodosFinales(this.probadas));
            //System.out.println("Llaves internas ");
            //System.out.println(this.probadas.nodosInternos(this.probadas));
            this.probadas.insertar(x);

            this.abiertaCerradura = false;
            System.out.println("La puerta sigue vacía ");
        }
        return abierta;
    }


    /**public static void main(String[] args) {
     Puerta p = new Puerta();
     p.pconfigurar();

     System.out.println("---------------");
     Llave[] pruebas = {new Llave(1), new Llave(5), new Llave(4), new Llave(9), new Llave(6),
     new Llave(17), new Llave(13), new Llave(20), new Llave(21), new Llave(2), new Llave(8),
     new Llave(27), new Llave(25), new Llave(29)};
     for (int i = 0; i != pruebas.length; i++) {
     p.probarLlave(pruebas[i]);
     System.out.println("--------------------");
     }

     }
     */
}
