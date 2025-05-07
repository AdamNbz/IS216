package lab3.homework.c5;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class Dictionary {
    private TreeMap<String, Word> TM;

    public Dictionary() 
    {
        TM = new TreeMap<>();
    }
    
    public void themTu(Word tu) 
    {
        TM.put(tu.getTuTiengAnh().toLowerCase(), tu);
    }
    
    public Word traTu(String key) 
    {
        return TM.get(key.toLowerCase());
    }
    
    public void hienThiTuDien() 
    {
        for (Map.Entry<String, Word> entry : TM.entrySet())
            System.out.println(entry.getValue());
    }
}
