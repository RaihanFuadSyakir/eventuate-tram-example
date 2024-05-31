package saga.sample.event;

import saga.sample.model.Book;

public class BookUpdatedEvent implements BookDomainEvent {
    private Book book;

    public BookUpdatedEvent() {
    }

    public BookUpdatedEvent(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}