package saga.sample.event.handler;

import saga.sample.event.domain.Event;

public interface EventHandler<T extends Event> {
    void handleEvent(T event);

    Class<T> getTypeParameterClass();
}