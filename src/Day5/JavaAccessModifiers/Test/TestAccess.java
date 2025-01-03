package Day5.JavaAccessModifiers.Test;

import Day5.JavaAccessModifiers.AccessModifierExample.Employee;
import Day5.JavaAccessModifiers.AccessModifierExample.Person;

public class TestAccess{
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Arun", 21, "KSR", 50000);
        System.out.println("Accessible from the subclass of the same package:");
        employee.getAccessible();

        System.out.println("Accessible from other package using object:");
        System.out.println("Name: " + employee.name);
    }
}
