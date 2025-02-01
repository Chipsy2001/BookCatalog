package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookCatalog catalog = new BookCatalog();

    public static void main(String[] args) {
        catalog.loadBooksFromDatabase();

        Book newBook = new Book("Ready Player One", Set.of("Ernest Cline\n"), 2011, 5980);
        catalog.addBook(newBook);
        catalog.saveAllBooksToDatabase();

        System.out.println("Betöltött könyvek: " + catalog.getBooks());

        while (true) {
            System.out.println("\nFőmenü:");
            System.out.println("1. Könyv hozzáadása");
            System.out.println("2. Könyvek listázása");
            System.out.println("3. Könyv keresése");
            System.out.println("4. Könyv törlése");
            System.out.println("5. Kilépés");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> catalog.listBooks();
                case 4 -> searchBook();
                case 5 -> {
                    System.out.println("Kilépés");
                    return;
                }
                default -> System.out.println("Nem található!");
            }
        }
    }

    private static void addBook() {
        System.out.print("Cím: ");
        String title = scanner.nextLine();

        System.out.print("Szerző (vesszővel elválasztva): ");
        Set<String> authors = new HashSet<>(Arrays.asList(scanner.nextLine().split(",")));

        System.out.print("Kiadási év: ");
        int year = scanner.nextInt();

        System.out.print("Ár: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Book book = new Book(title, authors, year, price);
        catalog.addBook(book);
        System.out.println("Könyv hozzáadva!");
    }
    private static void searchBook() {
        System.out.print("Keresési kulcsszó: ");
        String keyword = scanner.nextLine();
        List<Book> results = catalog.searchBooks(keyword);
        results.forEach(book -> System.out.println(book.getItemInfo()));
    }

    private static void removeBook() {
        System.out.print("Törölni kívánt könyv ID-ja: ");
        int id = scanner.nextInt();
        catalog.removeBook(id);
        System.out.println("Könyv törölve!");
    }


}