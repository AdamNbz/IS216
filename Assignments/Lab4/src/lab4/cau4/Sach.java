package lab4.cau4;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class Sach {
    private final String maSach;
    private String tenSach, tacGia, nhaXuatBan;
    private double gia;
    
    public Sach(String maSach, String tenSach, String tacGia, String NXB, double price)
    {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.nhaXuatBan = NXB;
        this.gia = price;
    }
    
    public String getMaSach() { return maSach; }
    public String getTenSach() { return tenSach; }
    public void setTenSach(String t) { tenSach = t; }
    public String getTacGia() { return tacGia; }
    public void setTacGia(String t) { tacGia = t; }
    public String getNhaXuatBan() { return nhaXuatBan; }
    public void setNhaXuatBan(String n) { nhaXuatBan = n; }
    public double getGia() { return gia; }
    public void setGia(double g) { gia = g; }
    
    @Override
    public String toString() {
        return maSach + " | " + tenSach + " | " + tacGia + " | " + nhaXuatBan + " | " + gia;
    }
}
