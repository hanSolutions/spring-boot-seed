package ca.hansolutions.repositories;

import ca.hansolutions.models.Book;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Override
    public Book getBookById(String id) {
        return lazyBookGetter(id);
    }

    private Book lazyBookGetter(String id) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Book(id, "name" + id, new Random().nextDouble());
    }

    @Override
    public void saveBook(Book book) {

        return;
    }

    @Override
    public void deleteBook(String id) {

        return;
    }
}
