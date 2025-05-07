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

public class b6 {
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    public static void SortColumnAsc(int[][] A, int n, int m) {
        for (int j = 0; j < m; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = A[i][j];
            }
            Arrays.sort(column);
            for (int i = 0; i < n; i++) {
                A[i][j] = column[i];
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Note for dummies: Ma tran A[n x m]  
        System.out.print("Nhap so dong ma tran: ");
        int n = scanner.nextInt();
        System.out.print("Nhap so cot ma tran: ");
        int m = scanner.nextInt();
        int[][] A = new int[n][m];
        System.out.print("Nhap cac phan tu cua ma tran: ");
        
        // Vua nhap phan tu trong mang vua tim phan tu lon nhat ;w;
        int maxVal = Integer.MIN_VALUE;
        int maxRow = -1, maxCol = -1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = scanner.nextInt();
                if (A[i][j] > maxVal) {
                    maxVal = A[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                A[i][j] = scanner.nextInt();
//            }
//        }
//        
//        int maxVal = A[0][0];
//        int maxRow = -1, maxCol = -1;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (A[i][j] > maxVal) {
//                    maxVal = A[i][j];
//                    maxRow = i;
//                    maxCol = j;
//                }
//            }
//        }
        
        System.out.println("Phan tu lon nhat: " + maxVal + " tai vi tri (" + maxRow + ", " + maxCol + ")");
        
        System.out.println("Ma tran voi cac so khong phai so nguyen to duoc thay bang 0:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isPrime(A[i][j])) {
                    A[i][j] = 0;
                }
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println("Ma tran sau khi sap xep cac cot theo thu tu tang dan:");
        SortColumnAsc(A, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
