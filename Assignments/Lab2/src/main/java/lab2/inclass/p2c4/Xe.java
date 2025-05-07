package lab2.inclass.p2c4;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public abstract class Xe {
    protected double hang;
    protected double xang;
    
    public Xe() {
        this.hang = 0;
        this.xang = 0;
    }
    
    public void doXang(double soLit) 
    {
        this.xang += soLit;
    }
    
    public void themHang(double khoiLuong) 
    {
        this.hang += khoiLuong;
    }
    
    public void botHang(double khoiLuong) 
    {
        if(khoiLuong > hang) hang = 0;
        else hang -= khoiLuong;
    }
    
    public boolean kiemTraHetXang() 
    {
        return xang <= 0;
    }
    
    public double layXangConLai() 
    {
        return xang;
    }
    
    public abstract void chay(double quangDuong);
}
