package saga.sample.event;

import saga.sample.model.Book;

public class BookCreatedEvent implements BookDomainEvent {
    private Book book;

    public BookCreatedEvent() {
    }

    public BookCreatedEvent(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}