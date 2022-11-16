// If -- Parse tree node strategy for printing the special form if

package Special;

import Tree.Node;
import Print.Printer;
import Tree.Environment;
import Tree.BooleanLit;

public class If extends Special {

    public If(){}

    public void print(Node t, int n, boolean p) {
        Printer.printIf(t, n, p);
    }

    public Node eval(Node t, Environment env){
        // Node cond = t.getCdr().getCar();
        Node ifTrue = t.getCdr().getCdr().getCar();
        Node ifFalse = t.getCdr().getCdr().getCdr().getCar();
        boolean checkTrueResult = checkTrue(t, env);
        if(checkTrueResult == false){
            return ifFalse.eval(env);
        }
        else{
            return ifTrue.eval(env);
        }
    }

    public Boolean checkTrue(Node cond, Environment env){
        // took away the cond in eval(cond, env) then added the above notion.
        Node check = cond.getCdr().getCdr().getCar().eval(env);
        if(check.isBoolean() == true){
            BooleanLit boolVal = (BooleanLit) check;
            return boolVal.getVal();
        }
        return true;
    }
}
