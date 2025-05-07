package lab2.inclass.p2c4;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class XeMay extends Xe {
    @Override
    public void chay(double quangDuong) 
    {
        double consumptionPer100 = 2 + (hang / 10) * 0.1;
        double consumption = consumptionPer100 * (quangDuong / 100.0);
        
        if(consumption > xang) 
            System.out.println("Xe máy không đủ xăng để chạy " + quangDuong + " km.");
        else 
        {
            xang -= consumption;
            System.out.println("Xe máy đã chạy " + quangDuong + " km, tiêu thụ " + consumption + " lít xăng.");
        }
    }
}
