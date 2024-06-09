package saga.sample.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import saga.sample.event.UserCreatedEvent;

@Service
public class ConsumerService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "test-topic", groupId = "group_id")
    public void consume(String message) {
        try {
            UserCreatedEvent event = objectMapper.readValue(message, UserCreatedEvent.class);
            handleUserCreatedEvent(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleUserCreatedEvent(UserCreatedEvent event) {
        // Process the event
        System.out.println("Handling user created event for user: " + event.getUser().getName());
    }
}
