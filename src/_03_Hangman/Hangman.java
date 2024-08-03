package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
Stack<String> words = new Stack<String>();
String currentWord;
char[] wordLine;
JFrame frame;
JPanel panel;
JLabel wordDisplay;
JLabel healthBar;
int health;
	public static void main(String[] arg0) {
		new Hangman().run();
	}
	void run() {
		int rounds = Integer.parseInt(JOptionPane.showInputDialog("How many rounds to play?"));
		for(int i = rounds; i>0; i--) {
			words.add(Utilities.readRandomLineFromFile("dictionary.txt"));
		}
		startGame();
	}
	void startGame() {
		currentWord=words.pop();
		wordLine=currentWord.toCharArray();
		for(int i = currentWord.length()-1;i>=0;i--) {
			wordLine[i]='_';
		}
		health = 10;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		frame.setVisible(true);
		frame.add(panel);
		frame.addKeyListener(this);
		wordDisplay=new JLabel(String.valueOf(wordLine));
		healthBar = new JLabel("Health: "+health);
		panel.add(wordDisplay);
		panel.add(healthBar);
		frame.pack();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(currentWord.indexOf(e.getKeyChar())==-1) {
			health--;
		} else {
			//unhide all instances of the letter in wordLine
			int i = 0;
			for (char c:currentWord.toCharArray()) {
				if(c==e.getKeyChar()) {
					wordLine[i]=c;
				}
				i++;
			}
		}
		refresh();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	void refresh() {
		healthBar.setText("Health: "+health);
		wordDisplay.setText(String.valueOf(wordLine));
		frame.pack();
		//check if they solved the word
		boolean solved = true;
		for(char c:wordLine) {
			if(c=='_') {
				solved=false;
			}
		}
		if(solved) {
			setupWord();
			refresh();
		}
		//check if out of health
		if(health<=0) {
			switch(JOptionPane.showConfirmDialog(null, "GAME OVER! RESTART?","title", JOptionPane.YES_NO_OPTION)) {
			case 0:
				frame.setVisible(false);
				run();
				break;
			default:
			System.exit(0);
			}
			
		}
	}
	void setupWord() {
		if(words.isEmpty()) {
			switch(JOptionPane.showConfirmDialog(null, "GAME OVER! RESTART?","title", JOptionPane.YES_NO_OPTION)) {
			case 0:
				frame.setVisible(false);
				run();
				break;
			default:
			System.exit(0);
			}
		}
		currentWord=words.pop();
		wordLine=currentWord.toCharArray();
		for(int i = currentWord.length()-1;i>=0;i--) {
			wordLine[i]='_';
		}
	}
}
