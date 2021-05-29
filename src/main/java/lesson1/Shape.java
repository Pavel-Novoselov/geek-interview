package lesson1;

public abstract class Shape {
    protected int x;
    protected int y;

    protected Shape(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public abstract double area();

    public abstract void draw();

    public static void main(final String[] args) {
        final Shape rectangle = new Rectangle(1,2,3,4);
        final Shape triangle = new Triangle(5,6,17, 3,4);
        rectangle.draw();
        triangle.draw();
    }
}

class Rectangle extends Shape{
    private int with;
    private int height;

    Rectangle(final int x, final int y, final int with, final int height) {
        super(x,y);
        this.with = with;
        this.height = height;
    }

    @Override
    public double area() {
        return with * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing the rectangle with area " + area() + " from the point " + x + "." + y);
    }
}

class Triangle extends Shape{
    private double angle;
    private double sideOne;
    private double sideTwo;

    Triangle(final int x, final int y, final double angle, final double sideOne, final double sideTwo){
        super(x,y);
        this.angle = angle;
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
    }

    @Override
    public double area() {
        return (sideOne * sideTwo) / 2 * Math.sin(Math.toRadians(angle));
    }

    @Override
    public void draw() {
        System.out.println("Drawing the triangle with area " + area() + " from the point " + x + "." + y);
    }
}


