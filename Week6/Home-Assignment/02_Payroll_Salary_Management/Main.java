class PayrollAccount {
    private double basicSalary;
    private double bonus;

    PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: negative salary rejected.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }
    }

    void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected.");
            return;
        }
        bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percentage.");
            return;
        }
        basicSalary -= basicSalary * percent / 100.0;
        System.out.println("Tax deducted: " + percent + "%");
    }

    double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
