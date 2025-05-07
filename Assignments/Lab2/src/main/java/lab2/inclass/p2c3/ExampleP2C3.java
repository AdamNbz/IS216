package lab2.inclass.p2c3;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class ExampleP2C3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng Pedion: ");
        int A = sc.nextInt();
        System.out.print("Nhập số lượng Zattacker: ");
        int B = sc.nextInt();
        System.out.print("Nhập số lượng Carrier: ");
        int C = sc.nextInt();
        
        ArrayList<Robot> danhSachRobot = new ArrayList<>();
        for(int i = 0; i < A; i++) 
            danhSachRobot.add(new Pedion());
        for(int i = 0; i < B; i++) 
            danhSachRobot.add(new Zattacker());
        for(int i = 0; i < C; i++) 
            danhSachRobot.add(new Carrier());
        
        double totalPedion = 0, totalZattacker = 0, totalCarrier = 0;
        for(Robot r : danhSachRobot) 
        {
            r.display();
            if(r instanceof Pedion) totalPedion += r.tinhTieuThu();
            if(r instanceof Zattacker) totalZattacker += r.tinhTieuThu();
            if(r instanceof Carrier) totalCarrier += r.tinhTieuThu();
        }
        
        System.out.println("Tổng tiêu thụ của Pedion: " + totalPedion);
        System.out.println("Tổng tiêu thụ của Zattacker: " + totalZattacker);
        System.out.println("Tổng tiêu thụ của Carrier: " + totalCarrier);
        
        double max = Math.max(totalPedion, Math.max(totalZattacker, totalCarrier));
        if(max == totalPedion)
            System.out.println("Loại robot tiêu thụ nhiều nhất: Pedion");
        else if(max == totalZattacker)
            System.out.println("Loại robot tiêu thụ nhiều nhất: Zattacker");
        else
            System.out.println("Loại robot tiêu thụ nhiều nhất: Carrier");
    }
}
