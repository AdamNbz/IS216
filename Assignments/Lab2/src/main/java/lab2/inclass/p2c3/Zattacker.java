package lab2.inclass.p2c3;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class Zattacker extends Robot {
    private int P;
    
    public Zattacker() 
    {
        this.M = 50;
        this.P = new Random().nextInt(11) + 20;
    }
    
    @Override
    public double tinhTieuThu() { return M * S + P * P * S; }
    
    @Override
    public void display() 
    {
        System.out.println("Zattacker:\nTrọng lượng = " + M + "\nSức mạnh = " + P + "\nTiêu thụ = " + tinhTieuThu());
    }
}
