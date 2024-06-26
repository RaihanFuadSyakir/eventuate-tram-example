package saga.sample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Message {
    private String aggregateType;
    private String aggregateEventType;
    private String payload;

    public String getAggregateType() {
        return aggregateType;
    }

    public void setAggregateType(String aggregateType) {
        this.aggregateType = aggregateType;
    }

    public String getAggregateEventType() {
        return aggregateEventType;
    }

    public void setAggregateEventType(String aggregateEventType) {
        this.aggregateEventType = aggregateEventType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    // Getters and setters
}