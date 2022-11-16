// Lambda -- Parse tree node strategy for printing the special form lambda

package Special;

import Tree.Node;
import Print.Printer;
import Tree.Closure;
import Tree.Environment;

public class Lambda extends Special {

	public Lambda(){}

	public void print(Node t, int n, boolean p) {
		Printer.printLambda(t, n, p);
	}

	public Node eval(Node t, Environment e){
		return new Closure(t, e);
	}
}
