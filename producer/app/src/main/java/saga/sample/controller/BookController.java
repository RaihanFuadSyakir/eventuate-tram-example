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
        return new ResponseEntity<Book>(created_book, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book book) {
        // Ensure the id from the path matches the book's id
        if (!id.equals(book.getId())) {
            return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
        }
        Book updatedBook = bookService.updateBook(book);
        return new ResponseEntity<Book>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        // Create a book object with only the id set for deletion
        Book book = new Book();
        book.setId(id);
        Book deletedBook = bookService.deleteBook(book);
        return new ResponseEntity<Book>(deletedBook, HttpStatus.NO_CONTENT);
    }
}