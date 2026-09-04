import java.util.Scanner;

public class Week2_P3_FileExtensionValidator {

    public static String validateFileExtension(
            String filename) {

        int lastDot = filename.lastIndexOf('.');

        if (lastDot == -1 ||
            lastDot == filename.length() - 1) {

            return "Rejected — invalid file type";
        }

        String extension =
                filename.substring(lastDot + 1);

        if (extension.equalsIgnoreCase("pdf") ||
            extension.equalsIgnoreCase("docx") ||
            extension.equalsIgnoreCase("zip")) {

            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String filename = sc.nextLine();

        System.out.println(
                validateFileExtension(filename)
        );

        sc.close();
    }
}
