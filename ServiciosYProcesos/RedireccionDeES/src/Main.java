import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		try {
            // Crear un proceso con ProcessBuilder
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir", "%USERPROFILE%\\Downloads");
            
            // Iniciar el proceso
            Process process = pb.start();

            // Capturar la salida del proceso hijo
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Leer y enviar la salida al proceso padre (es decir, imprimirlo en consola)
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("Proceso terminado con código de salida: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}