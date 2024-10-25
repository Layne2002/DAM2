//Karim Zinnatullin
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
        	//Creamos iniciamos notepad
            ProcessBuilder notepad = new ProcessBuilder("notepad.exe");
            Process notepadProceso = notepad.start(); 
            System.out.println("Esperando a notepad");

            //Esperamos que cierre
            int exitValueNotepad = notepadProceso.waitFor(); 
            System.out.println("Notepad cerrado, codigo de salida: " + exitValueNotepad);

            //Abrimos Paint
            ProcessBuilder paintBuilder = new ProcessBuilder("mspaint.exe");
            Process paintProcess = paintBuilder.start(); 
            System.out.println("Esperando Paint");

            //Esperamos que cierre
            int exitValuePaint = paintProcess.waitFor(); 
            System.out.println("Paint cerrado, codigo de salida: " + exitValuePaint);

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
