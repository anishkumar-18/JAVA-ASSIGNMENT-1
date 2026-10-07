import java.util.Scanner;

abstract class Transport {
    protected final double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bus extends Transport {
    Bus(double distance) { super(distance); }

    double calculateFare() {
        return Math.min(10, 2 + 0.10 * distance);
    }
}

class Train extends Transport {
    Train(double distance) { super(distance); }

    double calculateFare() {
        return 3 + 0.15 * distance;
    }
}

class Metro extends Transport {
    private final double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    double calculateFare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }
}

public class Main {
    static Transport createTransport(String type, double distance, double factor) {
        switch (type) {
            case "BUS":
                return new Bus(distance);
            case "TRAIN":
                return new Train(distance);
            default:
                return new Metro(distance, factor);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            double factor = type.equals("METRO") ? sc.nextDouble() : 1;

            Transport transport = createTransport(type, distance, factor);
            double fare = transport.calculateFare();

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
