package lab2.inclass.p1c3;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */
public class ExampleP1C3 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        SinhVien sv1 = new SinhVien(), sv2 = new SinhVien(), sv3 = new SinhVien();

        System.out.println("Nhập thông tin sinh viên 1: ");
        sv1.scanIn(sc);
        
        System.out.println("Nhập thông tin sinh viên 2: ");
        sv2.scanIn(sc);
        
        System.out.println("Nhập thông tin sinh viên 3: ");
        sv3.scanIn(sc);
        
        System.out.println(String.format("%-10s %-20s %-10s %-10s %-10s", "Mã sinh viên", "Họ Tên", "Điểm LT", "Điểm TH", "Điểm TB"));
        System.out.println(sv1);
        System.out.println(sv2);
        System.out.println(sv3);
    }
}
