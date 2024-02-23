import model.Reader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class CreateReader {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();

        try {
            int id = getInt("Введите id читателя:");
            String name = getString("Введите имя читателя:");

            Reader reader = Reader.builder()
                    .id(id)
                    .name(name)
                    .build();

            manager.getTransaction().begin();
            manager.persist(reader);
            manager.getTransaction().commit();
            System.out.println("Читатель создан");
        } catch (Exception e) {
            manager.getTransaction().rollback();
            System.out.println("Ошибка");
        } finally {
            factory.close();
        }
    }

    static String getString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    static int getInt(String message) {
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }
}