package _00_IntroToStacks;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * 
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */
JFrame frame = new JFrame("Michael Jackson Conversation Simulator");
JPanel panel = new JPanel();
JLabel label = new JLabel();
Random ran = new Random();
Stack<Character> starachter = new Stack<Character>();
public static void main(String[] args) {
	_02_TextUndoRedo code = new _02_TextUndoRedo();
	code.run();
}
void run() {
	panel.add(label);
	panel.setPreferredSize(new Dimension(400,50));
	frame.add(panel);
	frame.setVisible(true);
	frame.pack();
	frame.addKeyListener(this);
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Key Code "+e.getKeyCode());
	if(e.getKeyCode()==27) {
		System.exit(0);
	}

	if(e.getKeyCode()==8||e.getKeyCode()==127) {
		if(!label.getText().equals("")) {
			//pressed backspace/delete
		starachter.push(label.getText().charAt(label.getText().length()-1));
		System.out.println("pushed character "+label.getText().charAt(label.getText().length()-1));
		label.setText(label.getText().substring(0,label.getText().length()-1));
		}
	}else {
		//50% chance to type a K or L when pressing K
		if(e.getKeyCode()==75) {
			if(ran.nextBoolean()) {
				label.setText(label.getText()+e.getKeyChar());
			} else {
				label.setText(label.getText()+'l');
			}
		} else if(e.getKeyCode()!=76){
	label.setText(label.getText()+e.getKeyChar());
		} else {
			//time to undo
			if(!starachter.isEmpty()) {
			label.setText(label.getText()+starachter.pop());
			}
		}
	}
	frame.pack();
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
