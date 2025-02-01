package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Object implements ItemCatalog {
    private static final AtomicInteger idGenerator = new AtomicInteger(0);
    private final int id;
    private String title;

    public Object(String title) {
        this.id = idGenerator.incrementAndGet();
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getItemInfo() {
        return "ID: " + id + ", Cím: " + title;
    }

    @Override
    public boolean matches(String keyword) {
        return title.toLowerCase().contains(keyword.toLowerCase());
    }
}