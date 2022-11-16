// If -- Parse tree node strategy for printing the special form if

package Special;

import Tree.*;

public class If extends Special {
 
    public void print(Node t, int n, boolean p) throws IllegalArgumentException{
        for (int i = 0; i < n; i++){
				System.out.println(' ');
        }    
        System.out.println("(if ");

        Node predicate = t.getCdr().getCar();
        if (predicate.isPair()){
				predicate.print(0, p);
        }      
        else{
            throw new IllegalArgumentException("Syntax Error");
        }
        System.out.println();

        Node thenClause = t.getCdr().getCdr().getCar();
        if (!thenClause.isNull()){
				thenClause.print(n + 2, p);
        }
        else{
            throw new IllegalArgumentException("Syntax Error");
        }
        System.out.println();

        Node elseClause = t.getCdr().getCdr().getCdr().getCar();
        if (!elseClause.isNull()){
            elseClause.print(n + 2, p);
        }
        else{
            throw new IllegalArgumentException("Syntax Error");
        }
        for (int i = 0; i < n; i++){
            System.out.println(' ');
        }
        System.out.println(')');
    }
    void printQuote(Node c, int n, boolean p){

    }
}