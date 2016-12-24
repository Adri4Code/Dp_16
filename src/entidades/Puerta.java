package entidades;

/**
 * Created by adri on 18/12/16.
 */
public class Puerta {

    private Arbol<Llave> cerradura = new Arbol<Llave>();
    private Arbol<Llave> probadas = new Arbol<Llave>();
    private boolean estadoCerradura = false;
    Llave[] impares = {new Llave(1), new Llave(3), new Llave(5), new Llave(7), new Llave(9), new Llave(11), new Llave(13), new Llave(15), new Llave(17), new Llave(19), new Llave(21), new Llave(23), new Llave(25), new Llave(27), new Llave(29)};

    public Puerta() {
        this.cerradura = new Arbol<Llave>();
        this.probadas = new Arbol<Llave>();
        this.estadoCerradura = false;
    }

    public void pconfigurar() {

        int primero = 0;
        int ultimo = 14;
        this.configurar(this.impares, primero, ultimo);
    }

    public void configurar(Llave[] v, int primero, int ultimo) {

        int mitad = (primero + ultimo) / 2;

        this.cerradura.insertar(new Llave(v[mitad].getId()));
        System.out.println(v[mitad].getId());

        if (primero != ultimo) {
            configurar(v, primero, mitad - 1);
            configurar(v, mitad + 1, ultimo);
        }
    }

    public static void main(String[] args) {
        Puerta p = new Puerta();
        p.pconfigurar();
    }
}
