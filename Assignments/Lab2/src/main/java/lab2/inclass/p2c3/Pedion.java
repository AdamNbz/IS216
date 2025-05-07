package lab2.inclass.p2c3;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class Pedion extends Robot {
    private int F;
    
    public Pedion() 
    {
        this.M = 20;
        this.F = new Random().nextInt(5) + 1;
    }
    
    @Override
    public double tinhTieuThu() { return M * S + (F + 1) * S / 2; }
    
    @Override
    public void display() 
    {
        System.out.println("Pedion:\nTrọng lượng = " + M + "\nĐộ linh hoạt = " + F + "\nTiêu thụ = " + tinhTieuThu());
    }
}
