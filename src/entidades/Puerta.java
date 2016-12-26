package entidades;

/**
 * Created by adri on 18/12/16.
 */
public class Puerta {

    private Arbol<Llave> cerradura = new Arbol<Llave>();
    private Arbol<Llave> probadas = new Arbol<Llave>();
    private boolean abiertaCerradura = false;
    Llave[] impares = {new Llave(1), new Llave(3), new Llave(5), new Llave(7), new Llave(9),
            new Llave(11), new Llave(13), new Llave(15), new Llave(17), new Llave(19),
            new Llave(21), new Llave(23), new Llave(25), new Llave(27), new Llave(29)};
    private int profundidad;

    public Puerta() {
        this.profundidad = 0;
        this.cerradura = new Arbol<Llave>();
        this.probadas = new Arbol<Llave>();
        this.abiertaCerradura = false;
    }


    public int getProfundidad() {
        return this.profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public void pconfigurar() {

        int primero = 0;
        int ultimo = 14;
        this.configurar(this.impares, primero, ultimo);
    }

    public void configurar(Llave[] v, int primero, int ultimo) {

        int mitad = (primero + ultimo) / 2;

        this.cerradura.insertar(new Llave(v[mitad].getId()));

        if (primero != ultimo) {
            configurar(v, primero, mitad - 1);
            configurar(v, mitad + 1, ultimo);
        }
    }


    //TODO:Funcionamiento de la puerta y pruebas de ella para acabar la EC1
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
