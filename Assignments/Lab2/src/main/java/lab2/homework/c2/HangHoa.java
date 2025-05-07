package lab2.homework.c2;
import java.util.*;
import java.text.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public abstract class HangHoa {
    protected String maHang;
    protected String tenHang;
    protected int soLuongTon;
    protected double donGia;
    
    public HangHoa() 
    {
        this.maHang = "";
        this.tenHang = "";
        this.soLuongTon = 0;
        this.donGia = 0;
    }
    
    public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) 
    {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
    }
    
    public String getMaHang() { return maHang; }
    public String getTenHang() { return tenHang; }
    public int getSoLuongTon() { return soLuongTon; }
    public double getDonGia() { return donGia; }
    
    public void setSoLuongTon(int soLuongTon) { this.soLuongTon = soLuongTon; }
    
    public abstract double thanhTien();
    public abstract String danhGia();
    
    @Override
    public String toString() 
    {
        return String.format("Mã hàng: %s\nTên hàng: %s\nSố lượng tồn: %d\nĐơn giá: %.2f\nThành tiền: %.2f\nĐánh giá: %s", 
                maHang, tenHang, soLuongTon, donGia, thanhTien(), danhGia());
    }
}
