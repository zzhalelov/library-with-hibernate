import model.Book;
import model.BookInLibrary;
import model.BookStatus;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class AddBookToLibrary {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();

        int bookId = getInt("Введите ID книги:");
        int statusId = 1;

        Book book = manager.find(Book.class, bookId);
        BookStatus status = manager.find(BookStatus.class, statusId);

        if (book != null && status != null) {
            BookInLibrary bookInLibrary = BookInLibrary.builder()
                    .book(book)
                    .bookStatus(status)
                    .build();

            try {
                manager.getTransaction().begin();
                manager.persist(bookInLibrary);
                manager.getTransaction().commit();
                System.out.println("Книга добавлена в библиотеку");
            } catch (Exception e) {
                manager.getTransaction().rollback();
                System.out.println("Ошибка");
            }
            factory.close();
        }
    }

    static int getInt(String message) {
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }
}