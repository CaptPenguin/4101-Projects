// Lambda -- Parse tree node strategy for printing the special form lambda

package Special;

import Tree.*;

public class Lambda extends Special {

    public Lambda(){

    }
 
    public void print(Node t, int n, boolean p) throws IllegalArgumentException{
        for (int i = 0; i < n; i++){
			System.out.println(' ');
            System.out.println("(lambda ");
        }

		Node secondNode = t.getCdr().getCar();
		if (secondNode.isPair()){
			secondNode.print(0, false);
        }        
		else{
			throw new IllegalArgumentException("Syntax Error");
        }

        System.out.println();
        
		Node thirdNode = t.getCdr().getCdr().getCar();
		if (thirdNode.isPair()){
			thirdNode.print(n + 2, false);
        }
		else{
			throw new IllegalArgumentException("Syntax Error");
        }

        System.out.println();

		for (int i = 0; i < n; i++){
            System.out.println(' ');
        }

		System.out.println(')');

    }
    void printQuote(Node c, int n, boolean p){

    }
}