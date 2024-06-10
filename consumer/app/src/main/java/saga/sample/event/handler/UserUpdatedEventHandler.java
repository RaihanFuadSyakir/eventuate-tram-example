package saga.sample.event.handler;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import saga.sample.event.domain.UserUpdatedEvent;

@Service
public class UserUpdatedEventHandler implements EventHandler<UserUpdatedEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handleEvent(UserUpdatedEvent event) {
        try {
            System.out.println("Handling user updated event for user: " + event.getUser().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Class<UserUpdatedEvent> getTypeParameterClass() {
        return UserUpdatedEvent.class;
    }
}