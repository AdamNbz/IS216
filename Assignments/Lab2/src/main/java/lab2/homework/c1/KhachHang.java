package lab2.homework.c1;
import java.util.*;
import java.text.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public abstract class KhachHang {
    protected String maKhachHang;
    protected String tenKhachHang;
    protected String ngayHoaDon;
    protected double soLuongDien;
    protected double donGia;
    
    public KhachHang() 
    {
        this.maKhachHang = "";
        this.tenKhachHang = "";
        this.ngayHoaDon = "";
        this.soLuongDien = 0;
        this.donGia = 0;
    }
    
    public KhachHang(String maKhachHang, String tenKhachHang, String ngayHoaDon, double soLuongDien, double donGia) 
    {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.ngayHoaDon = ngayHoaDon;
        this.soLuongDien = soLuongDien;
        this.donGia = donGia;
    }
    
    public String getMaKhachHang() { return maKhachHang; }
    public String getTenKhachHang() { return tenKhachHang; }
    public String getNgayHoaDon() { return ngayHoaDon; }
    public double getSoLuongDien() { return soLuongDien; }
    public double getDonGia() { return donGia; }
    
    public abstract double tinhThanhTien();
    
    public int getMonth() {
        try 
        {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(ngayHoaDon);
            return date.getMonth() + 1;
        } 
        catch (ParseException e) 
        {
            return -1;
        }
    }
    
    public int getYear() 
    {
        try 
        {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(ngayHoaDon);
            return date.getYear() + 1900;
        } 
        catch (ParseException e) 
        {
            return -1;
        }
    }
    
    @Override
    public String toString() 
    {
        return String.format("Mã KH: %s\nTên KH: %s\nNgày HĐ: %s\nSố điện: %.2f\nThành tiền: %.2f", 
                            maKhachHang, tenKhachHang, ngayHoaDon, soLuongDien, tinhThanhTien());
    }
}
