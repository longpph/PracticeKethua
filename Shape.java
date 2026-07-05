import java.util.Arrays;

public class Shape {
    private String color = "green";
    private boolean filled = true;

    public Shape() {
    }
    
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with color of " + getColor() + " and " + (isFilled() ? "filled" : "not filled");
    }
}

class Circle extends Shape {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle (double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius=" + getRadius() + ", which is a subclass of " + super.toString();
    }
}

class Rectangle extends Shape {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width=" + getWidth() + " and length=" + getLength() + ", which is a subclass of " + super.toString();
    }
}

class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    
}

class ComparableCircle extends Circle
        implements Comparable<ComparableCircle> {

    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 0;
    }
}

class Main {
    public static void main (String[] args) {
        System.out.println("---Test Shape---");
        Shape shape = new Shape();
        System.out.println(shape);

        Shape shape2 = new Shape("red", false);
        System.out.println(shape2);

        System.out.println("---Test Circle---");
        Circle circle = new Circle();
        System.out.println(circle);

        Circle circle2 = new Circle(4.0);
        System.out.println(circle2);
        System.out.printf("Diện tích Circle: %.2f\n", circle2.getArea());
        System.out.printf("Chu vi Circle: %.2f\n", circle2.getPerimeter());
        System.out.println();

        Circle circle3 = new Circle(3.5, "yellow", false);
        System.out.println(circle3);
        System.out.printf("Diện tích Circle: %.2f\n", circle3.getArea());
        System.out.printf("Chu vi Circle: %.2f\n", circle3.getPerimeter());
        System.out.println();

        System.out.println("---Test Rectangle---");
        Rectangle rectangle1 = new Rectangle();
        System.out.println(rectangle1);

        Rectangle rectangle2 = new Rectangle(2.0, 2.5);
        System.out.println(rectangle2);
        System.out.printf("Diện tích Rectangle: %.2f\n", rectangle2.getArea());
        System.out.printf("Chu vi Rectangle: %.2f\n", rectangle2.getPerimeter());

        Rectangle rectangle3 = new Rectangle(4.0, 4.5, "yellow", false);
        System.out.println(rectangle3);
        System.out.printf("Diện tích Rectangle: %.2f\n", rectangle3.getArea());
        System.out.printf("Chu vi Rectangle: %.2f\n", rectangle3.getPerimeter());
    
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(3.6);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(3.5, "indigo", false);

        System.out.println("Pre-sorted:");
        for (ComparableCircle circlee : circles) {
            System.out.println(circlee);
        }

        Arrays.sort(circles);

        System.out.println("After-sorted:");
        for (ComparableCircle circlee : circles) {
            System.out.println(circlee);
        }
    }
}