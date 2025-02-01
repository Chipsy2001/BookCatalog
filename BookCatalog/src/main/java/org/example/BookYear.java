package org.example;

import java.util.Comparator;

public class BookYear implements Comparator<Book> {
    @Override
    public int compare(Book b1, Book b2) {
        return Integer.compare(b1.getPublicationYear(), b2.getPublicationYear());
    }
}