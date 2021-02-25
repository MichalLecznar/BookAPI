package pl.coderslab.bookapi.model;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MockBookService implements BookService{

    private List<Book> books;
    private static Long nextId = 4L;

    public MockBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking	in Java", "Bruce Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa Java.", "Sierra Kathy, Bates Bert", "Helion", "programming"));
        books.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann,	Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public static Long getNextId() {
        return nextId;
    }

    public static void setNextId(Long nextId) {
        MockBookService.nextId = nextId;
    }

    public List<Book> getAllBooks(){
        return books;
    }

    @Override
    public Optional<Book> getBookById(Long id){
        return books.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    @Override
    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public void deleteBook(Long id) {
        if(getBookById(id).isPresent()){
            books.remove(this.getBookById(id).get());
        }
    }

    @Override
    public void editBook(Book book) {
        if(this.getBookById(book.getId()).isPresent()){
            int index = books.indexOf(this.getBookById(book.getId()).get());
            books.set(index, book);
        }
    }



}
