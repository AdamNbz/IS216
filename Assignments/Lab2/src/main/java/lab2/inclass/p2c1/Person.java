package lab2.inclass.p2c1;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public abstract class Person {
    private String name;
    private int age;
    
    public Person() { this.name = new String(); this.age = 0; }
    public Person(String name, int age) { this.name = name; this.age = age; }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    
    public abstract void show();
    public abstract Employee scanIn(Scanner sc);
}
