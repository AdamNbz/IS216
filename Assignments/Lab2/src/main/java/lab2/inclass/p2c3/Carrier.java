package lab2.inclass.p2c3;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class Carrier extends Robot {
    private int E;
    
    public Carrier() 
    {
        this.M = 30;
        this.E = new Random().nextInt(51) + 50;
    }
    
    @Override
    public double tinhTieuThu() { return M * S + 4 * E * S; }
    
    @Override
    public void display() 
    {
        System.out.println("Carrier:\nTrọng lượng = " + M + "\nKho năng lượng = " + E + "\nTiêu thụ = " + tinhTieuThu());
    }
}
