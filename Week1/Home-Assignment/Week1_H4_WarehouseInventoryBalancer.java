import java.util.Scanner;

public class Week1_H4_WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null || sectionA.length != sectionB.length) {
            System.out.println("Error: Both sections must be non-null and have equal length.");
            return;
        }

        int sectionATotal = 0;
        int sectionBTotal = 0;

        for (int quantity : sectionA) {
            sectionATotal += quantity;
        }

        for (int quantity : sectionB) {
            sectionBTotal += quantity;
        }

        String status = sectionATotal == sectionBTotal ? "Balanced" : "Not Balanced";

        int highestQuantity = Integer.MIN_VALUE;
        String highestSection = "";
        int highestIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }

            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.println(
            "Section A Total: " + sectionATotal +
            " | Section B Total: " + sectionBTotal +
            " | Status: " + status +
            " | Highest Quantity: " + highestQuantity +
            " (" + highestSection + ", Item " + (highestIndex + 1) + ")"
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array length: ");
        int length = scanner.nextInt();

        int[] sectionA = new int[length];
        int[] sectionB = new int[length];

        System.out.println("Enter Section A quantities:");
        for (int i = 0; i < length; i++) {
            sectionA[i] = scanner.nextInt();
        }

        System.out.println("Enter Section B quantities:");
        for (int i = 0; i < length; i++) {
            sectionB[i] = scanner.nextInt();
        }

        analyzeInventory(sectionA, sectionB);
        scanner.close();
    }
}
