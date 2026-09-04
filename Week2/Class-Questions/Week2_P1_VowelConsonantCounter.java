import java.util.Scanner;

public class Week2_P1_VowelConsonantCounter {

    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));

            if (c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u') {

                vowels++;
            } else if (c >= 'a' && c <= 'z') {
                consonants++;
            }
        }

        System.out.println(
                "Vowels: " +
                vowels +
                " | Consonants: " +
                consonants
        );
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        countVowelsAndConsonants(text);

        sc.close();
    }
}
