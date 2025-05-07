package lab2.inclass.p2c1;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class ExampleP2C1 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Employee nhanVien = new Employee().scanIn(sc);
        
        nhanVien.show();
        
        nhanVien.incSalary();
        System.out.println("\nSau khi tăng lương 10%:");
        nhanVien.show();
        
        nhanVien.incSalary(200);
        System.out.println("\nSau khi cộng 200 vào lương:");
        nhanVien.show();
    }
}
