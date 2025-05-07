package lab2.homework.c1;
import java.util.*;
import java.text.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class KhachHangSinhHoat extends KhachHang {
    private double dinhMuc;
    
    public KhachHangSinhHoat() 
    {
        super();
        this.dinhMuc = 0;
    }
    
    public KhachHangSinhHoat(String maKhachHang, String tenKhachHang, String ngayHoaDon, double soLuongDien, double donGia, double dinhMuc) 
    {
        super(maKhachHang, tenKhachHang, ngayHoaDon, soLuongDien, donGia);
        this.dinhMuc = dinhMuc;
    }
    
    @Override
    public double tinhThanhTien() 
    {
        if (soLuongDien <= dinhMuc) 
            return soLuongDien * donGia;
        else 
            return dinhMuc * donGia + (soLuongDien - dinhMuc) * donGia * 2;
    }
    
    @Override
    public String toString() 
    {
        return "Khách hàng Sinh hoạt:\n" + super.toString();
    }
}
