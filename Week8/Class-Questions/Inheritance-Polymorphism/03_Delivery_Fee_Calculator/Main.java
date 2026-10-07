import java.util.Scanner;

abstract class Delivery {
    protected final double weight;
    protected final double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    double calculateFee() {
        return 15 + 1.00 * weight + 0.20 * distance;
    }
}

class InternationalDelivery extends Delivery {
    private final double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    double calculateFee() {
        return 25 + 2.00 * weight + 0.50 * distance + customsFee;
    }
}

public class Main {
    static Delivery createDelivery(String type, double weight, double distance, double customsFee) {
        switch (type) {
            case "STANDARD":
                return new StandardDelivery(weight, distance);
            case "EXPRESS":
                return new ExpressDelivery(weight, distance);
            default:
                return new InternationalDelivery(weight, distance, customsFee);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            double customsFee = type.equals("INTERNATIONAL") ? sc.nextDouble() : 0;

            Delivery delivery = createDelivery(type, weight, distance, customsFee);
            double fee = delivery.calculateFee();

            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
