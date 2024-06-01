package saga.sample.event;

import io.eventuate.tram.events.publisher.DomainEventPublisher;
import saga.sample.service.BookService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.eventuate.tram.spring.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.spring.jdbckafka.TramJdbcKafkaConfiguration;

@Configuration
@EnableJpaRepositories
@Import({ TramEventsPublisherConfiguration.class, TramJdbcKafkaConfiguration.class })
public class BookServiceDomainConfiguration {
    @Bean
    BookService bookService() {
        return new BookService();
    }

    @Bean
    BookDomainEventPublisher bookDomainEventPublisher(DomainEventPublisher domainEventPublisher) {
        return new BookDomainEventPublisher(domainEventPublisher);
    }

}
