package _06_Card_Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class CardDealer {
    static Stack<Card> deck;
    public static void main(String[] args) {
    	CardDealer dealer = new CardDealer();
		dealer.dealCards();
		dealer.shuffle();
		EgyptianWar start = new EgyptianWar(deck);
		start.startGame();
	}
    public void dealCards() {
    	deck = new Stack<Card>();
    	for(int i = 0; i < Suit.values().length; i++) {
    		for(int j = 0; j < Rank.values().length; j++) {
    			deck.add(new Card(Rank.values()[j], Suit.values()[i]));
    		}
    	}
    }
    public void shuffle() {
    	Collections.shuffle(deck);
    }
}
