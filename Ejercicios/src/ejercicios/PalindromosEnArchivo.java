package ejercicios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PalindromosEnArchivo {
    public static void main(String[] args) {
        String nombreArchivoEntrada = "archivo.txt"; // Cambia esto al nombre de tu archivo de entrada
        String nombreArchivoSalida = "palindromos.txt"; // Nombre del archivo de salida para las palabras palíndromas

        try {
            // Paso 1: Leer el contenido del archivo original
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivoEntrada));
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoSalida));

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split("\\s+"); // Dividir la línea en palabras

                for (String palabra : palabras) {
                    if (esPalindromo(palabra)) {
                        bw.write(palabra);
                        bw.newLine(); // Escribir la palabra palíndroma en una nueva línea
                    }
                }
            }

            br.close();
            bw.close();

            System.out.println("Palabras palíndromas se han guardado en '" + nombreArchivoSalida + "'.");
        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }
    }

    // Función para verificar si una palabra es palíndroma
    public static boolean esPalindromo(String palabra) {
        palabra = palabra.toLowerCase(); // Convertir la palabra a minúsculas para hacer la comparación insensible a mayúsculas

        int izquierda = 0;
        int derecha = palabra.length() - 1;

        while (izquierda < derecha) {
            if (palabra.charAt(izquierda) != palabra.charAt(derecha)) {
                return false; // No es palíndromo
            }
            izquierda++;
            derecha--;
        }

        return true; // Es palíndromo
    }
}
