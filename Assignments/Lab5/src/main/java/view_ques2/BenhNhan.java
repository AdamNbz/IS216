package view_ques2;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class BenhNhan {
    private String MaBN, TenBN, NgSinh, DChi, DThoai, GTinh;
    
    public BenhNhan() {
        
    }
    
    public BenhNhan(
        String MaBN, 
        String TenBN, 
        String NgSinh, 
        String DChi, 
        String DThoai, 
        String GTinh
    ) {
        this.MaBN = MaBN;
        this.TenBN = TenBN;
        this.NgSinh = NgSinh;
        this.DChi = DChi;
        this.DThoai = DThoai;
        this.GTinh = GTinh;
    }
    
    public void print() {
        System.out.println(this.MaBN);
        System.out.println(this.TenBN);
        System.out.println(this.NgSinh);
        System.out.println(this.DChi);
        System.out.println(this.DThoai);
        System.out.println(this.GTinh);
    }
    
    public String getInfo(int index) {
        String[] s = new String[6];
        s[0] = this.MaBN;
        s[1] = this.TenBN;
        s[2] = this.NgSinh;
        s[3] = this.DChi;
        s[4] = this.DThoai;
        s[5] = this.GTinh;
        return s[index - 1];
    }
}
