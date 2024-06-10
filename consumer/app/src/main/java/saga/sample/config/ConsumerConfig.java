package saga.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import saga.sample.event.domain.UserCreatedEvent;
import saga.sample.event.domain.UserUpdatedEvent;
import saga.sample.event.handler.EventHandler;
import saga.sample.event.handler.UserCreatedEventHandler;
import saga.sample.event.handler.UserUpdatedEventHandler;
import saga.sample.service.ConsumerService;

@Configuration
public class ConsumerConfig {
    @Bean
    public ConsumerService service() {
        return new ConsumerService();
    }
}