// Let -- Parse tree node strategy for printing the special form let

package Special;

import Tree.*;

public class Let extends Special {

    public Let(){

    }

    public void print(Node t, int n, boolean p) throws IllegalArgumentException{
        for (int i = 0; i < n; i++){
            System.out.println(' ');
        }
        System.out.println("(let ");

        Node assignments = t.getCdr().getCar();
        if (assignments.isPair()){
            assignments.print(0, false);
        }
        else{
            throw new IllegalArgumentException("Syntax Error");
        }
        System.out.println();

        Node body = t.getCdr().getCdr();
        if (body.isPair()){
            body.print(n + 2, true);
        }
        else{
            throw new IllegalArgumentException("Syntax Error");
        }
        System.out.println();
        for (int i = 0; i < n; i++){
            System.out.println(' ');
        }
        System.out.println("/LET");
    }
}