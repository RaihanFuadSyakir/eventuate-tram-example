package saga.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import saga.sample.model.Book;
import saga.sample.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book created_book = bookService.createBook(book);
        return new ResponseEntity<Book>(created_book, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Book> updateBook(@PathVariable String isbn, @RequestBody Book book) {
        // Ensure the ISBN from the path matches the book's ISBN
        if (!isbn.equals(book.getIsbn())) {
            return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
        }
        Book updatedBook = bookService.updateBook(book);
        return new ResponseEntity<Book>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Book> deleteBook(@PathVariable String isbn) {
        // Create a book object with only the ISBN set for deletion
        Book book = new Book();
        book.setIsbn(isbn);
        Book deletedBook = bookService.deleteBook(book);
        return new ResponseEntity<Book>(deletedBook, HttpStatus.NO_CONTENT);
    }
}