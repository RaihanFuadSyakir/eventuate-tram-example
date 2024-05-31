package saga.sample.event;

import saga.sample.model.Book;

public class BookDeletedEvent implements BookDomainEvent {
    private Book book;

    public BookDeletedEvent() {
    }

    public BookDeletedEvent(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}