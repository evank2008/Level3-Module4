package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	Stack<Character> stool = new Stack<Character>();
    	for (char c : b.toCharArray()) {
    		if(c=='{'||c=='}') {
    			stool.push(c);
    		}
    	}
    	//keep an int of how many open brackets
    	//subtract 1 whenever closed bracket
    	//if ever negative return false
    	//if not 0 at end return false
    	int unconnecteds = 0;
    	for (char c:stool) {
    		if(c=='{') {
    			unconnecteds++;
    		} else {
    			unconnecteds--;
    			if(unconnecteds<0) {
    				return false;
    			}
    		}
    	} if(unconnecteds!=0) {
    		return false;
    	}
        return true;
    }
}