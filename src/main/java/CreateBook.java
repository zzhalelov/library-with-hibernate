import model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class CreateBook {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();

        try {
            String title = getString("Введите название книги:");
            String author = getString("Введите автора:");
            String genre = getString("Введите жанр книги:");

            Book book = Book.builder()
                    .title(title)
                    .author(author)
                    .genre(genre)
                    .build();

            manager.getTransaction().begin();
            manager.persist(book);
            manager.getTransaction().commit();
            System.out.println("Книга добавлена");
        } catch (Exception e) {
            manager.getTransaction().rollback();
            System.out.println("Ошибка при добавлении книги");
        } finally {
            factory.close();
        }
    }

    static String getString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}