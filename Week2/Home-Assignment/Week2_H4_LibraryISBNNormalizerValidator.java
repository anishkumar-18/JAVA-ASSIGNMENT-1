import java.util.Scanner;

public class Week2_H4_LibraryISBNNormalizerValidator {

    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }

        String code = raw.trim();

        if (code.length() < 3) {
            return code;
        }

        String publisherCode = code.substring(0, 3).toUpperCase();
        return publisherCode + code.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        StringBuilder formatted = new StringBuilder();

        formatted.append("[")
                 .append(publisherCode)
                 .append("] YEAR: ")
                 .append(year)
                 .append(" | CATALOG: ")
                 .append(catalog);

        return formatted.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ISBN-style code: ");
        String raw = scanner.nextLine();

        String normalizedCode = normalizeCode(raw);
        System.out.println(validateAndFormat(normalizedCode));

        scanner.close();
    }
}