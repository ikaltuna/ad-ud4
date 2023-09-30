package ejercicios;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InvertirArchivo {
    public static void main(String[] args) {
        String nombreArchivoEntrada = "archivo.txt"; // Cambia esto al nombre de tu archivo de entrada
        String nombreArchivoSalida = "archivo_invertido.txt"; // Cambia esto al nombre de tu archivo de salida

        try {
            // Paso 1: Leer el contenido del archivo original
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivoEntrada));
            StringBuilder contenido = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

            br.close();

            // Paso 2: Invertir el contenido
            contenido.reverse();

            // Paso 3: Escribir el contenido invertido en un nuevo archivo
            FileWriter fw = new FileWriter(nombreArchivoSalida);
            fw.write(contenido.toString());
            fw.close();

            System.out.println("El contenido del archivo se ha invertido exitosamente y se ha guardado en '" + nombreArchivoSalida + "'.");
        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}
