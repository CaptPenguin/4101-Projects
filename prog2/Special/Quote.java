// Quote -- Parse tree node strategy for printing the special form quote

package Special;

import Tree.Node;
import Print.Printer;
import Tree.Environment;
import Tree.Nil;

public class Quote extends Special {

    public Quote(){}

    public void print(Node t, int n, boolean p) {
        Printer.printQuote(t, n, p);
    }

    public Node eval(Node t, Environment e){
        Node current = t.getCdr().getCar();
        if(current == null){
            return Nil.getInstance();
        }
        else{
            return current;
        }
    }
}
