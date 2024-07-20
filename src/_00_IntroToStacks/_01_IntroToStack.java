package _00_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
    public static void main(String[] args) {
        // 1. Create a Stack of Doubles
        //    Don't forget to import the Stack class
    	Random ran= new Random();
    	Stack<Double> stubble = new Stack<Double>();
        // 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
    	for(int i = 100; i>0; i--) {
    		stubble.push(ran.nextDouble()*100);
    	}
        // 3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
    	int bench1 = Integer.parseInt(JOptionPane.showInputDialog("Enter a number from 1 to 100"));
    	int bench2 = Integer.parseInt(JOptionPane.showInputDialog("Enter another number from 1 to 100"));
        // 4. Pop all the elements off of the Stack. Every time a double is popped that is
        //    between the two numbers entered by the user, print it to the screen.
    	if(bench1>bench2) {
    		int temp = bench1;
    		bench1=bench2;
    		bench2=temp;
    		//bench1 is smaller than bench2
    	}
    	System.out.println("Numbers between "+bench1+" and "+bench2+"...");
    	while(!stubble.isEmpty()) {
    		double p = stubble.pop();
    		if(p>=bench1&&p<=bench2) {
    			System.out.println(p);
    		}
    	}
System.exit(0);
        // EXAMPLE:
        // NUM 1: 65
        // NUM 2: 75

        // Popping elements off stack...
        // Elements between 65 and 75:
        // 66.66876846
        // 74.51651681
        // 70.05110654
        // 69.21350456
        // 71.54506465
        // 66.47984807
        // 74.12121224
    }
}
