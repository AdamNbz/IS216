/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1;

/*
    author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
    date  : .../3/2025
*/


import java.util.Scanner;

public class b3 {
    public static int ucln(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap tu: ");
        int tu = scanner.nextInt();
        System.out.print("Nhap mau: ");
        int mau = scanner.nextInt();
        
        if (mau == 0) {
            System.out.println("Loi");
        }
        else {
            int newtu = tu / ucln(tu,mau);
            int newmau = mau / ucln(tu,mau);
            System.out.println("Phan so sau khi don gian: " + newtu + "/" + newmau);
        }
    }
}
