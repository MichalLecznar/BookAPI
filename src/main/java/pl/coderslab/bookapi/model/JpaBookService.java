package pl.coderslab.bookapi.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.coderslab.bookapi.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JpaBookService implements BookService {

    private BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return Optional.empty();
    }

    @Override
    public void addBook(Book book) {
    }

    @Override
    public void deleteBook(Long id) {
    }

    @Override
    public void editBook(Book book) {
    }
}
