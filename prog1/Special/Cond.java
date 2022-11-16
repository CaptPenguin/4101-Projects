// Cond -- Parse tree node strategy for printing the special form cond

package Special;

import Tree.*;

public class Cond extends Special {

    public Cond(){
        
    }
 
    public void print(Node t, int n, boolean p) throws IllegalArgumentException{
        for (int i = 0; i < n; i++){
				System.out.println(' ');
			}
			System.out.println("(cond");

			Node conditions = t.getCdr();
			if(conditions.isPair())
			{
				conditions.print(n + 2, true);
			}
			else
			{
				throw new IllegalArgumentException("Syntax Error");
			}
    }
}