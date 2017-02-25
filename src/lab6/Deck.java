/*
Alex Stevens
2/23/2017
Lab-6 Deck Class
Csis 123B-3183
0495503
 */
package lab6;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author alder
 */
public class Deck {
    
    private int index=0;
    final int LAST_CARD =45;
    
   ArrayList<Card> deck = new ArrayList<Card>();
    
   public Deck(){
        
       this("file:img\\");      // invoke overloaded Deck constructor passing path
    }
    public Deck(String Dir){
        
        this.loadCards(Dir);
        
    }
    public void shuffle(){
        
        Collections.shuffle(deck);
        
    }
    
    
    private void loadCards(String Dir){
        
        int name;
        String cardName;
        for(int i=1;i<=52;i++){
            
           name = 100+i;
           
           cardName = (Dir+name+".gif");
           deck.add(new Card(cardName));
            
        }
        
    }
    
    public Card deal(){
   
        if(index>=LAST_CARD){
            
            this.shuffle();
            this.index=0;
        }
        
        
        
        return deck.get(index); 
    }
    
    
}
