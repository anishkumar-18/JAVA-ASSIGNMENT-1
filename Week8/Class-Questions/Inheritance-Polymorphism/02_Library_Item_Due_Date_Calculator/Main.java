import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

abstract class LibraryItem {
    protected final String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int borrowingDays();

    LocalDate dueDate(LocalDate currentDate) {
        return currentDate.plusDays(borrowingDays());
    }
}

class Book extends LibraryItem {
    Book(String title) { super(title); }
    int borrowingDays() { return 14; }
}

class DVD extends LibraryItem {
    DVD(String title) { super(title); }
    int borrowingDays() { return 7; }
}

class Magazine extends LibraryItem {
    Magazine(String title) { super(title); }
    int borrowingDays() { return 3; }
}

public class Main {
    static LibraryItem createItem(String type, String title) {
        switch (type) {
            case "BOOK":
                return new Book(title);
            case "DVD":
                return new DVD(title);
            default:
                return new Magazine(title);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate currentDate = LocalDate.of(2023, 10, 26);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+", 2);
            String type = parts[0];
            String title = parts[1].replace("\"", "");

            LibraryItem item = createItem(type, title);
            System.out.println(item.title + ": " + item.dueDate(currentDate).format(formatter));
        }

        sc.close();
    }
}
