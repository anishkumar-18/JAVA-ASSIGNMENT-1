import java.util.Scanner;

abstract class Booking {
    protected final double distance;
    private static final double BOOKING_FEE = 50.0;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double baseFare();

    double totalFare() {
        return baseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    BusBooking(double distance) { super(distance); }
    double baseFare() { return 2 * distance; }
}

class TrainBooking extends Booking {
    TrainBooking(double distance) { super(distance); }
    double baseFare() { return 1.5 * distance; }
}

class FlightBooking extends Booking {
    FlightBooking(double distance) { super(distance); }
    double baseFare() { return 2500 + 4 * distance; }
}

public class Main {
    static Booking createBooking(String type, double distance) {
        switch (type) {
            case "BUS":
                return new BusBooking(distance);
            case "TRAIN":
                return new TrainBooking(distance);
            default:
                return new FlightBooking(distance);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Booking booking = createBooking(type, distance);
            System.out.printf("%s: %.2f%n", type, booking.totalFare());
        }

        sc.close();
    }
}
