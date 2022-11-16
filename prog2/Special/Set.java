// Set -- Parse tree node strategy for printing the special form set!

package Special;

import Tree.Node;
import Print.Printer;
import Tree.Environment;
import Tree.Nil;
import Tree.StrLit;

public class Set extends Special {

    public Set(){}

    public void print(Node t, int n, boolean p) {
        Printer.printSet(t, n, p);
    }

    public Node eval(Node t, Environment env){
        Node current = t.getCdr().getCar();
        if(!(current.isSymbol())){
            return Nil.getInstance();
        }
        Node exp = t.getCdr().getCdr().getCar();
        //was eval(exp, env) but did not work
        exp = exp.eval(env);
        env.assign(current, exp);
        return new StrLit(current.getName());
    }
}
