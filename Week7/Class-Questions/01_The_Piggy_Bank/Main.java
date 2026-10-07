class PiggyBank {
    private double savings;
    private final String id;

    PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    void withdraw(double amount) {
        if (amount <= 0 || amount > savings) {
            return;
        }
        savings -= amount;
    }

    double getSavings() {
        return savings;
    }

    String getId() {
        return id;
    }
}

public class Main {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);

        System.out.println("ID: " + pb.getId());
        System.out.println("Savings: " + pb.getSavings());
    }
}
