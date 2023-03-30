package oopsBasics1;

import accessModifiers.User;

public class CohesionCoupling {

    public static void showCohesionExample() {
        LowCohesion lowCohesion = new LowCohesion();
        lowCohesion.main();

        HighCohesion highCohesion = new HighCohesion();
        String dbConnection = highCohesion.getDBConnection();
        highCohesion.printNameInModal(dbConnection);
    }

    public static void showCouplingExample() {
        //Highly Coupled
        //Cuboid Area is dependent on Dimension class
        CuboidArea cb1 = new CuboidArea();
        cb1.calculateArea();

        //Loosely Coupled
        //Circle Area is not dependent on Dimension class
        CircleArea cb2 = new CircleArea(10);
        cb2.calculateArea();

    }

    public static void main(String[] args) {
        showCohesionExample();

    }
}

//Multiple operation are performed High Cohesion
class HighCohesion {
    private String dbConnection;

    public String getDBConnection() {
        return this.dbConnection;
    }

    public void printNameInModal(String str) {
        System.out.println(str);
    }
}

//Single operation are performed in Individual classes Loose Cohesion
class LowCohesion {
    public static void main() {
        DBConnection conn = new DBConnection();
        Modal modal = new Modal();
        modal.print(conn.getDbConnection());
    }
}


class DBConnection {
    private String dbConnection;

    public String getDbConnection() {
        return dbConnection;
    }

    public void setDbConnection(String key) {
        //generate connection with key
        this.dbConnection = key;
    }
}

class Modal {
    public void print(String name) {
        System.out.println(name);
    }
}

class LowCoupling {

}

class HighCoupling {

}

class CuboidArea {
    Dimension dm;

    int calculateArea() {
        Dimension dm = new Dimension(10, 12, 15);
        return dm.l * dm.b * dm.h;
    }
}

class Dimension {
    int l;
    int b;
    int h;

    Dimension(int l, int b, int h) {
        this.l = l;
        this.b = b;
        this.h = h;
    }
}

class CircleArea {
    int radius;
    private static final double pi = 3.14;

    double calculateArea() {
        return pi * this.radius;
    }

    CircleArea(int radius) {
        this.radius = radius;
    }
}