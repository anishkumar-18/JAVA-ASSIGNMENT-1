class Locker {
    private String code;
    private final int lockerNumber;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    boolean changeCode(String currentCode, String newCode) {
        if (code.equals(currentCode)) {
            code = newCode;
            return true;
        }
        return false;
    }

    int getLockerNumber() {
        return lockerNumber;
    }
}

public class Main {
    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");

        System.out.println("Correct code change: " + locker.changeCode("1234", "5678"));
        System.out.println("Wrong code change: " + locker.changeCode("0000", "9999"));
    }
}
