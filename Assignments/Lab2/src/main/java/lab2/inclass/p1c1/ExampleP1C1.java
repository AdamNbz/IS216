package lab2.inclass.p1c1;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class ExampleP1C1 {
    public static void main(String[] args)
    {
        Pointer p1 = new Pointer();
        Pointer p2 = new Pointer(2, 3);
        
        System.out.println("Toạ độ điểm 1 ban đầu: " + p1);
        System.out.println("Toạ độ điểm 2 ban đầu: " + p2);
        System.out.println("Khoảng cách của hai điểm ban đầu: " + p1.distance(p2));
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập toạ độ cho điểm 1: ");
        p1.scanIn(sc);
        System.out.println("Nhập toạ độ cho điểm 2: ");
        p2.scanIn(sc);
        
        System.out.println("Toạ độ điểm 1 sau khi nhập: " + p1);
        System.out.println("Toạ độ điểm 2 sau khi nhập: " + p2);
        System.out.println("Khoảng cách của hai điểm đã nhập: " + p1.distance(p2));
    }
}
