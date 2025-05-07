package lab3.homework.c5;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class ExampleC5 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Dictionary tuDien = new Dictionary();
        
        tuDien.themTu(new Word("apple", "quả táo", "noun", "a common fruit"));
        tuDien.themTu(new Word("book", "sách", "noun", "collection of written pages"));
        tuDien.themTu(new Word("run", "chạy", "verb", "to move fast"));
        
        System.out.println("Từ điển tiếng Anh:");
        tuDien.hienThiTuDien();
        
        System.out.print("Nhập từ cần tra: ");
        String searchWord = sc.nextLine();
        Word result = tuDien.traTu(searchWord);
        if (result != null) 
        {
            System.out.println("Kết quả tra từ:");
            System.out.println(result);
        } 
        else
            System.out.println("Không tìm thấy từ '" + searchWord + "' trong từ điển.");
    }
}
