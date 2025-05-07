package lab3.homework.c4;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class ExampleC4 {
    public static void main(String[] args)
    {
        Deck deck = new Deck();
        deck.shuffle();
        List<List<Card>> hands = deck.deal();
        
        for (int i=0; i<hands.size(); i++)
        {
            System.out.println("Tay " + (i + 1) + ": ");
            for (Card card : hands.get(i)) System.out.print(card + ", ");
            System.out.println("\n---------------------");
        }
    }
}
