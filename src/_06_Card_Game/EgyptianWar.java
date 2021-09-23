package _06_Card_Game;

import java.awt.BorderLayout;
import java.awt.Font;
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
	JPanel stackvisual;
	JPanel stackvisual2;
	JButton drawButton;
	JButton slapButton;
	JLabel topCard;
	JLabel secondCard;
	JLabel thirdCard;
	JLabel turn;
	Font main;
	Font sub;
	Font mid;
	private Stack<Card> deck;
	private Stack<Card> playerdeck = new Stack<Card>();
	private Stack<Card> stack = new Stack<Card>();
	public static final int DECKSIZE = 52;
	boolean isPlayerTurn = true;
	int faceCard = 0;

	public EgyptianWar(Stack<Card> deck) {
		main = new Font("BOLD", 30, 30);
		mid = new Font("BOLD", 20, 20);
		sub = new Font(null, 17, 17);
		frame = new JFrame();
		panel = new JPanel();
		stackvisual = new JPanel();
		stackvisual2 = new JPanel();
		drawButton = new JButton();
		slapButton = new JButton();
		turn = new JLabel();
		topCard = new JLabel();
		secondCard = new JLabel();
		thirdCard = new JLabel();
		turn.setFont(mid);
		turn.setText("Player 1's turn");
		topCard.setFont(main);
		topCard.setText("Stack is Empty");
		secondCard.setFont(sub);
		secondCard.setText("Stack is Empty");
		thirdCard.setFont(sub);
		thirdCard.setText("Stack is Empty3");
		drawButton.setText("DRAW");
		drawButton.addActionListener(this);
		slapButton.setText("SLAP");
		slapButton.addActionListener(this);
		stackvisual.add(topCard);
		stackvisual2.add(secondCard);
		panel.add(drawButton);
		panel.add(slapButton);
		panel.add(turn);
		frame.setLayout(new BorderLayout());
		frame.add(stackvisual, BorderLayout.NORTH);
		frame.add(stackvisual2, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(350, 200);
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
		for (int i = 0; i < DECKSIZE / 2; i++) {
			playerdeck.add(deck.get(0));
			deck.remove(0);
		}
	}

	public void drawCard() {
		Card draw;
		if (isPlayerTurn == true) {
			draw = playerdeck.pop();
			System.out.println(stack);
			if (faceCard > 0) {
				if (draw.getRank().getValue() < 10) {
					faceCard--;
					if(faceCard == 0) {
						collectStack("other");
					}
				} else {
					isPlayerTurn = false;
				}
			} else {
				isPlayerTurn = false;
			}
		} else {
			draw = deck.pop();
			System.out.println(stack);
			if (faceCard > 0) {
				if (draw.getRank().getValue() < 10) {
					faceCard--;
					if(faceCard == 0) {
						collectStack("player");
					}
				} else {
					isPlayerTurn = true;
				}
			} else {
				isPlayerTurn = true;
			}
		}
		stack.add(draw);
		if (draw.getRank().getValue() > 10) {
			faceCard = draw.getRank().getValue() - 10;
		}
		topCard.setText(stack.peek().toString());
		if(stack.size() > 1) {
			secondCard.setText(stack.get(stack.size()-2).toString());
		}
		if(stack.size() > 2) {
			secondCard.setText(stack.get(stack.size()-2).toString() + "     " + stack.get(stack.size()-3).toString());
		}
	}

	public void slap() {
		System.out.println("slap");
		if (stack.size() < 2) {
			burn();
		} else if (stack.peek().getRank() == stack.get(stack.size() - 2).getRank()) {
			collectStack("player");
		} else if (stack.size() > 3) {
			if (stack.peek().getRank() == stack.get(stack.size() - 3).getRank()) {
				collectStack("player");
			}
		} else {
			burn();
		}
	}

	public void burn() {
		System.out.println("burn");
	}

	public void collectStack(String winner) {
		System.out.println(playerdeck);
		if (winner.equalsIgnoreCase("player")) {
			for (int i = 0; i < stack.size(); i++) {
				playerdeck.add(0, stack.get(i));
			}
		} else {
			for (int i = 0; i < stack.size(); i++) {
				deck.add(0, stack.get(i));
			}
		}
		System.out.println(playerdeck);
		topCard.setText("Stack is Empty");
		secondCard.setText("Stack is Empty");
		stack.removeAllElements();
		if(winner.equalsIgnoreCase("player")) {
			isPlayerTurn = true;
		}
		else {
			isPlayerTurn = false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == drawButton) {
			drawCard();
		} else if (e.getSource() == slapButton) {
			slap();
		}
	}
}
