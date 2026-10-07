import java.util.Scanner;

abstract class Plot {
    protected final String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();
    abstract String shape();
}

class CirclePlot extends Plot {
    private final double radius;

    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double area() { return Math.PI * radius * radius; }
    String shape() { return "CIRCLE"; }
}

class RectanglePlot extends Plot {
    private final double length;
    private final double width;

    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double area() { return length * width; }
    String shape() { return "RECTANGLE"; }
}

class TrianglePlot extends Plot {
    private final double base;
    private final double height;

    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double area() { return 0.5 * base * height; }
    String shape() { return "TRIANGLE"; }
}

public class Main {
    static Plot createPlot(String type, String owner, double a, double b) {
        switch (type) {
            case "CIRCLE":
                return new CirclePlot(owner, a);
            case "RECTANGLE":
                return new RectanglePlot(owner, a, b);
            default:
                return new TrianglePlot(owner, a, b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();
            double a = sc.nextDouble();
            double b = type.equals("CIRCLE") ? 0 : sc.nextDouble();

            Plot plot = createPlot(type, owner, a, b);
            double area = plot.area();

            System.out.printf("%s (%s): %.2f%n", plot.owner, plot.shape(), area);
            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}
