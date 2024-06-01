package saga.sample.event;

import io.eventuate.tram.events.aggregates.AbstractAggregateDomainEventPublisher;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import saga.sample.model.Book;

public class BookDomainEventPublisher extends AbstractAggregateDomainEventPublisher<Book, BookDomainEvent> {
    public BookDomainEventPublisher(DomainEventPublisher eventPublisher) {
        super(eventPublisher, Book.class, Book::getId);
    }
}
