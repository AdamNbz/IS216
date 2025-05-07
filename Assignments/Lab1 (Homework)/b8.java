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

public class b8 {
    public static void main(String[] args) {
        String file1 = "input8.1.txt";
        String file2 = "input8.2.txt";
        
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {
            
            String line1, line2;
            int lineNumber = 0;
            
            while ((line1 = reader1.readLine()) != null | (line2 = reader2.readLine()) != null) {
                lineNumber++;
                if (line1 == null) line1 = "";
                if (line2 == null) line2 = "";
                
                if (!line1.equals(line2)) {
                    System.out.println(lineNumber + " // " + line1);
                    System.out.println(lineNumber + " \\ " + line2);
                }
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }
}
