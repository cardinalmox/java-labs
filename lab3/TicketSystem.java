import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TicketSystem {
    private final List<User> users = new ArrayList<>();
    private List<Cinema> cinemas = new ArrayList<>();
    private User currentUser = null;
    private final Scanner scanner = new Scanner(System.in);
    private final String SAVE_FILE = "cinemas.ser";

    public TicketSystem() {
        users.add(new User("admin", "admin", true));
        users.add(new User("user", "user", false));
        loadData();
    }

    public void run() {
        System.out.println("Добро пожаловать в билетную систему!");
        login();
        while (true) {
            if (currentUser.isAdmin) adminMenu();
            else userMenu();
        }
    }

    private void login() {
        while (true) {
            System.out.print("Введите логин: ");
            String login = scanner.nextLine();
            System.out.print("Введите пароль: ");
            String pass = scanner.nextLine();
            for (User u : users) {
                if (u.login.equals(login) && u.password.equals(pass)) {
                    currentUser = u;
                    System.out.println("Успешный вход!\n");
                    return;
                }
            }
            System.out.println("Неверные данные. Попробуйте снова.");
        }
    }

    private void adminMenu() {
        System.out.println("Админ-меню:");
        System.out.println("1. Добавить кинотеатр");
        System.out.println("2. Добавить зал в кинотеатр");
        System.out.println("3. Добавить сеанс");
        System.out.println("4. Посмотреть сеансы");
        System.out.println("0. Выйти");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> addCinema();
            case "2" -> addHall();
            case "3" -> addSession();
            case "4" -> listSessions();
            case "0" -> exit();
            default -> System.out.println("Неверный выбор.");
        }
    }

    private void userMenu() {
        System.out.println("Меню пользователя:");
        System.out.println("1. Просмотреть сеансы");
        System.out.println("2. Купить билет");
        System.out.println("0. Выйти");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> listSessions();
            case "2" -> buyTicket();
            case "0" -> exit();
            default -> System.out.println("Неверный выбор.");
        }
    }

    private void addCinema() {
        System.out.print("Название кинотеатра: ");
        String name = scanner.nextLine();
        cinemas.add(new Cinema(name));
        saveData();
    }

    private void addHall() {
        Cinema cinema = selectCinema();
        if (cinema == null) return;
        System.out.print("Название зала: ");
        String name = scanner.nextLine();
        System.out.print("Количество рядов: ");
        int rows = Integer.parseInt(scanner.nextLine());
        System.out.print("Количество мест в ряду: ");
        int cols = Integer.parseInt(scanner.nextLine());
        cinema.addHall(new Hall(name, rows, cols));
        saveData();
    }

    private void addSession() {
        Hall hall = selectHall();
        if (hall == null) return;
        System.out.print("Название фильма: ");
        String movie = scanner.nextLine();
        System.out.print("Дата и время (гггг-мм-дд чч:мм): ");
        String input = scanner.nextLine();
        LocalDateTime time = LocalDateTime.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        hall.addSession(new Session(movie, time, hall.rows, hall.cols));
        saveData();
    }

    private void listSessions() {
        if (cinemas.isEmpty()) {
            System.out.println("Кинотеатры не найдены.");
            return;
        }
        for (Cinema c : cinemas) {
            System.out.println("Кинотеатр: " + c.name);
            for (Hall h : c.halls) {
                System.out.println("  Зал: " + h.name);
                for (Session s : h.sessions) {
                    System.out.println("    Фильм: " + s.movie + ", Время: " + s.time);
                }
            }
        }
    }

    private void buyTicket() {
        Session session = selectSession();
        if (session == null) return;
        session.printSeats();
        System.out.print("Введите номер ряда: ");
        int row = Integer.parseInt(scanner.nextLine()) - 1;
        System.out.print("Введите номер места: ");
        int col = Integer.parseInt(scanner.nextLine()) - 1;
        if (session.buyTicket(row, col)) {
            System.out.println("Билет куплен!");
            saveData();
        } else {
            System.out.println("Место занято или некорректно.");
        }
    }

    private Cinema selectCinema() {
        if (cinemas.isEmpty()) {
            System.out.println("Кинотеатры отсутствуют.");
            return null;
        }
        for (int i = 0; i < cinemas.size(); i++) {
            System.out.println((i + 1) + ". " + cinemas.get(i).name);
        }
        System.out.print("Выберите кинотеатр: ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        if (choice >= 0 && choice < cinemas.size()) return cinemas.get(choice);
        return null;
    }

    private Hall selectHall() {
        Cinema cinema = selectCinema();
        if (cinema == null || cinema.halls.isEmpty()) {
            System.out.println("Залы не найдены.");
            return null;
        }
        for (int i = 0; i < cinema.halls.size(); i++) {
            System.out.println((i + 1) + ". " + cinema.halls.get(i).name);
        }
        System.out.print("Выберите зал: ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        if (choice >= 0 && choice < cinema.halls.size()) return cinema.halls.get(choice);
        return null;
    }

    private Session selectSession() {
        Cinema cinema = selectCinema();
        if (cinema == null) return null;
        Hall hall = selectHallFromCinema(cinema);
        if (hall == null) return null;
        if (hall.sessions.isEmpty()) {
            System.out.println("Сеансы не найдены.");
            return null;
        }
        for (int i = 0; i < hall.sessions.size(); i++) {
            Session s = hall.sessions.get(i);
            System.out.println((i + 1) + ". " + s.movie + " в " + s.time);
        }
        System.out.print("Выберите сеанс: ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        if (choice >= 0 && choice < hall.sessions.size()) return hall.sessions.get(choice);
        return null;
    }

    private Hall selectHallFromCinema(Cinema cinema) {
        if (cinema.halls.isEmpty()) {
            System.out.println("Залы не найдены.");
            return null;
        }
        for (int i = 0; i < cinema.halls.size(); i++) {
            System.out.println((i + 1) + ". " + cinema.halls.get(i).name);
        }
        System.out.print("Выберите зал: ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        if (choice >= 0 && choice < cinema.halls.size()) return cinema.halls.get(choice);
        return null;
    }

    private void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            out.writeObject(cinemas);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных.");
        }
    }

    private void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
            cinemas = (List<Cinema>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            cinemas = new ArrayList<>();
        }
    }

    private void exit() {
        System.out.println("Выход из системы. До свидания!");
        System.exit(0);
    }
}
