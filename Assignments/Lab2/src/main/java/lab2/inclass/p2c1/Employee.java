package lab2.inclass.p2c1;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class Employee extends Person {
    private double salary;
    
    public Employee() { super(); this.salary = 0; }
    public Employee(String name, int age, double salary) { super(name, age); this.salary = salary; }
    
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    
    @Override
    public void show()
    {
        System.out.println("Employee: " + getName() + "\nAge: " + getAge() + "\nSalary: " + salary);
    }
    
    @Override
    public Employee scanIn(Scanner sc)
    {
        System.out.print("Nhập tên nhân viên: ");
        String name = sc.nextLine();
        
        System.out.print("Nhập tuổi nhân viên: ");
        int age = Integer.parseInt(sc.nextLine());
        
        System.out.print("Nhập lương nhân viên: ");
        double salary = Double.parseDouble(sc.nextLine());
        
        return new Employee(name, age, salary);
    }
    
    public void incSalary() { setSalary(this.salary * 1.1); }
    
    public void incSalary(double add) { setSalary(this.salary + add); }
}
