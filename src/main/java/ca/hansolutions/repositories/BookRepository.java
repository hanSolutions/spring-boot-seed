package ca.hansolutions.repositories;

import ca.hansolutions.models.Book;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(cacheNames = "book")
public interface BookRepository {

    @Cacheable
    Book getBookById(String id);

    @CachePut(key = "#book.id")
    void saveBook(Book book);

    @CacheEvict
    void deleteBook(String id);
}
