package lab2.inclass.p2c2;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class ChuyenNgoaiThanh extends ChuyenXe {
    private String noiDen;
    private int soNgayVanChuyen;
    
    public ChuyenNgoaiThanh(String maChuyen, String hoTenTaiXe, String soXe, double khoiLuongHangHoa, String noiDen, int soNgayVanChuyen, double doanhThu) {
        super(maChuyen, hoTenTaiXe, soXe, khoiLuongHangHoa, doanhThu);
        this.noiDen = noiDen;
        this.soNgayVanChuyen = soNgayVanChuyen;
    }
    
    @Override
    public void display() {
        System.out.println("Chuyến ngoại thành: " + maChuyen + "\nTài xế: " + hoTenTaiXe +
                           "\nSố xe: " + soXe + "\nKhối lượng: " + khoiLuongHangHoa +
                           "\nNơi đến: " + noiDen + "\nSố ngày: " + soNgayVanChuyen +
                           "\nDoanh thu: " + doanhThu);
    }
}
