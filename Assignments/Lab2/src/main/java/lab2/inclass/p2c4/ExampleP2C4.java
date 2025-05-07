package lab2.inclass.p2c4;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class ExampleP2C4 {
    public static void main(String[] args) 
    {
        XeMay xeMay = new XeMay();
        XeTai xeTai = new XeTai();
        
        xeMay.doXang(10);
        xeTai.doXang(100);
        
        xeMay.themHang(20);
        xeTai.themHang(500);
        
        xeMay.chay(100);
        xeTai.chay(100);
        
        System.out.println("Lượng xăng còn lại của xe máy: " + xeMay.layXangConLai() + " lít");
        System.out.println("Lượng xăng còn lại của xe tải: " + xeTai.layXangConLai() + " lít");
    }
}
