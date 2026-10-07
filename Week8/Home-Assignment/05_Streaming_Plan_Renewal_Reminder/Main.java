import java.time.LocalDate;
import java.util.Scanner;

abstract class Plan {
    protected final String name;
    protected final LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int validityDays();

    LocalDate renewalDate() {
        return startDate.plusDays(validityDays());
    }
}

class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
    int validityDays() { return 30; }
}

class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
    int validityDays() { return 90; }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
    int validityDays() { return 365; }
}

public class Main {
    static Plan createPlan(String type, String name, LocalDate startDate) {
        switch (type) {
            case "BASIC":
                return new BasicPlan(name, startDate);
            case "STANDARD":
                return new StandardPlan(name, startDate);
            default:
                return new PremiumPlan(name, startDate);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Plan plan = createPlan(type, name, startDate);
            System.out.println(plan.name + ": " + plan.renewalDate());
        }

        sc.close();
    }
}
