import java.util.Scanner;

public class Week1_H3_TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No Signal Data");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char currentCharacter = signalLog.charAt(i);

            if (currentCharacter == currentColor) {
                currentLength++;
            } else {
                currentColor = currentCharacter;
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = currentColor;
            }
        }

        System.out.println(
            "Longest Streak: '" + longestColor + "' repeated " + longestLength + " times"
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter signal log: ");
        String signalLog = scanner.nextLine();

        findLongestStreak(signalLog);
        scanner.close();
    }
}
