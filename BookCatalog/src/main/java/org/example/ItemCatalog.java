package org.example;

public interface ItemCatalog {
    String getItemInfo();
    boolean matches(String keyword);
}