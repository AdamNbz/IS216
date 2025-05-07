package lab2.homework.c2;
import java.util.*;
import java.text.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class HangDienMay extends HangHoa {
    private String thuongHieu;
    private String loaiMay;
    private int thoiGianBaoHanh;
    
    public HangDienMay() 
    {
        super();
        this.thuongHieu = "";
        this.loaiMay = "";
        this.thoiGianBaoHanh = 0;
    }
    
    public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia, String thuongHieu, String loaiMay, int thoiGianBaoHanh) 
    {
        super(maHang, tenHang, soLuongTon, donGia);
        this.thuongHieu = thuongHieu;
        this.loaiMay = loaiMay;
        this.thoiGianBaoHanh = thoiGianBaoHanh;
    }
    
    public String getThuongHieu() { return thuongHieu; }
    public String getLoaiMay() { return loaiMay; }
    
    @Override
    public double thanhTien() 
    {
        double tien = soLuongTon * donGia;
        double vat = tien * 0.10;
        return tien + vat;
    }
    
    @Override
    public String danhGia() 
    {
        if (soLuongTon < 3) return "Bán được";
        else return "";
    }
    
    @Override
    public String toString() 
    {
        return "Hàng điện máy:\n" + super.toString() +  String.format("\nThương hiệu: %s\nLoại máy: %s\nBảo hành: %d tháng", thuongHieu, loaiMay, thoiGianBaoHanh);
    }
}
