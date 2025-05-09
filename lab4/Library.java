import java.util.*;

public class Library {
    private List<Book> books;
    private Set<String> uniqueAuthors;
    private Map<String, Integer> authorBookCount;

    public Library() {
        books = new ArrayList<>();
        uniqueAuthors = new HashSet<>();
        authorBookCount = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        uniqueAuthors.add(book.getAuthor());
        authorBookCount.put(book.getAuthor(),
                authorBookCount.getOrDefault(book.getAuthor(), 0) + 1);
    }

    public void removeBook(Book book) {
        if (books.remove(book)) {
            String author = book.getAuthor();
            int count = authorBookCount.getOrDefault(author, 0) - 1;
            if (count <= 0) {
                authorBookCount.remove(author);
                uniqueAuthors.remove(author);
            } else {
                authorBookCount.put(author, count);
            }
        }
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findBooksByYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                result.add(book);
            }
        }
        return result;
    }

    public void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Библиотека пуста.");
        } else {
            System.out.println("Список всех книг:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void printUniqueAuthors() {
        System.out.println("Уникальные авторы:");
        for (String author : uniqueAuthors) {
            System.out.println(author);
        }
    }

    public void printAuthorStatistics() {
        System.out.println("Статистика по авторам:");
        for (Map.Entry<String, Integer> entry : authorBookCount.entrySet()) {
            System.out.printf("%s: %d книг(и)%n", entry.getKey(), entry.getValue());
        }
    }
}
