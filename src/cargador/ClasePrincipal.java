package cargador;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by adri on 18/06/17.
 * * Clase creada para ser usada en la utilidad cargador
 * contiene el main del cargador. Se crea una instancia de la clase Cargador
 * y se procesa el fichero de inicio, es decir, se leen todas las líneas y se van creando todas las instancias de la simulación
 */
public class ClasePrincipal {
    public static void main(String[] args) {
        /**
         instancia asociada al fichero de entrada inicio.txt
         */
        Cargador cargador = new Cargador();
        try {
            /**
             Método que procesa línea a línea el fichero de entrada inicio.txt
             */
            FicheroCarga.procesarFichero("inicio.txt", cargador);
        } catch (FileNotFoundException valor) {
            System.err.println("Excepción capturada al procesar fichero: " + valor.getMessage());
        } catch (IOException valor) {
            System.err.println("Excepción capturada al procesar fichero: " + valor.getMessage());
        }
    }
}
