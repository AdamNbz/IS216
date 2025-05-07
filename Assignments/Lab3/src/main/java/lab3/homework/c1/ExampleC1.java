package lab3.homework.c1;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class ExampleC1 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.print("Nhập mã sinh viên (số nguyên): ");
            long masv = Long.parseLong(sc.nextLine());
            System.out.print("Nhập tên sinh viên: ");
            String tensv = sc.nextLine();
            System.out.print("Nhập điểm: ");
            double diem = Double.parseDouble(sc.nextLine());
            if (diem < 0 || diem > 10) 
                throw new Exception("Điểm nhập vào không hợp lệ (phải từ 0 đến 10).");
            SinhVien sv = new SinhVien(masv, tensv, diem);
            System.out.println("Thông tin sinh viên:");
            System.out.println(sv);
        }
        catch (NumberFormatException e) 
        {
            System.out.println("Lỗi: Bạn phải nhập số cho mã sinh viên và điểm.");
        }
        catch (Exception e)
        {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
