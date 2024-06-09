package saga.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import saga.sample.event.UserCreatedEvent;
import saga.sample.event.UserUpdatedEvent;
import saga.sample.model.User;
import saga.sample.service.KafkaProducerService;

@RestController
public class ProducerController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/sendUserCreated")
    public String sendUserCreatedEvent(@RequestBody User user) {
        UserCreatedEvent event = new UserCreatedEvent(user);
        kafkaProducerService.sendUserCreatedEvent(event);
        return "User Created Event sent to Kafka topic";
    }

    @PostMapping("/sendUserUpdated")
    public String sendUserUpdatedEvent(@RequestBody User user) {
        UserUpdatedEvent event = new UserUpdatedEvent(user);
        kafkaProducerService.sendUserUpdatedEvent(event);
        return "User Updated Event sent to Kafka topic";
    }
}
