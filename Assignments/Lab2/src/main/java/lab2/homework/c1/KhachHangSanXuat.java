package lab2.homework.c1;
import java.util.*;
import java.text.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class KhachHangSanXuat extends KhachHang {
    private String loaiDien;
    
    public KhachHangSanXuat() 
    {
        super();
        this.loaiDien = "";
    }
    
    public KhachHangSanXuat(String maKhachHang, String tenKhachHang, String ngayHoaDon, double soLuongDien, double donGia, String loaiDien) 
    {
        super(maKhachHang, tenKhachHang, ngayHoaDon, soLuongDien, donGia);
        this.loaiDien = loaiDien;
    }
    
    @Override
    public double tinhThanhTien() 
    {
        double thanhTien = soLuongDien * donGia;
        if (loaiDien.equalsIgnoreCase("2 pha") && soLuongDien > 200) 
        {
            double discount = (soLuongDien - 200) * donGia * 0.02;
            return thanhTien - discount;
        } 
        else if(loaiDien.equalsIgnoreCase("3 pha") && soLuongDien > 150) 
        {
            double discount = (soLuongDien - 150) * donGia * 0.03;
            return thanhTien - discount;
        }
        return thanhTien;
    }
    
    @Override
    public String toString() 
    {
        return "Khách hàng Sản xuất:\n" + super.toString() + "\nLoại điện: " + loaiDien;
    }
}
