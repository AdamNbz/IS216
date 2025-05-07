package lab3.homework.c4;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class Card {
    private String rank, suit;
    
    public Card(String rank, String suit) 
    {
        this.rank = rank;
        this.suit = suit;
    }
    
    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }
    public String getSuit() { return suit; }
    public void setSuit(String suit) { this.suit = suit; }
    
    @Override
    public String toString()
    {
        return rank + " " + suit;
    }
}
