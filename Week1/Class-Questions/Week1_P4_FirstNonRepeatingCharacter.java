import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Week1_P4_FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            frequency.put(
                    c,
                    frequency.getOrDefault(c, 0) + 1
            );
        }

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (frequency.get(c) == 1) {
                return c;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println(
                    "No Non-Repeating Character Found"
            );
        } else {
            System.out.println(
                    "First Non-Repeating Character: '" +
                    result +
                    "'"
            );
        }

        sc.close();
    }
}
