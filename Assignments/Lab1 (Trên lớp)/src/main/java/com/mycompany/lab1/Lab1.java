/*
    author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
    date  : 7/3/2025  
*/
package com.mycompany.lab1; 
import java.util.*;

class PHANSO {
    private int tu, mau;
    
    public PHANSO(int num, int den)
    {
        this.tu = num;
        if (den == 0) throw new ArithmeticException("Mẫu số phải khác 0!");
        this.mau = den;
        RutGon();
    }
    
    public int getTu()
    {
        return tu;
    }
    
    public int getMau()
    {
        return mau;
    }
    
    private int gcd(int a, int b)
    {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
    
    private void RutGon()
    {
        int ucln = gcd(Math.abs(tu), Math.abs(mau));
        tu /= ucln; mau /= ucln;
        
        if (mau < 0) 
        {
            tu = -tu;
            mau = -mau;
        }
    }
    
    public PHANSO Cong(PHANSO other)
    {
        return new PHANSO(this.tu*other.mau + other.tu*this.mau, this.mau*other.mau);
    }
    
    public PHANSO Tru(PHANSO other)
    {
        return new PHANSO(this.tu*other.mau - other.tu*this.mau, this.mau*other.mau);
    }
    
    public PHANSO Nhan(PHANSO other)
    {
        return new PHANSO(this.tu*other.tu, this.mau*other.mau);
    }
    
    public PHANSO Chia(PHANSO other)
    {
        if (this.mau*other.tu == 0) throw new ArithmeticException("Không thể chia cho phân số có tử = 0!");
        return new PHANSO(this.tu*other.mau, this.mau*other.tu);
    }
    
    @Override
    public String toString()
    {
        return tu + "/" + mau;
    }
}

public class Lab1 {
    //Bài 1
    private static int r;
    
    public static void Bai1()
    {
        System.out.print("Nhập vào bán kính đường tròn: ");
        do
        {
            Scanner scnIn = new Scanner(System.in);
            r = scnIn.nextInt();
            if (r < 0) System.out.print("Nhập lại bán kính đường tròn: ");
        } while (r < 0);
        
        System.out.print("Chu vi của đường tròn với bán kính r = " + r + " là ");
        System.out.printf("%f", 2*r*Math.PI);
    }
    
    //Bài 2
    private static float a, b;
    
    public static void Bai2()
    {
        System.out.print("Nhập giá trị của a: ");
        Scanner scnIn = new Scanner(System.in);
        a = scnIn.nextFloat();
        
        System.out.print("Nhập giá trị của b: ");
        do
        {
            b = scnIn.nextFloat();
            if (b == 0) System.out.print("Nhập lại giá trị của b: ");
        } while (b == 0);
        
        System.out.print("Giá trị của a/b là ");
        System.out.printf("%.3f", a/b);
    }
    
    //Bài 3
    private static PHANSO ps1, ps2;
    
    public static PHANSO InputPS()
    {
        Scanner scnIn = new Scanner(System.in);
        System.out.print("Nhập tử số: ");
        int inputTu = scnIn.nextInt();
        System.out.print("Nhập mẫu số: ");
        int inputMau = scnIn.nextInt();
        return new PHANSO(inputTu, inputMau);
    }
    
    public static void Bai3()
    {
        System.out.println("Nhập phân số thứ 1: ");
        ps1 = InputPS();
        System.out.println("Nhập phân số thứ 2: ");
        ps2 = InputPS();
        
        System.out.println("Tổng của 2 phân số này là " + ps1.Cong(ps2).toString());
        System.out.println("Hiệu của 2 phân số này là " + ps1.Tru(ps2).toString());
        System.out.println("Tích của 2 phân số này là " + ps1.Nhan(ps2).toString());
        System.out.print("Thương của 2 phân số này là " + ps1.Chia(ps2).toString());
    }
    
    //Bài 4
    private static String x, y;
    
    public static void Bai4()
    {
        Scanner scnIn = new Scanner(System.in);
        System.out.print("Nhập chuỗi x: ");
        x = scnIn.nextLine();
        System.out.print("Nhập chuỗi y: ");
        y = scnIn.nextLine();
        
        System.out.println("Tổng chiều dài của chuỗi x là " + x.length());
        
        System.out.println("3 ký tự đầu tiên của chuỗi x là " + x.substring(0, 3));
        
        System.out.println("3 ký tự cuối của chuỗi x là " + x.substring(Math.max(0, x.length()-3)));
        
        System.out.print("Ký tự thứ 6 của chuỗi x là ");
        if (x.length() >= 6) System.out.println(x.charAt(5));
        else System.out.println("null vì độ dài của chuỗi x bé hơn 6!");
        
        String combineXY = x.substring(0, 3) + y.substring(Math.max(0, y.length()-3));
        System.out.println("Chuỗi mới sau khi ghép là " + combineXY);
        
        System.out.println("2 chuỗi x và y " + (x.equals(y) ? "có" : "không") + " bằng nhau (phân biệt)");
        
        System.out.println("2 chuỗi x và y " + (x.equalsIgnoreCase(y) ? "có" : "không") + " bằng nhau (không phân biệt)");
        
        if (!x.contains(y)) System.out.print("Chuỗi y không nằm trong x");
        else System.out.print("Chuỗi y nằm tại vị trí thứ " + x.indexOf(y) + " trong x");
    }
    
