package _06_Card_Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EgyptianWar implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton drawButton;
	JButton slapButton;
	JLabel image = new JLabel();
	private Stack<Card> deck;
	private Stack<Card> playerdeck = new Stack<Card>();
	private Stack<Card> stack = new Stack<Card>();
	public static final int DECKSIZE = 52;
	boolean isPlayerTurn = true;
	int faceCard = 0;
	public EgyptianWar(Stack<Card> deck) {
		frame = new JFrame();
		panel = new JPanel();
		drawButton = new JButton();
		slapButton = new JButton();
		drawButton.setText("DRAW");
		drawButton.addActionListener(this);
		slapButton.setText("SLAP");
		slapButton.addActionListener(this);
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
	public void drawCard() {
		Card draw;
		if(isPlayerTurn == true) {
			draw = playerdeck.pop();
			isPlayerTurn = false;
		} else {
			draw = deck.pop();
			isPlayerTurn = true;
		}
		stack.add(draw);
		if(draw.getRank().getValue() > 10) {
			faceCard = draw.getRank().getValue()-10;
		}
		System.out.println(stack);
	}
	public void slap() {
		System.out.println(stack.peek());
		System.out.println(stack.get(stack.size()-2));
		if(stack.peek() == stack.get(stack.size()-2)) {
			
		}
	}
	public void burn(String receiver) {
		
	}
	public void collectStack(String receiver) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == drawButton) {
			drawCard();
		} else if(e.getSource() == slapButton) {
			slap();
		}
	}
}
