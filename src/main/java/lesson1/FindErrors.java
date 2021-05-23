package lesson1;
//errors comments over the lines with errors

interface Moveable {
    void move();
}

interface Stopable {
    void stop();
}

//create class Engine
class Engine{
}

abstract class Car {
    //Engine -> private
    private Engine engine;
    private String color;
    private String name;

    protected void start() {
        System.out.println("Car starting");
    }

    abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(final Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}

class LightWeightCar extends Car implements Moveable{

    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

}

//extends Car, but implements interfaces
class Lorry extends Car implements Moveable, Stopable{

    //add annotation @Override
    @Override
    public void move(){
        System.out.println("Car is moving");
    }

    //add annotation @Override
    @Override
    public void stop(){
        System.out.println("Car is stop");
    }

    //adding implementing method open
    @Override
    void open() {
        System.out.println("Car is opened");
    }
}

public class FindErrors {
    public static void main(String[] args) {
        Car light = new LightWeightCar();
        light.open();
        light.start();

        Car lorry = new Lorry();
        lorry.open();
        lorry.start();
    }
}

