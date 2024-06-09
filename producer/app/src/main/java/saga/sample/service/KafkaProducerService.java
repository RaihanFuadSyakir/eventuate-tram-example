package saga.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import saga.sample.model.User;
import saga.sample.event.UserCreatedEvent;
import saga.sample.event.UserUpdatedEvent;
import saga.sample.model.Message;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendUserCreatedEvent(UserCreatedEvent event) {
        sendMessage(User.class.getName(), UserCreatedEvent.class.getName(), event);
    }

    public void sendUserUpdatedEvent(UserUpdatedEvent event) {
        sendMessage(User.class.getName(), UserCreatedEvent.class.getName(), event);
    }

    private void sendMessage(String aggregateType, String aggregateEventType, Object event) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String payload = objectMapper.writeValueAsString(event);
            Message message = new Message(aggregateType, aggregateEventType, payload);
            String messageJson = objectMapper.writeValueAsString(message);
            kafkaTemplate.send(aggregateEventType, messageJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
