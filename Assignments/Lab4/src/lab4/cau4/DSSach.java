package lab4.cau4;
import java.io.*;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class DSSach {
    private ArrayList<Sach> list = new ArrayList<>();
    
    public boolean themSach(Sach s)
    {
        if (timSach(s.getMaSach()) != null) return false;
        list.add(s);
        return true;
    }
    
    public Sach timSach(String ma)
    {
        for (Sach s: list)
            if (s.getMaSach().equals(ma)) return s;
        return null;
    }
    
    public boolean xoaSach(String ma)
    {
        Sach s = timSach(ma);
        if (s == null) return false;
        list.remove(s);
        return true;
    }
    
    public boolean capNhatDSSach(String ma, Sach new_)
    {
        for (int i=0; i<list.size(); i++)
            if (list.get(i).getMaSach().equals(ma))
            {
                list.set(i, new_);
                return true;
            }
        return false;
    }
    
    public Sach laySach(int idx) { return list.get(idx); }
    public int getSLSach() { return list.size(); }
    
    public void luuFile(String fname) throws IOException 
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname)))
        {
            oos.writeObject(list);
        }
    }
        
    @SuppressWarnings("unchecked")
    public void docFile(String fname) throws IOException, ClassNotFoundException 
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname))) 
        {
            list = (ArrayList<Sach>) ois.readObject();
        }
    }
}
