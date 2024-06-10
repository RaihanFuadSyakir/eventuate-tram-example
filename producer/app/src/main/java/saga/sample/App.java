/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package saga.sample;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

import saga.sample.event.UserCreatedEvent;
import saga.sample.event.UserUpdatedEvent;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public NewTopic userCreatedEventTopic() {
        return TopicBuilder.name(UserCreatedEvent.class.getName())
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic userUpdatedEventTopic() {
        return TopicBuilder.name(UserUpdatedEvent.class.getName())
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
        return args -> {
            // Sending test message to each topic
            template.send(UserCreatedEvent.class.getName(), "test UserCreatedEvent");
            template.send(UserUpdatedEvent.class.getName(), "test UserUpdatedEvent");
        };
    }
}
