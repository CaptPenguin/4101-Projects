// Let -- Parse tree node strategy for printing the special form let

package Special;

import Tree.Node;
import Print.Printer;
import Tree.Environment;

public class Let extends Special {

    public Let(){}
    
    public void print(Node t, int n, boolean p) {
        Printer.printLet(t, n, p);
    }

    public Node eval(Node t, Environment env){
        Environment letEnv = new Environment(env);
        Node child = t.getCdr().getCar();
        if(child != null){
            Node current = t.getCar();
            letEnv.define(current, null);
            return null;
        }
        else{
            return child;
        }
    }
}
