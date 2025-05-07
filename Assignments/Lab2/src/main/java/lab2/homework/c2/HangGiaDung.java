package lab2.homework.c2;
import java.util.*;
import java.util.concurrent.*;
import java.text.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class HangGiaDung extends HangHoa {
    private String nhaSanXuat;
    private String ngayNhap;
    private String loaiHang;
    
    public HangGiaDung() 
    {
        super();
        this.nhaSanXuat = "";
        this.ngayNhap = "";
        this.loaiHang = "";
    }
    
    public HangGiaDung(String maHang, String tenHang, int soLuongTon, double donGia, String nhaSanXuat, String ngayNhap, String loaiHang) 
    {
        super(maHang, tenHang, soLuongTon, donGia);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhap = ngayNhap;
        this.loaiHang = loaiHang;
    }
    
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try 
        {
            Date nhap = sdf.parse(ngayNhap);
            Date now = new Date();
            long diffInMillies = Math.abs(now.getTime() - nhap.getTime());
            long diffDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            if (soLuongTon > 10 && diffDays > 20) return "Bán chậm";
        } catch (ParseException e) {}
        return "";
    }
    
    @Override
    public String toString() 
    {
        return "Hàng gia dụng:\n" + super.toString() + String.format("\nNhà SX: %s\nNgày nhập: %s\nLoại: %s", nhaSanXuat, ngayNhap, loaiHang);
    }
}
