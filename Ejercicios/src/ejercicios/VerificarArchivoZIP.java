package ejercicios;
import java.io.FileInputStream;
import java.io.IOException;

public class VerificarArchivoZIP {
    public static void main(String[] args) {
        String nombreArchivo = "archivo.zip"; // Cambia esto al nombre de tu archivo ZIP

        try (FileInputStream fis = new FileInputStream(nombreArchivo)) {
            byte[] cabecera = new byte[4];
            int bytesRead = fis.read(cabecera);

            if (bytesRead == 4 && esCabeceraZIPValida(cabecera)) {
                System.out.println("El archivo es un archivo ZIP válido.");
            } else {
                System.out.println("El archivo no es un archivo ZIP válido.");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Función para verificar si la cabecera es un archivo ZIP válido
    public static boolean esCabeceraZIPValida(byte[] cabecera) {
        byte[] secuenciaValida = {80, 75, 3, 4};

        for (int i = 0; i < 4; i++) {
            if (cabecera[i] != secuenciaValida[i]) {
                return false;
            }
        }

        return true;
    }
}
