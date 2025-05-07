package lab2.inclass.p2c2;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class ExampleP2C2 {
    public static void main(String[] args) {
        ArrayList<ChuyenXe> dsChuyen = new ArrayList<>();
        
        dsChuyen.add(new ChuyenNoiThanh("NT001", "Tran Van A", "59A-12345", 500, 100, 2000));
        dsChuyen.add(new ChuyenNoiThanh("NT002", "Le Thi B", "59B-54321", 300, 80, 1500));
        dsChuyen.add(new ChuyenNgoaiThanh("NGT001", "Pham Van C", "59C-67890", 600, "Ha Noi", 3, 2500));
        dsChuyen.add(new ChuyenNgoaiThanh("NGT002", "Do Thi D", "59D-09876", 400, "Da Nang", 2, 1800));
        
        double totalNoiThanh = 0;
        double totalNgoaiThanh = 0;
        ChuyenNoiThanh maxNT = null;
        ChuyenNgoaiThanh maxNGT = null;
        
        for (ChuyenXe x : dsChuyen) {
            x.display();
            if (x instanceof ChuyenNoiThanh) 
            {
                totalNoiThanh += x.getDoanhThu();
                if(maxNT == null || x.getDoanhThu() > maxNT.getDoanhThu())
                    maxNT = (ChuyenNoiThanh) x;
            } 
            else if (x instanceof ChuyenNgoaiThanh) 
            {
                totalNgoaiThanh += x.getDoanhThu();
                if(maxNGT == null || x.getDoanhThu() > maxNGT.getDoanhThu())
                    maxNGT = (ChuyenNgoaiThanh) x;
            }
        }
        
        System.out.println("Tổng doanh thu chuyến nội thành: " + totalNoiThanh);
        System.out.println("Tổng doanh thu chuyến ngoại thành: " + totalNgoaiThanh);
        
        if(maxNT != null) 
        {
            System.out.println("Chuyến nội thành có doanh thu cao nhất:");
            maxNT.display();
        }
        
        if(maxNGT != null) 
        {
            System.out.println("Chuyến ngoại thành có doanh thu cao nhất:");
            maxNGT.display();
        }
    }
}
