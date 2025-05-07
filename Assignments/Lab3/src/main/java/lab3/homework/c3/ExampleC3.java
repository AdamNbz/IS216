package lab3.homework.c3;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class ExampleC3 {
    public static String randomEmployee(List<String> employees) 
    {
        Random rand = new Random();
        return employees.get(rand.nextInt(employees.size()));
    }
    
    public static String mostPopularName(List<String> names) 
    {
        Map<String, Integer> countMap = new HashMap<>();
        for (String name : names)
            countMap.put(name, countMap.getOrDefault(name, 0) + 1);
        
        String mostPopular = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) 
        {
            if (entry.getValue() > maxCount) 
            {
                mostPopular = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostPopular;
    }
    
    public static void registerTour(List<String> registrations, String employeeName) 
    {
        if (registrations.size() < 20) 
            registrations.add(employeeName);
        else
            System.out.println("Đã đủ số lượng đăng ký tour, " + employeeName + " không được đăng ký.");
    }
    
    public static void sortSalesDescending(List<CustomerSale> sales) {
        Collections.sort(sales, new Comparator<CustomerSale>() 
        {
            @Override
            public int compare(CustomerSale s1, CustomerSale s2) 
            {
                return Double.compare(s2.getSaleAmount(), s1.getSaleAmount());
            }
        });
    }
    
    public static void main(String[] args)
    {
        // Yêu cầu 1
        List<String> empList = Arrays.asList("Alice", "Bob", "Charlie", "David", "Emma");
        System.out.println("Nhân viên được chọn ngẫu nhiên: " + randomEmployee(empList));
        
        System.out.println();
        // Yêu cầu 2
        Set<String> prodNames = new HashSet<>(empList);
        System.out.println("Danh sách tên các sản phẩm (không trùng nhau): " + prodNames);
        
        System.out.println();
        // Yêu cầu 3
        List<String> names = Arrays.asList("Alice", "Bob", "Alice", "David", "Bob", "Alice");
        System.out.println("Tên phổ biến nhất: " + mostPopularName(names));
        
        System.out.println();
        // Yêu cầu 4
        List<String> tourRegistration = new ArrayList<>();
        for (int i=1; i<=25; i++) registerTour(tourRegistration, "Employee #" + i);
        
        System.out.println();
        // Yêu cầu 5
        List<CustomerSale> sales = new ArrayList<>();
        sales.add(new CustomerSale("Nguyễn Võ Ngọc Bảo", 500));
        sales.add(new CustomerSale("Nguyễn Lan Hương", 1200));
        sales.add(new CustomerSale("Huỳnh Thanh Sang", 800));
        sortSalesDescending(sales);
        System.out.println("Danh sách doanh số khách hàng giảm dần:");
        for (CustomerSale cs : sales) 
            System.out.println(cs);
    }
}
