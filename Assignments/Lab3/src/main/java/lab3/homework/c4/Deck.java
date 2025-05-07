package lab3.homework.c4;
import java.util.*;

/*
 *
 *  author: CacAnhDaDen (nbzzz, Hinno, _qnk_)
 *
 */

public class Deck {
    private List<Card> cardList;
    
    public Deck()
    {
        cardList = new ArrayList<>();
        String[] suits = {"Cơ", "Rô", "Chuồn", "Bích"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        
        for (String suit: suits)
            for (String rank: ranks)
                cardList.add(new Card(rank, suit));
    }
    
    public void shuffle() { Collections.shuffle(cardList); }
    
    public List<List<Card>> deal() 
    {
        List<List<Card>> hands = new ArrayList<>();
        for (int i=0; i<4; i++) hands.add(new ArrayList<>());
        
        for (int i=0; i<cardList.size(); i++) hands.get(i%4).add(cardList.get(i));
        
        return hands;
    }
    
    public List<Card> getCards() { return cardList; }
    public void setCards(List<Card> cardList) { this.cardList = cardList; }
}
