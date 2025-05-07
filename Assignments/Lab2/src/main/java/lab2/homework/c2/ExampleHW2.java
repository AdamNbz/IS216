package lab2.homework.c2;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class ExampleHW2 {
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<HangHoa> dsHangHoa = new ArrayList<>();
        
        while(true) 
        {
            System.out.print("Nhập loại hàng (1. Điện máy, 2. Thực phẩm, 3. Gia dụng): ");
            String loai = sc.nextLine();
            if (loai.isEmpty()) break;
            
            System.out.print("Nhập mã hàng: ");
            String maHang = sc.nextLine();
            if (maHang.isEmpty()) break;
            
            boolean duplicate = false;
            for(HangHoa hh : dsHangHoa) 
            {
                if (hh.getMaHang().equals(maHang)) 
                {
                    duplicate = true;
                    System.out.println("Mã hàng đã tồn tại, không thêm!");
                    break;
                }
            }
            if (duplicate) continue;
            
            System.out.print("Nhập tên hàng: ");
            String tenHang = sc.nextLine();
            System.out.print("Nhập số lượng tồn: ");
            int soLuongTon = Integer.parseInt(sc.nextLine());
            System.out.print("Nhập đơn giá: ");
            double donGia = Double.parseDouble(sc.nextLine());
            
            switch (loai) {
                case "1" -> {
                    System.out.print("Nhập thương hiệu: ");
                    String thuongHieu = sc.nextLine();
                    System.out.print("Nhập loại máy: ");
                    String loaiMay = sc.nextLine();
                    System.out.print("Nhập thời gian bảo hành (tháng): ");
                    int baoHanh = Integer.parseInt(sc.nextLine());
                    dsHangHoa.add(new HangDienMay(maHang, tenHang, soLuongTon, donGia, thuongHieu, loaiMay, baoHanh));
                }
                case "2" -> {
                    System.out.print("Nhập ngày sản xuất (dd/MM/yyyy): ");
                    String ngaySX = sc.nextLine();
                    System.out.print("Nhập ngày hết hạn (dd/MM/yyyy): ");
                    String ngayHH = sc.nextLine();
                    System.out.print("Nhập nhà cung cấp: ");
                    String nhaCC = sc.nextLine();
                    dsHangHoa.add(new HangThucPham(maHang, tenHang, soLuongTon, donGia, ngaySX, ngayHH, nhaCC));
                }
                case "3" -> {
                    System.out.print("Nhập nhà sản xuất: ");
                    String nhaSX = sc.nextLine();
                    System.out.print("Nhập ngày nhập (dd/MM/yyyy): ");
                    String ngayNhap = sc.nextLine();
                    System.out.print("Nhập loại hàng: ");
                    String loaiHang = sc.nextLine();
                    dsHangHoa.add(new HangGiaDung(maHang, tenHang, soLuongTon, donGia, nhaSX, ngayNhap, loaiHang));
                }
                default -> {
                    System.out.println("Loại hàng không hợp lệ.");
                    continue;
                }
            }
            
            System.out.println("Đã thêm hàng hóa vào danh sách.\n");
        }
        
        System.out.println("Bảng đánh giá hàng hóa:");
        for(HangHoa hh : dsHangHoa) System.out.println(hh);
        
        System.out.println("\nCác thương hiệu hàng điện máy bán được (số lượng tồn < 3):");
        for(HangHoa hh : dsHangHoa) 
        {
            if (hh instanceof HangDienMay) 
            {
                HangDienMay dm = (HangDienMay) hh;
                if (dm.getSoLuongTon() < 3) 
                    System.out.printf("Thương hiệu: %s\nTên hàng: %s\nLoại máy: %s\n", dm.getThuongHieu(), dm.getTenHang(), dm.getLoaiMay());
            }
        }
    }
}
