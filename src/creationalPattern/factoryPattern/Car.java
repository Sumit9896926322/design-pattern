package creationalPattern.factoryPattern;

interface ICarBuilder {
    void buildSunRoof();

    void buildAutomatic();

    void setPrice(int price);

    void setSeats(int seats);
}

class CarBuilder implements ICarBuilder {
    int seats;
    float price;
    boolean hasSunRoof;
    boolean isAutomatic;

    @Override
    public void buildSunRoof() {
        hasSunRoof = true;
    }

    @Override
    public void buildAutomatic() {
        isAutomatic = true;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    public CarType buildCar() {
        return new CarType(this);
    }

}

class CarType {
    String name;
    int seats;
    float price;
    boolean hasSunRoof;
    boolean isAutomatic;

    CarType(CarBuilder factory) {
        this.seats = factory.seats;
        this.price = factory.price;
        this.hasSunRoof = factory.hasSunRoof;
        this.isAutomatic = factory.isAutomatic;
    }
}

class Director {
    CarBuilder factory;

    Director(CarBuilder factory, String name) {
        this.factory = factory;
        if (name.equals("Ferrari")) {
            this.buildFerrari();
        }
    }

    CarType buildFerrari() {
        this.factory.buildAutomatic();
        this.factory.buildSunRoof();
        this.factory.setSeats(2);
        this.factory.setPrice(5000000);

        return this.factory.buildCar();
    }

    CarType buildNano() {
        this.factory.setSeats(4);
        this.factory.setPrice(100000);

        return this.factory.buildCar();
    }
}

public class Car {
    public static void main(String[] args) {
        CarBuilder builder = new CarBuilder();
        Director director = new Director(builder, "Ferrari");

        CarType ferrari = director.buildFerrari();
        CarType nano = director.buildNano();

        System.out.println(ferrari.seats + " " + ferrari.price);
        System.out.println(nano.seats + " " + nano.price);
    }

}


