// Set -- Parse tree node strategy for printing the special form set!

package Special;

import Tree.*;

public class Set extends Special {

    public Set(){

    }
 
    public void print(Node t, int n, boolean p) {
        if (p != true){
                System.out.println("(");
        }

        if (t.getCar().isPair()){
            t.getCar().print(0, false);
        }
        else{
            t.getCar().print(0, true);
        }

        System.out.println(" ");

        Node value = t.getCdr();
        if (value == null){
            System.out.println(")");}
        else{
            value.print(0, true);}
    }
}