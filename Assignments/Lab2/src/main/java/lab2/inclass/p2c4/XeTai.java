package lab2.inclass.p2c4;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class XeTai extends Xe {
    @Override
    public void chay(double quangDuong) 
    {
        double consumptionPer100 = 20 + (hang / 100) * 1;
        double consumption = consumptionPer100 * (quangDuong / 100.0);
        
        if(consumption > xang) 
            System.out.println("Xe tải không đủ xăng để chạy " + quangDuong + " km.");
        else 
        {
            xang -= consumption;
            System.out.println("Xe tải đã chạy " + quangDuong + " km, tiêu thụ " + consumption + " lít xăng.");
        }
    }
}
