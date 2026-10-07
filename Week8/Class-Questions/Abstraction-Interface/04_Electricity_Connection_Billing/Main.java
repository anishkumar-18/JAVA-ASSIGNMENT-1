import java.util.Scanner;

abstract class Connection {
    protected final double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double bill();
}

class HomeConnection extends Connection {
    HomeConnection(double units) { super(units); }

    double bill() {
        if (units <= 100) {
            return units * 5;
        }
        return 100 * 5 + (units - 100) * 7;
    }
}

class ShopConnection extends Connection {
    ShopConnection(double units) { super(units); }
    double bill() { return units * 8 + 100; }
}

class FactoryConnection extends Connection {
    FactoryConnection(double units) { super(units); }
    double bill() { return Math.max(1000, units * 6); }
}

public class Main {
    static Connection createConnection(String type, double units) {
        switch (type) {
            case "HOME":
                return new HomeConnection(units);
            case "SHOP":
                return new ShopConnection(units);
            default:
                return new FactoryConnection(units);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            Connection connection = createConnection(type, units);
            double bill = connection.bill();

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
