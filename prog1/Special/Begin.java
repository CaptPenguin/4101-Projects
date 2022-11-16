// Begin -- Parse tree node strategy for printing the special form begin

package Special;

import Tree.*;

public class Begin extends Special {

    public Begin(){

    }

    public void print(Node t, int n, boolean p) throws IllegalArgumentException{
        for (int i = 0; i < n; i++){
				System.out.println(' ');
			}
			System.out.println("(begin");

			if (t.getCdr().isPair()){
				t.getCdr().print(n + 2, p);
            }    
			else{
				throw new IllegalArgumentException("Syntax Error");	
            }    
			for (int i = 0; i < n; i++){
				System.out.println(' ');
			}
			System.out.println(")");
    }
}