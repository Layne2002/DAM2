package Ejercicio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Configuración de Hibernate
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml") // Asegúrate de tener este archivo en src/main/resources
            .buildSessionFactory();

        // Crear una sesión
        Session session = factory.openSession();

        // Cerrarla
        session.close();
        factory.close();

        System.out.println("Hibernate configurado correctamente.");
    }
}
