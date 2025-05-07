package lab3.homework.c1;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class SinhVien {
    private long maSV;
    private String tenSV;
    private double diem;
    
    public SinhVien(long maSV_, String tenSV_, double diem_)
    {
        this.maSV = maSV_;
        this.tenSV = tenSV_;
        this.diem = diem_;
    }
    
    public long getMaSV() { return maSV; }
    public void setMaSV(long maSV) { this.maSV = maSV; }
    public String getTenSV() { return tenSV; }
    public void setTenSV(String tenSV) { this.tenSV = tenSV; }
    public double getDiem() { return diem; }
    public void setDiem(double diem) { this.diem = diem; }
    
    @Override
    public String toString()
    {
        return "- MSSV: " + maSV + "\n- Tên SV: " + tenSV + "\n- nĐiểm: " + diem;
    }
}
