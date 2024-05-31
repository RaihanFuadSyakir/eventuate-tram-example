package saga.sample.event;

import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;
import org.springframework.stereotype.Component;

@Component
public class BookEventConsumer {

    public DomainEventHandlers domainEventHandlers() {
        return DomainEventHandlersBuilder
                .forAggregateType("saga.sample.model.Book")
                .onEvent(BookCreatedEvent.class, this::handleBookCreatedEvent)
                .onEvent(BookUpdatedEvent.class, this::handleBookUpdatedEvent)
                .onEvent(BookDeletedEvent.class, this::handleBookDeletedEvent)
                .build();
    }

    private void handleBookCreatedEvent(DomainEventEnvelope<BookCreatedEvent> envelope) {
        BookCreatedEvent event = envelope.getEvent();
        System.out.println("Received BookCreatedEvent: " + event.getBook().getTitle());
    }

    private void handleBookUpdatedEvent(DomainEventEnvelope<BookUpdatedEvent> envelope) {
        BookUpdatedEvent event = envelope.getEvent();
        System.out.println("Received BookUpdatedEvent: " + event.getBook().getTitle());
    }

    private void handleBookDeletedEvent(DomainEventEnvelope<BookDeletedEvent> envelope) {
        BookDeletedEvent event = envelope.getEvent();
        System.out.println("Received BookDeletedEvent: " + event.getBook().getIsbn());
    }
}