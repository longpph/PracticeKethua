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

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
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
    
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side=" + getSide() + ", which is a subclass of " + super.toString();
    }
}

class Main {
    public static void main(String[] args) {

        System.out.println("----- TEST SHAPE -----");
        Shape shape1 = new Shape();
        System.out.println(shape1);

        Shape shape2 = new Shape("red", false);
        System.out.println(shape2);
        System.out.println();


        System.out.println("----- TEST CIRCLE -----");
        Circle circle1 = new Circle();
        System.out.println(circle1);

        Circle circle2 = new Circle(3.5, "indigo", false);
        System.out.println(circle2);
        System.out.printf("Diện tích Circle: %.2f\n", circle2.getArea());
        System.out.printf("Chu vi Circle: %.2f\n", circle2.getPerimeter());
        System.out.println();


        System.out.println("----- TEST RECTANGLE -----");
        Rectangle rect1 = new Rectangle();
        System.out.println(rect1);

        Rectangle rect2 = new Rectangle(2.5, 4.0, "yellow", true);
        System.out.println(rect2);
        System.out.printf("Diện tích Rectangle: %.2f\n", rect2.getArea());
        System.out.printf("Chu vi Rectangle: %.2f\n", rect2.getPerimeter());
        System.out.println();

        System.out.println("----- TEST SQUARE -----");
        Square square1 = new Square();
        System.out.println(square1);

        Square square2 = new Square(5.0, "pink", true);
        System.out.println(square2);
        System.out.printf("Diện tích Square: %.2f\n", square2.getArea());
        System.out.printf("Chu vi Square: %.2f\n", square2.getPerimeter());
        System.out.println();


        System.out.println("----- TEST THAY ĐỔI KÍCH THƯỚC SQUARE -----");
        System.out.println("Trạng thái ban đầu: " + square2);
        
        System.out.println("-> Thực hiện: square2.setWidth(8.0);");
        square2.setWidth(8.0);
        System.out.println("Trạng thái sau khi setWidth: " + square2);
        System.out.printf("Diện tích mới: %.2f (Kỳ vọng: 8 * 8 = 64)\n", square2.getArea());
        
        System.out.println();
        System.out.println("-> Thực hiện: square2.setSide(10.0);");
        square2.setSide(10.0);
        System.out.println("Trạng thái sau khi setSide: " + square2);
        System.out.printf("Diện tích mới: %.2f (Kỳ vọng: 10 * 10 = 100)\n", square2.getArea());
    }
}