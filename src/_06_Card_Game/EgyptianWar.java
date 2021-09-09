package _06_Card_Game;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EgyptianWar {
	JFrame frame;
	JPanel panel;
	JButton drawButton;
	JButton slapButton;
	JLabel image = new JLabel();
	private ArrayList<Card> deck;
	private ArrayList<Card> playerdeck = new ArrayList<Card>();
	private ArrayList<Card> stack = new ArrayList<Card>();
	public static final int DECKSIZE = 52;
	public EgyptianWar(ArrayList<Card> deck) {
		frame = new JFrame();
		panel = new JPanel();
		drawButton = new JButton();
		slapButton = new JButton();
		drawButton.setText("DRAW");
		slapButton.setText("SLAP");
		panel.add(drawButton);
		panel.add(slapButton);
		frame.add(panel);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		this.deck = deck;
	}
	/**
	 * 
	 */
	public void startGame() {

		splitDeck();
		System.out.println(deck);
		System.out.println(deck.size() + " " + playerdeck.size());
		System.out.println(playerdeck);
	}
	public void splitDeck() {
		for(int i = 0; i < DECKSIZE/2; i++) {
			playerdeck.add(deck.get(0));
			deck.remove(0);
		}
	}
	public void drawCard(String turn) {
		
	}
	public void slap(String slapper) {
		
	}
	public void burn(String receiver) {
		
	}
	public void collectStack(String receiver) {
		
	}
}
