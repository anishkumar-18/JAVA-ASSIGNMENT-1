import java.util.Scanner;

public class Week1_H1_SeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        if (seatNumbers == null || seatNumbers.length < 2) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        for (int i = 0; i < seatNumbers.length - 1; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of seats: ");
        int count = scanner.nextInt();

        int[] seatNumbers = new int[count];

        System.out.println("Enter seat numbers:");
        for (int i = 0; i < count; i++) {
            seatNumbers[i] = scanner.nextInt();
        }

        checkDuplicateSeats(seatNumbers);
        scanner.close();
    }
}
