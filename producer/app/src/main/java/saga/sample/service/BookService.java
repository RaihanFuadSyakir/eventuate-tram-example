package saga.sample.service;

import saga.sample.model.Book;

import io.eventuate.tram.events.publisher.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import saga.sample.event.BookCreatedEvent;
import saga.sample.event.BookDeletedEvent;
import saga.sample.event.BookDomainEventPublisher;
import saga.sample.event.BookUpdatedEvent;

import java.util.Collections;

public class BookService {

    @Autowired
    private BookDomainEventPublisher bookDomainEventPublisher;

    @Transactional
    public Book createBook(Book book) {
        // Persist book to the database
        // bookRepository.save(book);
        bookDomainEventPublisher.publish(book, Collections.singletonList(new BookCreatedEvent(book)));
        return book;
    }

    @Transactional
    public Book updateBook(Book book) {
        // Update book in the database
        // bookRepository.save(book);

        bookDomainEventPublisher.publish(book, Collections.singletonList(new BookUpdatedEvent(book)));
        return book;
    }

    @Transactional
    public Book deleteBook(Book book) {
        // Delete book from the database
        // bookRepository.delete(book);

        bookDomainEventPublisher.publish(book, Collections.singletonList(new BookDeletedEvent(book)));
        return book;
    }
}