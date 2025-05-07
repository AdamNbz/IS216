package lab3.homework.c3;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class CustomerSale {
    private String customerName;
    private double saleAmount;
    
    public CustomerSale(String customerName, double saleAmount)
    {
        this.customerName = customerName;
        this.saleAmount = saleAmount;
    }
    
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public double getSaleAmount() { return saleAmount; }
    public void setSaleAmount(double saleAmount) { this.saleAmount = saleAmount; }
    
    @Override
    public String toString()
    {
        return "- Tên khách hàng: " + customerName + "\n- Doanh số mua hàng: " + saleAmount;
    }
}
