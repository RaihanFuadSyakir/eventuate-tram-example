package saga.sample.config;

import saga.sample.model.Book;

public class TramConfig {
    private long uniqueId = System.currentTimeMillis();
    private String aggregateType = Book.class.getName() + uniqueId;
    private String aggregateId = "accountId" + uniqueId;

    public long getUniqueId() {
        return uniqueId;
    }

    public String getAggregateType() {
        return aggregateType;
    }

    public String getAggregateId() {
        return aggregateId;
    }

}
