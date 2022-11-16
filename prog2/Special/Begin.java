// Begin -- Parse tree node strategy for printing the special form begin

package Special;

import Tree.Node;
import Print.Printer;
import Tree.Nil;
import Tree.Environment;

public class Begin extends Special {

    public Begin(){}

    public void print(Node t, int n, boolean p) {
        Printer.printBegin(t, n, p);
    }

    public Node eval(Node t, Environment e){
        Node cdr = t.getCdr();
        if(cdr == null){
            return Nil.getInstance();
        }

        Node car = evalCdr(cdr, null, e);
        if(car == null){
            System.out.println("Error");
        }
        return car;
    }

    private Node evalCdr(Node cdr, Node exp, Environment env){
        return Nil.getInstance();
    }
}
