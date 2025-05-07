package lab2.homework.c2;
import java.util.*;
import java.text.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class HangThucPham extends HangHoa {
    private String ngaySanXuat;
    private String ngayHetHan;
    private String nhaCungCap;
    
    public HangThucPham() 
    {
        super();
        this.ngaySanXuat = "";
        this.ngayHetHan = "";
        this.nhaCungCap = "";
    }
    
    public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia, String ngaySanXuat, String ngayHetHan, String nhaCungCap) 
    {
        super(maHang, tenHang, soLuongTon, donGia);
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
    }
    
    @Override
    public double thanhTien() 
    {
        double tien = soLuongTon * donGia;
        double vat = tien * 0.05;
        return tien + vat;
    }
    
    @Override
    public String danhGia() 
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try 
        {
            Date hetHan = sdf.parse(ngayHetHan);
            Date now = new Date();
            if (now.after(hetHan) && soLuongTon > 2) return "Khó bán";
        } 
        catch (ParseException e) {}
        return "";
    }
    
    @Override
    public String toString() 
    {
        return "Hàng thực phẩm:\n" + super.toString() + String.format("\nNgày SX: %s\nNgày HH: %s\nNhà cung cấp: %s", ngaySanXuat, ngayHetHan, nhaCungCap);
    }
}
