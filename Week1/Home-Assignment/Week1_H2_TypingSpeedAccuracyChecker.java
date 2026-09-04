import java.util.Scanner;

public class Week1_H2_TypingSpeedAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null || original.length() != typed.length()) {
            System.out.println("Error: Strings must be non-null and of equal length.");
            return;
        }

        int matchedCharacters = 0;
        int firstMismatchPosition = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i + 1;
            }
        }

        double accuracy = (matchedCharacters * 100.0) / original.length();

        if (firstMismatchPosition == -1) {
            System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                matchedCharacters,
                original.length(),
                accuracy
            );
        } else {
            char originalChar = original.charAt(firstMismatchPosition - 1);
            char typedChar = typed.charAt(firstMismatchPosition - 1);

            System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                matchedCharacters,
                original.length(),
                accuracy,
                firstMismatchPosition,
                originalChar,
                typedChar
            );
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = scanner.nextLine();

        System.out.print("Enter typed passage: ");
        String typed = scanner.nextLine();

        checkTypingAccuracy(original, typed);
        scanner.close();
    }
}
