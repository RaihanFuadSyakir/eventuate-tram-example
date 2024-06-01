package saga.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import saga.sample.event.BookCreatedEvent;
import saga.sample.event.BookDomainEventPublisher;
import saga.sample.model.Book;

import java.util.Collections;

@Transactional
public class BookService {
    @Autowired
    private BookDomainEventPublisher bookDomainEventPublisher;

    public Book createBook(Book book) {
        // Persist book to the database
        // bookRepository.save(book);
        bookDomainEventPublisher.publish(book,
                Collections.singletonList(new BookCreatedEvent(book.getIsbn(),
                        book.getTitle(), book.getAuthor())));
        System.out.println("publish book");
        return book;
    }

    public Book updateBook(Book book) {
        // Update book in the database
        // bookRepository.save(book);

        // bookDomainEventPublisher.publish(book, Collections.singletonList(new
        // BookUpdatedEvent(book)));
        return book;
    }

    public Book deleteBook(Book book) {
        // Delete book from the database
        // bookRepository.delete(book);

        // bookDomainEventPublisher.publish(book, Collections.singletonList(new
        // BookDeletedEvent(book)));
        return book;
    }

}