package saga.sample.event.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import saga.sample.event.domain.UserCreatedEvent;
import saga.sample.event.domain.UserUpdatedEvent;
import saga.sample.model.Message;

@Configuration
public class EventHandlerConfig {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "saga.sample.event.UserCreatedEvent", groupId = "group_id")
    public void consumeCreateUser(String message) {
        try {
            Message msg = objectMapper.readValue(message, Message.class);
            System.out.println(msg.toString());
            UserCreatedEvent event = objectMapper.readValue(msg.getPayload(), UserCreatedEvent.class);
            System.out.println(event.getUser().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "saga.sample.event.UserUpdatedEvent", groupId = "group_id")
    public void consumeUpdateUser(String message) {
        try {
            Message msg = objectMapper.readValue(message, Message.class);
            System.out.println(msg.toString());
            UserUpdatedEvent event = objectMapper.readValue(msg.getPayload(), UserUpdatedEvent.class);
            System.out.println(event.getUser().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
