/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1;

/*
    author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
    date  : .../3/2025
*/


import java.util.Arrays;
import java.util.Scanner;

public class b5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap kich thuoc mang A: ");
        int n = scanner.nextInt();
        int[] A = new int[n];
        System.out.println("Nhap cac phan tu cua mang A: ");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        
        // Tao mang B voi kich thuoc m
        System.out.print("Nhap kich thuoc mang B: ");
        int m = scanner.nextInt();
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = (int) (Math.random() * 100); //Random 1-99 since idk ;w;
        }
        
        // Xuat mang B
        System.out.println("Mang B: B[" + m + "] = " + Arrays.toString(B));
        
        // Tao mang C tu mang A (copy A -> C )
        int[] C = Arrays.copyOf(A, n);
        System.out.println("Mang C (copy A -> C): " + Arrays.toString(C));
        
        // Thay the thu 1->3 cua C bang 3 phan tu cuoi cua B
        if (m >= 3 && n >= 3) {
            System.arraycopy(B, m - 3, C, 0, 3);
            System.out.println("Mang C sau khi duoc thay the thu 1->3 cua C bang 3 phan tu cuoi cua B: " + Arrays.toString(C));
        }
        
        // Sap xep mang C tang dan
        Arrays.sort(C);
        System.out.println("Mang C sau khi duoc sap xep mang C tang dan: " + Arrays.toString(C));
    }
}
