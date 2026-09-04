import java.util.Scanner;

public class Week3_L1_P2_ClassifyNumber {

    public static void classifyNumber(int number) {

        if (number > 0) {
            System.out.println("Positive");
        } else if (number < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        classifyNumber(number);

        sc.close();
    }
}