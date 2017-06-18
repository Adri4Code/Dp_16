package cargador;

import java.util.List;

/**
 * Clase creada para ser usada en la utilidad cargador
 * contiene el main del cargador. Se crea una instancia de la clase Estacion, una instancia de la clase Cargador
 * y se procesa el fichero de inicio, es decir, se leen todas las lÃ­neas y se van creando todas las instancias de la simulaciÃ³n
 * Created by adri on 18/06/17.
 */
public class Cargador {
    /**
     * nÃºmero de elementos distintos que tendrÃ¡ la simulaciÃ³n - Mapa, Stark, Lannister, Baratheon, Targaryen
     */
    static final int NUMELTOSCONF = 5;
    /**
     * atributo para almacenar el mapeo de los distintos elementos
     */
    static private DatoMapeo[] mapeo;

    /**
     * constructor parametrizado
     *
     * @param e referencia a la instancia del patrÃ³n Singleton
     */
    Cargador() {
        mapeo = new DatoMapeo[NUMELTOSCONF];
        mapeo[0] = new DatoMapeo("MAPA", 5);
        mapeo[1] = new DatoMapeo("STARK", 4);
        mapeo[2] = new DatoMapeo("TARGARYEN", 4);
        mapeo[3] = new DatoMapeo("LANNISTER", 4);
        mapeo[4] = new DatoMapeo("CAMINANTE", 4);

    }

    /**
     * busca en mapeo el elemento leÃ­do del fichero inicio.txt y devuelve la posiciÃ³n en la que estÃ¡
     *
     * @param elto elemento a buscar en el array
     * @return res posiciÃ³n en mapeo de dicho elemento
     */
    private int queElemento(String elto) {
        int res = -1;
        boolean enc = false;

        for (int i = 0; (i < NUMELTOSCONF && !enc); i++) {
            if (mapeo[i].getNombre().equals(elto)) {
                res = i;
                enc = true;
            }
        }
        return res;
    }

    /**
     * mÃ©todo que crea las distintas instancias de la simulaciÃ³n
     *
     * @param elto      nombre de la instancia que se pretende crear
     * @param numCampos nÃºmero de atributos que tendrÃ¡ la instancia
     * @param vCampos   array que contiene los valores de cada atributo de la instancia
     */
    public void crear(String elto, int numCampos, List<String> vCampos) {
        //Si existe elemento y el número de campos es correcto, procesarlo... si no, error
        int numElto = queElemento(elto);

        //Comprobación de datos bÃ¡sicos correctos
        if ((numElto != -1) && (mapeo[numElto].getCampos() == numCampos)) {
            //procesar
            switch (numElto) {
                case 0:
                    crearMapa(numCampos, vCampos);
                    break;
                case 1:
                    crearStark(numCampos, vCampos);
                    break;
                case 2:
                    crearTargaryen(numCampos, vCampos);
                    break;
                case 3:
                    crearLannister(numCampos, vCampos);
                    break;
                case 4:
                    crearCaminante(numCampos, vCampos);
                    break;
            }
        } else
            System.out.println("ERROR Cargador::crear: Datos de configuraciÃ³n incorrectos... " + elto + "," + numCampos + "\n");
    }

    /**
     * mÃ©todo que crea una instancia de la clase Planta
     *
     * @param numCampos nÃºmero de atributos que tendrÃ¡ la instancia
     * @param vCampos   array que contiene los valores de cada atributo
     */
    private void crearMapa(int numCampos, List<String> vCampos) {
        System.out.println("Creado Mapa: " + vCampos.get(1) + "\n");
        //inicializar mapa
    }

    /**
     * mÃ©todo que crea una instancia de la clase Stark
     *
     * @param numCampos nÃºmero de atributos que tendrÃ¡ la instancia
     * @param vCampos   array que contiene los valores de cada atributo
     */
    private void crearStark(int numCampos, List<String> vCampos) {
        System.out.println("Creado Stark: " + vCampos.get(1) + "\n");
        //Registrar Stark en el mapa
    }

    /**
     * mÃ©todo que crea una instancia de la clase Targaryen
     *
     * @param numCampos nÃºmero de atributos que tendrÃ¡ la instancia
     * @param vCampos   array que contiene los valores de cada atributo
     */
    private void crearTargaryen(int numCampos, List<String> vCampos) {
        System.out.println("Creado Targaryen: " + vCampos.get(1) + "\n");
        //Registrar Targaryen en el mapa
    }

    /**
     * mÃ©todo que crea una instancia de la clase Lannister
     *
     * @param numCampos nÃºmero de atributos que tendrÃ¡ la instancia
     * @param vCampos   array que contiene los valores de cada atributo
     */
    private void crearLannister(int numCampos, List<String> vCampos) {
        System.out.println("Creado Lannister: " + vCampos.get(1) + "\n");
        //Registrar Lannister en el mapa
    }

    /**
     * mÃ©todo que crea una instancia de la clase White Walker
     *
     * @param numCampos nÃºmero de atributos que tendrÃ¡ la instancia
     * @param vCampos   array que contiene los valores de cada atributo
     */
    private void crearCaminante(int numCampos, List<String> vCampos) {
        System.out.println("Creado Caminante Blanco: " + vCampos.get(1) + "\n");
        //Registrar Baratheon en el mapa
    }

}
