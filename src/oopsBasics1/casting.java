package oopsBasics1;

public class casting {

    public static void main(String[] args) {
        //superAdmin has to see what Admin is doing as user and admin also
        User user = new Admin();//down-casting
        user.activity = "Just Logged In";

        Admin admin = (Admin) user;//up-casting
        System.out.println(admin.trackUser());

    }
}

class User {
    String activity;

    void performingSomeActivity() {

    }

}

class Admin extends User {
    String trackUser() {
        return this.activity;
    }
}
