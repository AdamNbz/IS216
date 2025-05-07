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

public class b1 {
    public static int ucln(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static int bcnn(int a, int b) {
        return (a * b) / ucln(a, b);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap so nguyen thu nhat: ");
        int n1 = scanner.nextInt();
        System.out.print("Nhap so nguyen thu hai: ");
        int n2 = scanner.nextInt();
        
        System.out.println("\nƯCLN cua " + n1 + " va " + n2 + " la " + ucln(n1, n2));
        System.out.println("BCNN cua " + n1 + " va " + n2 + " la " + bcnn(n1, n2));
    }
}
