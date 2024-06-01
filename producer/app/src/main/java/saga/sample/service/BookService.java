package saga.sample.service;

import saga.sample.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import io.eventuate.tram.events.publisher.DomainEventPublisher;
import saga.sample.config.TramConfig;
import saga.sample.event.BookCreatedEvent;

import saga.sample.event.BookDomainEventPublisher;

import java.util.Collections;

@Transactional
public class BookService {

    // private BookDomainEventPublisher bookDomainEventPublisher;

    // public BookService(BookDomainEventPublisher bookDomainEventPublisher) {
    // this.bookDomainEventPublisher = bookDomainEventPublisher;
    // }
    @Autowired
    private DomainEventPublisher domainEventPublisher;

    @Autowired
    private TramConfig config;

    public Book createBook(Book book) {
        System.out.println("book:" + book.getId());
        // Persist book to the database
        // bookRepository.save(book);
        // bookDomainEventPublisher.publish(book,
        // Collections.singletonList(new BookCreatedEvent(book.getIsbn(),
        // book.getTitle(), book.getAuthor())));
        domainEventPublisher.publish(config.getAggregateType(), config.getAggregateId(),
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