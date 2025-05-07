package lab2.inclass.p1c4;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class Xe {
    private String tenChuXe, loaiXe;
    private double triGiaXe, dungTichXiLanh;
    
    public Xe() { this.tenChuXe = new String(); this.loaiXe = new String(); this.triGiaXe = 0; this.dungTichXiLanh = 0; }
    public Xe(String tenChuXe, String loaiXe, double triGia, double dungTich)
    {
        this.tenChuXe = tenChuXe;
        this.loaiXe = loaiXe;
        this.triGiaXe = triGia;
        this.dungTichXiLanh = dungTich;
    }
    
    public String getTenChuXe() { return tenChuXe; }
    public String getLoaiXe() { return loaiXe; }
    public double getTriGiaXe() { return triGiaXe; }
    public double getDungTichXe() { return dungTichXiLanh; }
    public void setTenChuXe(String Owner) { this.tenChuXe = Owner; }
    public void setLoaiXe(String Type) { this.loaiXe = Type; }
    public void setTriGiaXe(double Cost) { this.triGiaXe = Cost; }
    public void setDungTichXe(double Amount) { this.dungTichXiLanh = Amount; }
    
    public Xe scanIn(Scanner sc)
    {
        System.out.print("Nhập tên chủ xe (để rỗng để dừng): ");
        String Owner = sc.nextLine();
        if(Owner.isEmpty()) return new Xe();

        System.out.print("Nhập loại xe: ");
        String Type = sc.nextLine();

        System.out.print("Nhập trị giá xe: ");
        double Cost = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập dung tích xylanh: ");
        double Amount = Double.parseDouble(sc.nextLine());
        
        return new Xe(Owner, Type, Cost, Amount);
    }
    
    public double calcThue()
    {
        if (dungTichXiLanh < 100) return triGiaXe * 0.01;
        if (dungTichXiLanh >= 100 && dungTichXiLanh <= 175) return triGiaXe * 0.03;
        return triGiaXe * 0.05;
    }
    
    @Override
    public String toString()
    {
        return "Chủ xe = " + tenChuXe + "\nLoại xe = " + loaiXe 
                + "\nTrị giá = " + triGiaXe + "\nDung tích = " + dungTichXiLanh + 
                "\nThuế phải đóng = " + calcThue() + "\n";
    }
}
