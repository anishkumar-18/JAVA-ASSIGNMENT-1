import java.util.Scanner;

abstract class Staff {
    protected final String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double pay();
}

class FullTimeStaff extends Staff {
    private final double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    double pay() { return weeklySalary; }
}

class HourlyStaff extends Staff {
    private final double hours;
    private final double rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double pay() {
        if (hours <= 40) {
            return hours * rate;
        }
        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class InternStaff extends Staff {
    private final double stipend;

    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double pay() { return stipend; }
}

public class Main {
    static Staff createStaff(String type, String name, double a, double b) {
        switch (type) {
            case "FULLTIME":
                return new FullTimeStaff(name, a);
            case "HOURLY":
                return new HourlyStaff(name, a, b);
            default:
                return new InternStaff(name, a);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double a = sc.nextDouble();
            double b = type.equals("HOURLY") ? sc.nextDouble() : 0;

            Staff staff = createStaff(type, name, a, b);
            double pay = staff.pay();

            System.out.printf("%s: %.2f%n", staff.name, pay);
            total += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}
