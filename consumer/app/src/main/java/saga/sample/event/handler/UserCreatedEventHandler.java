package saga.sample.event.handler;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import saga.sample.event.domain.UserCreatedEvent;
import saga.sample.event.domain.UserUpdatedEvent;

@Service
public class UserCreatedEventHandler implements EventHandler<UserCreatedEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handleEvent(UserCreatedEvent event) {
        try {
            System.out.println("Handling user created event for user: " + event.getUser().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Class<UserCreatedEvent> getTypeParameterClass() {
        return UserCreatedEvent.class;
    }
}
