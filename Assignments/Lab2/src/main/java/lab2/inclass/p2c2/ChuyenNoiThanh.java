package lab2.inclass.p2c2;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class ChuyenNoiThanh extends ChuyenXe {
    private double quangDuongDi;
    
    public ChuyenNoiThanh(String maChuyen, String hoTenTaiXe, String soXe, double khoiLuongHangHoa, double quangDuongDi, double doanhThu) {
        super(maChuyen, hoTenTaiXe, soXe, khoiLuongHangHoa, doanhThu);
        this.quangDuongDi = quangDuongDi;
    }
    
    @Override
    public void display() {
        System.out.println("Chuyến nội thành: " + maChuyen + "\nTài xế: " + hoTenTaiXe +
                           "\nSố xe: " + soXe + "\nKhối lượng: " + khoiLuongHangHoa +
                           "\nQuãng đường: " + quangDuongDi + "\nDoanh thu: " + doanhThu);
    }
}
