package Servidor;
import java.io.*;
import java.net.*;

public class ServidorSaludo {
    public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor escuchando en el puerto " + port);
            
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Cliente conectado desde: " + clientSocket.getInetAddress().getHostAddress());

                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                    String nombre = in.readLine();  // Lee el nombre del cliente
                    if (nombre == null || nombre.trim().isEmpty()) {
                        nombre = "Invitado";  // Nombre por defecto si no se recibe uno válido
                    }

                    System.out.println("Nombre recibido: " + nombre);
                    out.println("¡Hola, " + nombre + "! Bienvenido.");
                } catch (IOException e) {
                    System.out.println("Error de IO en la conexión con el cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
}
