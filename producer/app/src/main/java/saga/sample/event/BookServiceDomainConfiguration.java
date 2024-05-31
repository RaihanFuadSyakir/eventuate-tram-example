package saga.sample.event;

import io.eventuate.tram.events.publisher.DomainEventPublisher;
import saga.sample.service.BookService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import io.eventuate.tram.spring.messaging.producer.jdbc.TramMessageProducerJdbcConfiguration;

import io.eventuate.tram.spring.events.publisher.TramEventsPublisherConfiguration;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@EnableTransactionManagement
@Import({ TramEventsPublisherConfiguration.class, TramMessageProducerJdbcConfiguration.class })
public class BookServiceDomainConfiguration {
    @Bean
    BookService bookService() {
        return new BookService();
    }

    // @Bean
    // BookDomainEventPublisher bookDomainEventPublisher(DomainEventPublisher
    // domainEventPublisher) {
    // return new BookDomainEventPublisher(domainEventPublisher);
    // }
}
