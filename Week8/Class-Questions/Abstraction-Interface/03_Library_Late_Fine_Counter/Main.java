import java.util.Scanner;

abstract class LibraryItem {
    protected final String title;
    protected final int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double fine();
}

class BookItem extends LibraryItem {
    BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() { return daysLate * 2.0; }
}

class DVDItem extends LibraryItem {
    DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() { return Math.min(50, daysLate * 5.0); }
}

class MagazineItem extends LibraryItem {
    MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double fine() { return daysLate; }
}

public class Main {
    static LibraryItem createItem(String type, String title, int daysLate) {
        switch (type) {
            case "BOOK":
                return new BookItem(title, daysLate);
            case "DVD":
                return new DVDItem(title, daysLate);
            default:
                return new MagazineItem(title, daysLate);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            LibraryItem item = createItem(type, title, daysLate);
            double fine = item.fine();

            System.out.printf("%s: %.2f%n", item.title, fine);
            total += fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}
