// Define -- Parse tree node strategy for printing the special form define

package Special;

import Tree.*;

public class Define extends Special {

    public Define(){

    }
 
    public void print(Node t, int n, boolean p) throws IllegalArgumentException{
        for (int i = 0; i < n; i++){
				System.out.println(' ');
			}
			System.out.println("(define ");

			Node name = t.getCdr().getCar();
			if (name.isSymbol()){
				name.print(0, false);
            }    
			else{
				throw new IllegalArgumentException("Syntax Error");
            }
			System.out.println(" ");

			Node value = t.getCdr().getCdr().getCar();
			if (!value.isNull()){
				value.print(0, true);
            }
			else{
				throw new IllegalArgumentException("Syntax Error");
            }
			System.out.println(")");
    }
}