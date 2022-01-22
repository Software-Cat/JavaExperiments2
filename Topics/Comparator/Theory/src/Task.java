// You can experiment here, it won’t be checked

import java.io.Serial;
import java.io.Serializable;
import java.util.*;

public class Task {

    private static final List<Employee> employees = new ArrayList<>(
            List.of(new Employee("Jake", 25, 3000.0, 9922001),
                    new Employee("Jake", 22, 2000.0, 5924001),
                    new Employee("Ace", 22, 3000.0, 6423001),
                    new Employee("Keith", 35, 4000.0, 3924401)));

    public static void main(String[] args) {
        employees.sort(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName));

        System.out.println(employees);
    }
}

class Employee implements Comparable<Employee>, Serializable {

    @Serial
    private static final long serialVersionUID = 6821379204112767364L;

    private String name;
    private int age;
    private double salary;
    private long mobile;

    public Employee(String name, int age, double salary, long mobile) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.mobile = mobile;
    }

    @Override
    public int compareTo(Employee other) {
        return name.compareTo(other.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Double.compare(employee.salary, salary) == 0 && mobile == employee.mobile && Objects.equals(name, employee.name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("age=" + age)
                .add("salary=" + salary)
                .add("mobile=" + mobile)
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, mobile);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }
}
