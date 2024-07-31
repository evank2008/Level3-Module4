package _03_Hangman;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {
Stack<String> words = new Stack<String>();
String currentWord;
char[] wordLine;
JFrame frame;
JPanel panel;
JLabel wordDisplay;
JLabel healthBar;
	public static void main(String[] arg0) {
		new Hangman().run();
	}
	void run() {
		int rounds = Integer.parseInt(JOptionPane.showInputDialog("How many rounds to play?"));
		for(int i = rounds; i>0; i--) {
			words.add(Utilities.readRandomLineFromFile("dictionary.txt"));
		}
		playGame();
	}
	void playGame() {
		currentWord=words.pop();
		wordLine=currentWord.toCharArray();
		for(int i = currentWord.length()-1;i>=0;i--) {
			wordLine[i]='_';
		}
		int health = 10;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		frame.setVisible(true);
		frame.add(panel);
		//ERROR IS HERE: wordLine(a char array) IS HAVING TROUBLE CONVERTING TO STRING.
		System.out.println(wordLine.toString());
		wordDisplay=new JLabel(wordLine.toString());
		healthBar = new JLabel("Health: "+health);
		panel.add(wordDisplay);
		panel.add(healthBar);
		frame.pack();
	}
}
