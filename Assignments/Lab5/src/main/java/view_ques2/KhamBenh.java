package view_ques2;

import java.util.Date;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class KhamBenh {
    private String MaBN, TenBN, YCau, BSi;
    private Date NgKham;
    
    public KhamBenh() {
        
    }
    
    public KhamBenh(String MaBN, String TenBN, String YCau, String BSi, Date NgKham) {
        this.MaBN = MaBN;
        this.TenBN = TenBN;
        this.YCau = YCau;
        this.BSi = BSi;
        this.NgKham = NgKham;
    }
    
    public Object getInfo(int index) {
        Object[] obj = new Object[4];
        obj[0] = this.MaBN;
        obj[1] = this.BSi;
        obj[2] = this.NgKham;
        obj[3] = this.YCau;
        return obj[index - 1];
    }
}
