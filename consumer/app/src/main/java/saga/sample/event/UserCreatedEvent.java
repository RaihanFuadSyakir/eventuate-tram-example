package saga.sample.event;

import saga.sample.model.User;

public class UserCreatedEvent {
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
