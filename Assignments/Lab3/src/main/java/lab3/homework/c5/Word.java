package lab3.homework.c5;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class Word {
    private String tuTiengAnh;
    private String nghia;
    private String loaiTu;
    private String ghiChu;
    
    public Word(String tuTiengAnh, String nghia, String loaiTu, String ghiChu) 
    {
        this.tuTiengAnh = tuTiengAnh;
        this.nghia = nghia;
        this.loaiTu = loaiTu;
        this.ghiChu = ghiChu;
    }
    
    public String getTuTiengAnh() { return tuTiengAnh; }
    public String getNghia() { return nghia; }
    public String getLoaiTu() { return loaiTu; }
    
    public String getGhiChu() { return ghiChu; }
    
    @Override
    public String toString() 
    {
        return "Từ: " + tuTiengAnh + "\n- Nghĩa: " + nghia + "\n- Loại: " + loaiTu + "\n- Ghi chú: " + ghiChu;
    }
}
