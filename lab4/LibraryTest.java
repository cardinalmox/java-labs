public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("The Call of Cthulhu", "H.P. Lovecraft", 1928));
        library.addBook(new Book("At the Mountains of Madness", "H.P. Lovecraft", 1936));
        library.addBook(new Book("The Shadow over Innsmouth", "H.P. Lovecraft", 1936));

        library.addBook(new Book("The Tell-Tale Heart", "Edgar Allan Poe", 1843));
        library.addBook(new Book("The Fall of the House of Usher", "Edgar Allan Poe", 1839));
        library.addBook(new Book("The Raven", "Edgar Allan Poe", 1845));

        library.addBook(new Book("Frankenstein", "Mary Shelley", 1818));
        library.addBook(new Book("The Last Man", "Mary Shelley", 1826));

        library.addBook(new Book("Dracula", "Bram Stoker", 1897));
        library.addBook(new Book("The Jewel of Seven Stars", "Bram Stoker", 1903));

        library.addBook(new Book("Carmilla", "J. Sheridan Le Fanu", 1872));
        library.addBook(new Book("Uncle Silas", "J. Sheridan Le Fanu", 1864));

        library.addBook(new Book("The Monk", "Matthew Lewis", 1796));
        library.addBook(new Book("Melmoth the Wanderer", "Charles Maturin", 1820));

        library.addBook(new Book("The King in Yellow", "Robert W. Chambers", 1895));
        library.addBook(new Book("The Yellow Sign", "Robert W. Chambers", 1895));

        System.out.println("📚 Все книги в библиотеке:");
        library.printAllBooks();
        System.out.println();

        System.out.println("👤 Уникальные авторы:");
        library.printUniqueAuthors();
        System.out.println();

        System.out.println("📊 Статистика по авторам:");
        library.printAuthorStatistics();
        System.out.println();

        System.out.println("🔍 Книги, изданные в 1895 году:");
        for (Book book : library.findBooksByYear(1895)) {
            System.out.println(book);
        }
        System.out.println();

        System.out.println("🔍 Книги Говарда Лавкрафта:");
        for (Book book : library.findBooksByAuthor("H.P. Lovecraft")) {
            System.out.println(book);
        }
        System.out.println();

        System.out.println("❌ Удаление книги: The Raven");
        library.removeBook(new Book("The Raven", "Edgar Allan Poe", 1845));
        System.out.println();

        System.out.println("📊 Обновлённая статистика по авторам:");
        library.printAuthorStatistics();
    }
}
