// Cond -- Parse tree node strategy for printing the special form cond

package Special;

import Tree.Node;
import Print.Printer;
import Tree.Environment;
import Tree.Nil;
    
public class Cond extends Special {

    public Cond(){}

    public void print(Node t, int n, boolean p) {
        Printer.printCond(t, n, p);
    }

    public Node eval(Node t, Environment e){
        // Node cdr = t.getCdr();
        return Nil.getInstance(); 
    }
}
