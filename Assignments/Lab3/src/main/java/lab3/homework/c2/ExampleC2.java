package lab3.homework.c2;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class ExampleC2 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        HashMap<String, String> danhBaDT = new HashMap<>();
        danhBaDT.put("0329501759", "TP. Hồ Chí Minh");
        danhBaDT.put("0903121705", "Tây Ninh");
        danhBaDT.put("0938778447", "Bến Tre");
        OUTER:
        while (true) {
            System.out.println("Chọn chức năng tra cứu:");
            System.out.println("1. Tra cứu theo số điện thoại");
            System.out.println("2. Tra cứu theo địa chỉ đăng ký");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int selection = Integer.parseInt(sc.nextLine());
            
            switch (selection) 
            {
                case 1:
                    System.out.print("Nhập số điện thoại cần tra cứu: ");
                    String phone = sc.nextLine();
                    
                    if (danhBaDT.containsKey(phone))
                        System.out.println("Địa chỉ đăng ký: " + danhBaDT.get(phone));
                    else
                        System.out.println("Số điện thoại không tồn tại trong danh bạ.");
                    
                    break;
                case 2:
                    System.out.print("Nhập địa chỉ đăng ký cần tra cứu: ");
                    String address = sc.nextLine();
                    List<String> phones = new ArrayList<>();
                    
                    for (Map.Entry<String, String> entry : danhBaDT.entrySet())
                        if (entry.getValue().equalsIgnoreCase(address))
                            phones.add(entry.getKey());
                    
                    if (phones.isEmpty())
                        System.out.println("Không có số điện thoại nào đăng ký địa chỉ: " + address);
                    else
                    {
                        System.out.println("Các số điện thoại tại địa chỉ " + address + ":");
                        for (String p : phones) System.out.println(p);
                    }   
                    
                    break;
                case 0:
                    System.out.println("Đang thoát CT...");
                    break OUTER;
                default:
                    System.out.println("Chức năng không hợp lệ.");
                    break;
            }
        }
    }
}
