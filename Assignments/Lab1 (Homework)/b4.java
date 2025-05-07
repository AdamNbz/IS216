/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1;

/*
    author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
    date  : .../3/2025
*/


import java.util. Scanner;

public class b4 {
    public static boolean isPerfectNum(int n) {
        if (n <= 0) return false;
        int s = 0;
        for (int i = 0; i <= n/2; i++) {
            if (n % i == 0) s += i;
        }
        return s == n;
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap so tu nhien: ");
        int n = scanner.nextInt();
        
        if (isPerfectNum(n)){
            System.out.println(n + " la so hoan hao");
        }
        else {
            System.out.println(n + " khong la so hoan hao");
        }
    }
}
