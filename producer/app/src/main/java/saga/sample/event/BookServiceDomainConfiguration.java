package saga.sample.event;

import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.spring.messaging.producer.jdbc.TramMessageProducerJdbcConfiguration;
import io.eventuate.tram.spring.jdbckafka.TramJdbcKafkaConfiguration;
import saga.sample.config.TramConfig;
import saga.sample.service.BookService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import io.eventuate.tram.spring.events.publisher.TramEventsPublisherConfiguration;

@Configuration
@EnableAutoConfiguration
@Import({ TramEventsPublisherConfiguration.class, TramJdbcKafkaConfiguration.class })
public class BookServiceDomainConfiguration {
    @Bean
    BookService bookService() {
        return new BookService();
    }

    @Bean
    TramConfig tramConfig() {
        return new TramConfig();
    }
    // @Bean
    // BookService bookService(BookDomainEventPublisher bookDomainEventPublisher) {
    // return new BookService(bookDomainEventPublisher);
    // }
    // @Bean
    // BookDomainEventPublisher bookDomainEventPublisher(DomainEventPublisher
    // domainEventPublisher) {
    // return new BookDomainEventPublisher(domainEventPublisher);
    // }
}
