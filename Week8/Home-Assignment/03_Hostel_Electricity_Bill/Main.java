import java.util.Scanner;

abstract class Room {
    protected final int units;

    Room(int units) {
        this.units = units;
    }

    abstract double bill();
}

class SingleRoom extends Room {
    SingleRoom(int units) { super(units); }
    double bill() { return units * 8.0; }
}

class SharedRoom extends Room {
    private final int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double bill() {
        return units * 6.0 / occupants;
    }
}

class AcRoom extends Room {
    AcRoom(int units) { super(units); }
    double bill() { return units * 10.0 + 200; }
}

public class Main {
    static Room createRoom(String type, int units, int occupants) {
        switch (type) {
            case "SINGLE":
                return new SingleRoom(units);
            case "SHARED":
                return new SharedRoom(units, occupants);
            default:
                return new AcRoom(units);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            int occupants = type.equals("SHARED") ? sc.nextInt() : 0;

            Room room = createRoom(type, units, occupants);
            double bill = room.bill();

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
