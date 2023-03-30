package oopsBasics1;

enum Gender {
    MALE,
    FEMALE,
}

class Human {
    int age;
    String name;
    private Gender gender;
    public static int maleCount = 0;
    public static int femaleCount = 0;

    public void setGender(Gender gender) {
        if (gender == Gender.FEMALE) {
            Human.femaleCount++;
        } else {
            Human.maleCount++;
        }
        this.gender = gender;
    }

    public Gender getGender() {
        return this.gender;
    }

    Human(){
        System.out.println("A New Human Created");
    }

      Human(int age, String name) {
        this();
        this.age = age;
        this.name = name;
    }
}

class Employee extends Human {
    static int EmployeeCount;
    private int salary;
    public int getSalary() {
        return salary;
    }

    Employee(String name, int age, int salary) {
        Employee.EmployeeCount++;
        System.out.println("A New Employee Created");
        this.salary = salary;
    }
}

public class OopsBasic1 {
    public static void main(String[] args) {
        Employee bob =new Employee("bob",23,50000);
        bob.setGender(Gender.MALE);
        Employee alice =new Employee("alice",21,30000);
        alice.setGender(Gender.FEMALE);

        System.out.println("No. of employees"+Employee.EmployeeCount);
        System.out.println("No. of male"+Human.maleCount);
        System.out.println("No. of female"+Human.femaleCount);
    }

}
