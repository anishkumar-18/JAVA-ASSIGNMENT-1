import java.util.Scanner;

public class Week1_P5_ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();

        for (int left = 0, right = chars.length - 1;
             left < right;
             left++, right--) {

            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        System.out.println(
                "Original Name: " + customerName
        );

        System.out.println(
                "Reversed Name: " +
                reverseCustomerName(customerName)
        );

        sc.close();
    }
}
