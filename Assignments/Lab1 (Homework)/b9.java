/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w1;

/*
    author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
    date  : .../3/2025
*/

import java.io.*;

public class b9 {
    public static boolean isPalindrome(String str) {
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // Loai bo dau cau, khoang trang, chuyen thanh chu thuong
        String reversed = new StringBuilder(cleaned).reverse().toString(); // Dao nguoc chuoi
        return cleaned.equals(reversed); 
    }
    public static void main(String[] args) {
        String inputFile = "input.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isPalindrome(line)) {
                    System.out.println("\"" + line + "\" la palindrome.");
                } else {
                    System.out.println("\"" + line + "\" khong la palindrome.");
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
