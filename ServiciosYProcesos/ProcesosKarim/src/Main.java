import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {

			ProcessBuilder calculadora = new ProcessBuilder("calc");
			for(int i = 0;i<30;i++)
				calculadora.start();
			
			ProcessBuilder explorer = new ProcessBuilder("explorer.exe");
			explorer.start();
			explorer.start();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}