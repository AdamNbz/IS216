package lab2.inclass.p1c2;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */
public class ExampleP1C2 {
    public static void main(String[] args)
    {
        HinhChuNhat hcn = new HinhChuNhat();
        
        System.out.println("Thông số hình chữ nhật: \n" + hcn);
        
        hcn = new HinhChuNhat(10, 5);
        System.out.println("\nThông số hình chữ nhật sau khi tái khởi tạo: \n" + hcn);
        
        System.out.println("\nNhập thông tin hình chữ nhật: ");
        Scanner sc = new Scanner(System.in);
        hcn.scanIn(sc);
        System.out.println("Thông số hình chữ nhật sau khi nhập: \n" + hcn);
    }
}
