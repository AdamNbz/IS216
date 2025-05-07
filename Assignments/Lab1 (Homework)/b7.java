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
import java.util.*;

public class b7 {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        
        try (Scanner scanner = new Scanner(new File(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            
            int days = scanner.nextInt();
            scanner.nextLine(); 
            double[] avgtemp = new double[days];
            
            for (int i = 0; i < days; i++) {
                String[] tempStrings = scanner.nextLine().split(" ");
                double sum = 0;
                for (String temp : tempStrings) {
                    sum += Double.parseDouble(temp);
                }
                avgtemp[i] = sum / tempStrings.length;
            }
            
            writer.println("Nhiet do trung binh moi ngay:");
            for (int i = 0; i < days; i++) {
                writer.printf("Ngay %d: %.2f\n", i + 1, avgtemp[i]);
            }
            
            System.out.println("Du lieu da duoc ghi vao output.txt");
            
        } catch (IOException e) {
            System.out.println("Loi khi doc/ghi file:: " + e.getMessage());
        }
    }
}
