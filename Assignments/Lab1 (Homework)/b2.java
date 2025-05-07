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

public class b2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap so nguyen duong n: ");
        int n = scanner.nextInt();
        
        if(n > 0) {
            System.out.print("Cac uoc so cua " + n + " la: ");
            for (int i = 0; i < n; i++) {
                if (n % i == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
        else {
            System.out.println("Vui long nhap so nguyen duong");
        }
    }
}
