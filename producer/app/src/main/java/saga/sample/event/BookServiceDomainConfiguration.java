package saga.sample.event;

import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.spring.events.publisher.TramEventsPublisherConfiguration;

import io.eventuate.tram.spring.messaging.producer.jdbc.TramMessageProducerJdbcConfiguration;
import saga.sample.service.BookService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ TramEventsPublisherConfiguration.class, TramMessageProducerJdbcConfiguration.class })
public class BookServiceDomainConfiguration {
    @Bean
    public BookService bookService() {
        return new BookService();
    }

    @Bean
    public BookDomainEventPublisher bookDomainEventPublisher(DomainEventPublisher domainEventPublisher) {
        return new BookDomainEventPublisher(domainEventPublisher);
    }
}
