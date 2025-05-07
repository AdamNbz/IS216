package lab2.inclass.p1c1;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class Pointer {
    private double x, y;
    
    public Pointer() { this.x = 0; this.y = 0; }
    public Pointer(double x_, double y_) { this.x = x_; this.y = y_; }
    
    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x_) { this.x = x_; }
    public void setY(double y_) { this.y = y_; }
    
    public void scanIn(Scanner sc)
    {
        System.out.print("Nhập toạ độ x: ");
        setX(Double.parseDouble(sc.nextLine()));
        
        System.out.print("Nhập toạ độ y: ");
        setY(Double.parseDouble(sc.nextLine()));
    }
    
    public double distance(Pointer other)
    {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
    
    @Override
    public String toString() { return "[" + x + ", " + y + "]"; }
}
