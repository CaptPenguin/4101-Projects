// Quote -- Parse tree node strategy for printing the special form quote

package Special;

import Tree.*;

public class Quote extends Special {

    public Quote(){

    }
 
    public void print(Node t, int n, boolean p) {
        System.out.println("'");
        
        if (t.getCdr() == null){
        System.out.println("");
        }
        else{
            t.getCdr().print(0, false);
        }    
    }

}