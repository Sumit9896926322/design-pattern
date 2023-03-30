package oopsBasics1;

public class PrivateConstructorDemo {

    public static void main(String[] args) {
        PrivateConstructorClass p1 = PrivateConstructorClass.getPrivateObject();
        PrivateConstructorClass p2 = PrivateConstructorClass.getPrivateObject();
        System.out.println(p1.equals(p2));
    }
}

//Singleton Pattern
class PrivateConstructorClass {
    private static PrivateConstructorClass p1;
    public static PrivateConstructorClass getPrivateObject() {
        if (p1 == null) {
            p1 = new PrivateConstructorClass();
        }
        return p1;
    }

    private PrivateConstructorClass() {
        //Object creation will happen only one time
        System.out.println("Private Constructor Called");
    }
}



