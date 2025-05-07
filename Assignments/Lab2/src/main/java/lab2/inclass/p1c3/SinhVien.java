package lab2.inclass.p1c3;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class SinhVien {
    private int maSinhVien;
    private String hoTen;
    private float diemLT, diemTH;
    
    public SinhVien() { this.maSinhVien = 0; this.hoTen = new String(); this.diemLT = 0; this.diemTH = 0; }
    public SinhVien(int MSSV, String HoTen, float LT, float TH) 
    {
        this.maSinhVien = MSSV;
        this.hoTen = HoTen;
        this.diemLT = LT;
        this.diemTH = TH;
    }
    
    public int getMSSV() { return maSinhVien; }
    public void setMSSV(int MSSV) { this.maSinhVien = MSSV; }
    public String getHoTen() { return hoTen; }
    public void setHoTen(String HoTen) { this.hoTen = HoTen; }
    public float getDiemLT() { return diemLT; }
    public void setDiemLT(float LT) { this.diemLT = LT; }
    public float getDiemTH() { return this.diemTH; }
    public void setDiemTH(float TH) { this.diemTH = TH; }
    
    public void scanIn(Scanner sc)
    {
        System.out.print("Nhập mã sinh vien: ");
        setMSSV(Integer.parseInt(sc.nextLine()));
        
        System.out.print("Nhập họ tên sinh vien: ");
        setHoTen(sc.nextLine());
        
        System.out.print("Nhập điểm lý thuyết: ");
        setDiemLT(Float.parseFloat(sc.nextLine()));
        
        System.out.print("Nhập điểm thực hành: ");
        setDiemTH(Float.parseFloat(sc.nextLine()));
    }
    
    public float calcAvg() { return (diemLT + diemTH) / 2; }
    
    @Override
    public String toString()
    {
        return String.format("%-10d %-20s %-10.2f %-10.2f %-10.2f", maSinhVien, hoTen, diemLT, diemTH, calcAvg());
    }
}
