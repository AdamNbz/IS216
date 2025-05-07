package lab2.inclass.p1c2;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class HinhChuNhat {
    private int length, width;
    
    public HinhChuNhat() { this.length = 0; this.width = 0; }
    public HinhChuNhat(int cD, int cR) { this.length = cD; this.width = cR; }
    
    public int getChieuDai() { return length; }
    public int getChieuRong() { return width; }
    public void setChieuDai(int cD) { this.length = cD; }
    public void setChieuRong(int cR) { this.width = cR; }
    
    public void scanIn(Scanner sc)
    {
        System.out.print("Nhập chiều dài: ");
        setChieuDai(Integer.parseInt(sc.nextLine()));
        
        System.out.print("Nhập chiều rộng: ");
        setChieuRong(Integer.parseInt(sc.nextLine()));
    }
        
    public int calcDienTich() { return length * width; }
    public int calcChuVi() { return 2 * (length + width); }
    
    @Override
    public String toString()
    {
        return "Chiều đài: " + length + "\nChiều rộng: " + width + "\nDiện tích: " + calcDienTich() + "\nChu vi: " + calcChuVi();
    }
}
