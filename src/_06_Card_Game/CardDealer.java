package _06_Card_Game;

import java.util.ArrayList;
import java.util.Random;

public class CardDealer {
    public static void main(String[] args) {
    	CardDealer dealer = new CardDealer();
		dealer.dealCards();
	}
    ArrayList<Card> deck;
    public void dealCards() {
    	deck = new ArrayList<Card>();
    	for(int i = 0; i < Suit.values().length; i++) {
    		for(int j = 0; j < Rank.values().length; j++) {
    			deck.add(new Card(Rank.values()[j], Suit.values()[i]));
    		}
    	}
    }
}
