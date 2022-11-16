// Cons -- Parse tree node class for representing a Cons node

package Tree;

import Special.*;
import Special.Set;


public class Cons extends Node {
        private Node car;
        private Node cdr;
        private Special form;

        public Cons(Node a, Node d) {
            car = a;
            cdr = d;
            parseList();
        }

            // parseList() `parses' special forms, constructs an appropriate
            // object of a subclass of Special, and stores a pointer to that
            // object in variable form. It would be possible to fully parse
            // special forms at this point. Since this causes complications
            // when using (incorrect) programs as data, it is easiest to let
            // parseList only look at the car for selecting the appropriate
            // object from the Special hierarchy and to leave the rest of
            // parsing up to the interpreter.
        void parseList() {
        
        
            // TODO: Add any helper functions for parseList
            // to the class hierarchy as needed.

                if(car.isSymbol()){

                    String name = car.getName();

                    if(name.equals("quote")){
                        new Quote();
                    }
                    else if(name.equals("lambda")){
                        new Lambda();
                    }
                    else if(name.equals("begin")){
                        new Begin();
                    }
                    else if(name.equals( "if")){
                        new If();
                    }
                    else if(name.equals( "cond")){
                        new Cond();
                    }
                    else if(name.equals("let")){
                        new Let();
                    }
                    else if(name.equals("set!")){
                        new Set();
                    }
                    else if(name.equals("define")){
                        new Define();
                    }
                    else{
                        new Regular();
                    }
                }
                else{
                    new Regular();
                }

        }

        public void print(int n) {
            form.print(this, n, false);
        }

        public void print(int n, boolean p) {
            form.print(this, n, p);
        }

        public Node getCdr(){
            return this.cdr;
        }

        public boolean isPair(){
            return true;
        }
}    