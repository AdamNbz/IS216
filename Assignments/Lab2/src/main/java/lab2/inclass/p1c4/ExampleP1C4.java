package lab2.inclass.p1c4;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class ExampleP1C4 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Xe> danhSachXe = new ArrayList<>();
        
        while (true)
        {
            Xe inp = new Xe().scanIn(sc);
            
            if (inp.getTenChuXe().isEmpty()) break;
            danhSachXe.add(new Xe(inp.getTenChuXe(), inp.getLoaiXe(), inp.getTriGiaXe(), inp.getDungTichXe()));
        }
        
        int idx = 1;
        System.out.println("Bảng sao kê thuế của các xe: ");
        for (Xe x: danhSachXe)
        {
            System.out.print("Xe thứ " + idx++ + ":\n " + x);
        }
        
        System.out.print("Nhập tên chủ xe cần tìm: ");
        String timTen = sc.nextLine();
        System.out.print("Nhập loại xe cần tìm: ");
        String timLoai = sc.nextLine();
        ArrayList<Xe> timXe = new ArrayList<>();
        for(Xe x : danhSachXe) {
            if(x.getTenChuXe().contains(timTen) && x.getLoaiXe().contains(timLoai))
                timXe.add(x);
        }
        
        if (timXe.isEmpty()) 
            System.out.print("Không tìm thấy xe nào có chủ xe và loại xe đã nhập!");
        else
        {
            System.out.println("Đã tìm thấy!:\nDanh sách xe đã tìm thấy:");
            for (Xe x: timXe)
                System.out.print(x);
            timXe.clear();
        }
    }
}
