// Regular -- Parse tree node stratagy for printing regular lists

package Special;

import Tree.Node;

public class Regular extends Special {

    public Regular(){

    }
 
    public void print(Node t, int n, boolean p) {
        for (int i = 0; i < n; i++){
            System.out.println(' ');
        }
        if (!p){
            System.out.println('(');
        }
        t.getCar().print(0);
        System.out.println(' ');
        t.getCdr().print(0, true);
    }
}