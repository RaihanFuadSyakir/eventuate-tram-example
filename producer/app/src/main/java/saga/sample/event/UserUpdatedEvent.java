package saga.sample.event;

import saga.sample.model.User;

public class UserUpdatedEvent {
    private User user;

    public UserUpdatedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}