    //Bài 5
    private static float electricity;
    
    public static float TinhTienDien()
    {
        if (electricity <= 50) return electricity*2000;
        else if (electricity > 50 && electricity <= 100) return (50*2000) + ((electricity-50)*2500);
        else return (50*2000) + ((electricity-50)*3500);
    }
    
    public static void Bai5()
    {
        Scanner scnIn = new Scanner(System.in);
        System.out.print("Nhập số điện đã sử dụng trong tháng: ");
        electricity = scnIn.nextFloat();
        
        System.out.print("Tổng tiền điện cần thanh toán là " + TinhTienDien());
    }
    
    //Bài 6 (Menu trong hàm main)
    
    //Bài 7
    private static int n;
    
    public static boolean isPrime(int n)
    {
        for (int i=2; i*i<=n; i++)
            if (n%i==0) return false;
        return n>=2;
    }
    
    public static void Bai7()
    {
        Scanner scnIn = new Scanner(System.in);
        System.out.print("Nhập số n: ");
        n = scnIn.nextInt();
        
        if (isPrime(n)) System.out.print("Đây là số nguyên tố");
        else System.out.print("Đây không phải là số nguyên tố");
    }
    
    //Bài 8
    private static int m;
    
    public static void Bai8()
    {
        Scanner scnIn = new Scanner(System.in);
        System.out.print("nhập kích thuốc bảng Pytagoras: ");
        m = scnIn.nextInt();
        
        for (int i=1; i<=m; i++)
        {
            for (int j=1; j<=m; j++) System.out.print(i*j + "\t");
            if (i < m) System.out.println();
        }
    }
    
    //Bài 9
    private static int N;
    
    public static void Bai9()
    {
        Scanner scnIn = new Scanner(System.in);
        System.out.print("Nhập số N: ");
        N = scnIn.nextInt();
        int[] A = new int[N];
        for (int i=0; i<N; i++)
        {
            System.out.print("Nhập phần tử thứ " + (i+1) + ": ");
            A[i] = scnIn.nextInt();
        }
        
        System.out.println("Các phần tử của mảng A: " + Arrays.toString(A));
        
        int mx = A[0], mn = A[0];
        for (int i=1; i<N; i++) 
        {
            mx = Math.max(mx, A[i]);
            mn = Math.min(mn, A[i]);
        }
        System.out.println("Phần tử lớn nhất và phần tử bé nhất của mảng a lần lượt là " + mx + " và " + mn);
        
        System.out.print("Nhập số X cần tìm: ");
        int X = scnIn.nextInt();
        if (Arrays.binarySearch(A, X) == -1) System.out.println("X không nằm trong mảng A");
        else System.out.println("X nằm trong mảng A");
        
        int cnt = 0;
        for (int i=0; i<N; i++) if (A[i] == X) cnt++;
        System.out.println("Có " + cnt + " phần tử X trong mảng A");
        
        Arrays.sort(A);
        System.out.print("Các phần tử của mảng a sau khi sắp xếp tăng dần: " + Arrays.toString(A));
    }
    
    public static void main(String[] args) 
    {
        Scanner scnIn = new Scanner(System.in);
        while (true)
        {
            System.out.println("------------------");
            System.out.println("Menu");
            System.out.println("1. Câu 1");
            System.out.println("2. Câu 2");
            System.out.println("3. Câu 3");
            System.out.println("4. Câu 4");
            System.out.println("5. Câu 5");
            System.out.println("6. Câu 7");
            System.out.println("7. Câu 8");
            System.out.println("8. Câu 9");
            System.out.println("9. Thoát");
            System.out.println("------------------");
            System.out.print("Lựa chọn của bạn: ");
            int option = scnIn.nextInt();
            
            switch (option)
            {
                case 1:
                {
                    Bai1();
                    System.out.println();
                    break;
                }
                case 2:
                {
                    Bai2();
                    System.out.println();
                    break;
                }
                case 3:
                {
                    Bai3();
                    System.out.println();
                    break;
                }
                case 4:
                {
                    Bai4();
                    System.out.println();
                    break;
                }
                case 5:
                {
                    Bai5();
                    System.out.println();
                    break;
                }
                case 6:
                {
                    Bai7();
                    System.out.println();
                    break;
                }
                case 7:
                {
                    Bai8();
                    System.out.println();
                    break;
                }
                case 8:
                {
                    Bai9();
                    System.out.println();
                    break;
                }
                case 9:
                {
                    System.out.print("Đang kết thúc chương trình...");
                    System.exit(0);
                }
                default:
                {
                    System.out.println("Bạn phải lựa chọn từ 1 đến 9!");
                    break;
                }
            }
        }
    }
}
