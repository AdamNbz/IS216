package lab2.homework.c1;
import java.util.*;
/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class ExampleHW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<KhachHang> dsKhachHang = new ArrayList<>();
        
        while(true) {
            System.out.print("Nhập loại khách hàng (1. Sinh hoạt, 2. Kinh doanh, 3. Sản xuất): ");
            String loai = sc.nextLine();
            if (loai.isEmpty()) break;
            
            System.out.print("Nhập mã khách hàng: ");
            String maKH = sc.nextLine();
            if (maKH.isEmpty()) break;
            System.out.print("Nhập tên khách hàng: ");
            String tenKH = sc.nextLine();
            System.out.print("Nhập ngày hóa đơn (dd/MM/yyyy): ");
            String ngayHD = sc.nextLine();
            System.out.print("Nhập số lượng điện: ");
            double soLuong = Double.parseDouble(sc.nextLine());
            System.out.print("Nhập đơn giá: ");
            double donGia = Double.parseDouble(sc.nextLine());
            
            switch (loai) {
                case "1" -> {
                    System.out.print("Nhập định mức: ");
                    double dinhMuc = Double.parseDouble(sc.nextLine());
                    dsKhachHang.add(new KhachHangSinhHoat(maKH, tenKH, ngayHD, soLuong, donGia, dinhMuc));
                }
                case "2" -> dsKhachHang.add(new KhachHangKinhDoanh(maKH, tenKH, ngayHD, soLuong, donGia));
                case "3" -> {
                    System.out.print("Nhập loại điện (2 pha hoặc 3 pha): ");
                    String loaiDien = sc.nextLine();
                    dsKhachHang.add(new KhachHangSanXuat(maKH, tenKH, ngayHD, soLuong, donGia, loaiDien));
                }
                default -> {
                    System.out.println("Loại khách hàng không hợp lệ, vui lòng nhập lại.");
                    continue;
                }
            }
            
            System.out.println("Đã thêm khách hàng vào danh sách.\n");
        }
        
        System.out.println("Danh sách hóa đơn của khách hàng:");
        for(KhachHang kh : dsKhachHang) 
            System.out.println(kh);
        
        System.out.print("Nhập tháng cần xuất hóa đơn: ");
        int thang = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập năm cần xuất hóa đơn: ");
        int nam = Integer.parseInt(sc.nextLine());
        System.out.println("Hóa đơn của khách hàng trong tháng " + thang + "/" + nam + ":");
        for(KhachHang kh : dsKhachHang) 
        {
            if (kh.getMonth() == thang && kh.getYear() == nam) 
            {
                System.out.printf("Mã KH: %s\nTên KH: %s\nSố điện: %.2f\nThành tiền: %.2f\n", kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getSoLuongDien(), kh.tinhThanhTien());
            }
        }
    }
}
