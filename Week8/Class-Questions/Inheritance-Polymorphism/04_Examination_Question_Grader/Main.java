import java.util.Scanner;

abstract class ExamQuestion {
    protected final String type;
    protected final String correctAnswer;
    protected final String studentAnswer;
    protected final double points;

    ExamQuestion(String type, String correctAnswer, String studentAnswer, double points) {
        this.type = type;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double score();
}

class MCQQuestion extends ExamQuestion {
    MCQQuestion(String correctAnswer, String studentAnswer, double points) {
        super("MCQ", correctAnswer, studentAnswer, points);
    }

    double score() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class TFQuestion extends ExamQuestion {
    TFQuestion(String correctAnswer, String studentAnswer, double points) {
        super("TF", correctAnswer, studentAnswer, points);
    }

    double score() {
        return studentAnswer.equals(correctAnswer) ? points : 0;
    }
}

class EssayQuestion extends ExamQuestion {
    EssayQuestion(String correctAnswer, String studentAnswer, double points) {
        super("ESSAY", correctAnswer, studentAnswer, points);
    }

    double score() {
        String answer = studentAnswer.toLowerCase();
        String[] keywords = correctAnswer.split(",");
        int matched = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        }
        if (matched == 1) {
            return points * 0.50;
        }
        return 0;
    }
}

public class Main {
    static ExamQuestion createQuestion(String type, String correct, String student, double points) {
        switch (type) {
            case "MCQ":
                return new MCQQuestion(correct, student, points);
            case "TF":
                return new TFQuestion(correct, student, points);
            default:
                return new EssayQuestion(correct, student, points);
        }
    }

    static String unquote(String value) {
        value = value.trim();
        if (value.startsWith("\"") && value.endsWith("\"")) {
            return value.substring(1, value.length() - 1);
        }
        return value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            java.util.List<String> tokens = new java.util.ArrayList<>();
            java.util.regex.Matcher matcher =
                    java.util.regex.Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);

            while (matcher.find()) {
                tokens.add(matcher.group(1) != null ? matcher.group(1) : matcher.group(2));
            }

            String type = tokens.get(0);
            if ("ESSAY".equals(type)) {
                double points = Double.parseDouble(tokens.get(tokens.size() - 1));
                String correct = tokens.get(2);
                String student = tokens.get(3);

                ExamQuestion question = createQuestion(type, correct, student, points);
                double score = question.score();

                System.out.printf("%s: %.2f%n", type, score);
                total += score;
            } else {
                String correct = tokens.get(2);
                String student = tokens.get(3);
                double points = Double.parseDouble(tokens.get(4));

                ExamQuestion question = createQuestion(type, correct, student, points);
                double score = question.score();

                System.out.printf("%s: %.2f%n", type, score);
                total += score;
            }
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
