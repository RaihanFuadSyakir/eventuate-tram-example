package saga.sample.event.domain;

import saga.sample.model.User;

public class UserCreatedEvent implements Event {
    private User user;

    public UserCreatedEvent() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
