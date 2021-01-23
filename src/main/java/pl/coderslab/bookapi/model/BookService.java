package pl.coderslab.bookapi.model;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();
    Optional<Book> getBookById(Long id);
}