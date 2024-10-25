// Karim ZInnatullin
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			
			Document documento = builder.parse("pelis.xml");

			
			documento.getDocumentElement().normalize();

			
			NodeList listaPeliculas = documento.getElementsByTagName("pelicula");

			
			for (int i = 0; i < listaPeliculas.getLength(); i++) {
				Node nodo = listaPeliculas.item(i);

				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) nodo;

					
					String tituloOriginal = elemento.getAttribute("titulo");
					String estreno = elemento.getElementsByTagName("estreno").item(0).getTextContent();
					String tituloIngles = elemento.getElementsByTagName("titulo").item(0).getTextContent();
					String director = elemento.getElementsByTagName("director").item(0).getTextContent();
					String pais = ((Element) elemento.getElementsByTagName("director").item(0)).getAttribute("pais");

					
					System.out.println("Película: " + tituloOriginal);
					System.out.println("Año de estreno: " + estreno);
					System.out.println("Título en inglés: " + tituloIngles);
					System.out.println("Director: " + director);
					System.out.println("País del director: " + pais);
					System.out.println();

					
					guardarEnFichero(tituloOriginal, estreno, tituloIngles, director, pais);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void guardarEnFichero(String tituloOriginal, String estreno, String tituloIngles, String director,
			String pais) {
		try (FileWriter writer = new FileWriter("peliculas.csv", true)) {
			writer.append(tituloOriginal).append(",");
			writer.append(estreno).append(",");
			writer.append(tituloIngles).append(",");
			writer.append(director).append(",");
			writer.append(pais).append("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
