import java.util.Scanner;

abstract class Customer {
    protected final double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double finalAmount();
}

class StudentCustomer extends Customer {
    StudentCustomer(double amount) { super(amount); }
    double finalAmount() { return amount * 0.90; }
}

class StaffCustomer extends Customer {
    StaffCustomer(double amount) { super(amount); }
    double finalAmount() { return amount * 0.95; }
}

class GuestCustomer extends Customer {
    GuestCustomer(double amount) { super(amount); }
    double finalAmount() { return amount + 10; }
}

public class Main {
    static Customer createCustomer(String type, double amount) {
        switch (type) {
            case "STUDENT":
                return new StudentCustomer(amount);
            case "STAFF":
                return new StaffCustomer(amount);
            default:
                return new GuestCustomer(amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer = createCustomer(type, amount);
            double finalAmount = customer.finalAmount();

            System.out.printf("%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
