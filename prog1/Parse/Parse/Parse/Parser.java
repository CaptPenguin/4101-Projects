// Parser -- the parser for the Scheme printer and interpreter
//
// Defines
//
//   class Parser;
//
// Parses the language
//
//   exp  ->  ( rest
//         |  #f
//         |  #t
//         |  ' exp
//         |  integer_constant
//         |  string_constant
//         |  identifier
//    rest -> )
//         |  exp+ [. exp] )
//
// and builds a parse tree.  Lists of the form (rest) are further
// `parsed' into regular lists and special forms in the constructor
// for the parse tree node class Cons.  See Cons.parseList() for
// more information.
//
// The parser is implemented as an LL(0) recursive descent parser.
// I.e., parseExp() expects that the first token of an exp has not
// been read yet.  If parseRest() reads the first token of an exp
// before calling parseExp(), that token must be put back so that
// it can be reread by parseExp() or an alternative version of
// parseExp() must be called.
//
// If EOF is reached (i.e., if the scanner returns a NULL) token,
// the parser returns a NULL tree.  In case of a parse error, the
// parser discards the offending token (which probably was a DOT
// or an RPAREN) and attempts to continue parsing with the next token.

package Parse;


import Tokens.*;
import Tree.*;


public class Parser {
    private Scanner scanner;

    public Parser(Scanner s) {
        scanner = s;
    }

    // Attempted using ParseNextExp() to call to parseExp using a parameter, was found to be inefficient 
    // public Node parseNextExp(){
    //     Token token = scanner.getNextToken();
    //     if(token == null){
    //         return null;
    //     } else {
    //         return parseExp(token);
    //     }
    // }

    public Node parseExp() {
        // TODO: write code for parsing an exp
        Token token = scanner.getNextToken();
        if(token == null){
            return null;
        }

        if(token.getType() == TokenType.QUOTE){
            return new Cons(new Ident("quote"), new Cons(parseExp(), Nil.getInstance()));
        }
        else if(token.getType() == TokenType.LPAREN){
            return parseRest();
        }
        else if (token.getType() == TokenType.TRUE){
            return new BooleanLit(true);
        }
        else if (token.getType() == TokenType.FALSE){
            return new BooleanLit(false);
        }
        else if(token.getType() == TokenType.INT){
            return new IntLit(token.getIntVal());
        }
        else if(token.getType() == TokenType.STRING){
            return new StrLit(token.getStrVal());
        }
        else if(token.getType() == TokenType.IDENT){
            return new Ident(token.getName());
        }
        else{
            System.err.println("ERROR");
            return null;
        }

    }

    protected Node parseRest() {
        // TODO: write code for parsing rest
        Token token = scanner.getNextToken();

        if(token == null){
            return null;
        }
        else if(token.getType() == TokenType.RPAREN){
            return new Nil();
        }
        else if(token.getType() == TokenType.DOT){
            return new Cons(parseExp(), parseRest());
        }
        else{
            return new Cons(parseExp(), parseRest());
        }

    }

}