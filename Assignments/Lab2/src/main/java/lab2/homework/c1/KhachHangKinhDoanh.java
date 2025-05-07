package lab2.homework.c1;
import java.util.*;
import java.text.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class KhachHangKinhDoanh extends KhachHang {
    public KhachHangKinhDoanh() { super(); }
    
    public KhachHangKinhDoanh(String maKhachHang, String tenKhachHang, String ngayHoaDon, double soLuongDien, double donGia) 
    {
        super(maKhachHang, tenKhachHang, ngayHoaDon, soLuongDien, donGia);
    }
    
    @Override
    public double tinhThanhTien() 
    {
        if(soLuongDien > 400) 
            return 400 * donGia + (soLuongDien - 400) * donGia * 1.05;
        else 
            return soLuongDien * donGia;
    }
    
    @Override
    public String toString() { return "Khách hàng Kinh doanh:\n" + super.toString(); }
}
