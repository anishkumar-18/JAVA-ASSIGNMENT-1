import java.util.Arrays;
import java.util.Scanner;

public class Week1_P2_PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        for (int left = 0, right = text.length() - 1;
             left < right;
             left++, right--) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursive(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursive(
            String text,
            int left,
            int right) {

        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return isPalindromeRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = Arrays.copyOf(original, original.length);

        for (int left = 0, right = reversed.length - 1;
             left < right;
             left++, right--) {

            char temp = reversed[left];
            reversed[left] = reversed[right];
            reversed[right] = temp;
        }

        return Arrays.equals(original, reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println(
                "Iterative: " +
                (isPalindromeIterative(text)
                        ? "Palindrome"
                        : "Not Palindrome")
        );

        System.out.println(
                "Recursive: " +
                (isPalindromeRecursive(text)
                        ? "Palindrome"
                        : "Not Palindrome")
        );

        System.out.println(
                "Array Reversal: " +
                (isPalindromeArrayReversal(text)
                        ? "Palindrome"
                        : "Not Palindrome")
        );

        sc.close();
    }
}
