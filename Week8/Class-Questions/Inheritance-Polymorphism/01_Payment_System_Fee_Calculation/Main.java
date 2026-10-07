import java.util.Scanner;

abstract class PaymentMethod {
    protected final double amount;

    PaymentMethod(double amount) {
        this.amount = amount;
    }

    abstract double adjustedAmount();
}

class CardPayment extends PaymentMethod {
    CardPayment(double amount) {
        super(amount);
    }

    double adjustedAmount() {
        return amount * 1.02;
    }
}

class WalletPayment extends PaymentMethod {
    WalletPayment(double amount) {
        super(amount);
    }

    double adjustedAmount() {
        return amount * 1.01;
    }
}

class BankTransferPayment extends PaymentMethod {
    BankTransferPayment(double amount) {
        super(amount);
    }

    double adjustedAmount() {
        return amount;
    }
}

public class Main {
    static PaymentMethod createPayment(String type, double amount) {
        switch (type) {
            case "CARD":
                return new CardPayment(amount);
            case "WALLET":
                return new WalletPayment(amount);
            default:
                return new BankTransferPayment(amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            PaymentMethod payment = createPayment(type, amount);
            double adjusted = payment.adjustedAmount();

            System.out.printf("%s: %.2f%n", type, adjusted);
            total += adjusted;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
