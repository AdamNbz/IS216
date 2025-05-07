package lab2.inclass.p2c2;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public abstract class ChuyenXe {
    protected String maChuyen;
    protected String hoTenTaiXe;
    protected String soXe;
    protected double khoiLuongHangHoa;
    protected double doanhThu;
    
    public ChuyenXe() {}
    
    public ChuyenXe(String maChuyen, String hoTenTaiXe, String soXe, double khoiLuongHangHoa, double doanhThu) {
        this.maChuyen = maChuyen;
        this.hoTenTaiXe = hoTenTaiXe;
        this.soXe = soXe;
        this.khoiLuongHangHoa = khoiLuongHangHoa;
        this.doanhThu = doanhThu;
    }
    
    public abstract void display();
    
    public double getDoanhThu() {
        return doanhThu;
    }
}
