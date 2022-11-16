// Scanner -- The lexical analyzer for the Scheme printer and interpreter.

package Parse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

import Tokens.Token;
import Tokens.TokenType;
import Tokens.IdentToken;
import Tokens.IntToken;
import Tokens.StrToken;

public class Scanner {
	private PushbackInputStream in;

	// Maximum length of strings and identifers
	private int BUFSIZE = 1000;
	private byte[] buf = new byte[BUFSIZE];

	public Scanner(InputStream i) {
		in = new PushbackInputStream(i);
	}

	private boolean isSpecialIdentifier(int ch) {
		return (ch == '!' || ch == '$' || ch == '%' || ch == '&' || ch == '*' || ch == '/' || ch == ':' || ch == '<' || ch == '=' || ch == '>' || ch == '?' || ch == '^' || ch == '_' || ch == '~' || ch == '-');

	}

	public Token getNextToken() {
		int ch;

		try {
			// It would be more efficient if we'd maintain our own
			// input buffer and read characters out of that
			// buffer, but reading individual characters from the
			// input stream is easier.
			ch = in.read();

			// TODO: Skip white space and comments
			if (ch == ';')
				while (ch == ';')
				{
						ch=in.read();
				}

				if(ch == -1)
				return null;


			// Return null on EOF
			if (ch == -1)
				return null;

			else if(ch == ' ' || ch == 10 || ch == 4 || ch == '\t' || ch == '\r')
				return getNextToken();

			// Special characters
			else if (ch == '\'')
				return new Token(TokenType.QUOTE);
			else if (ch == '(')
				return new Token(TokenType.LPAREN);
			else if (ch == ')')
				return new Token(TokenType.RPAREN);
			else if (ch == '.')
				// We ignore the special identifier `...'.
				return new Token(TokenType.DOT);

			// Boolean constants
			else if (ch == '#') {
				ch = in.read();

				if (ch == 't')
					return new Token(TokenType.TRUE);
				else if (ch == 'f')
					return new Token(TokenType.FALSE);
				else if (ch == -1) {
					System.err.println("Unexpected EOF following #");
					return null;
				} else {
					System.err.println("Illegal character '" +
							(char)ch + "' following #");
					return getNextToken();
				}
			}

			// String constants
			else if (ch == '"') {
				// TODO: Scan a string into the buffer variable buf
				ch = in.read();
				int i = 0;
				buf = new byte[BUFSIZE];
				while(ch != '"'){
					buf[i] = (byte) ch;
					i++;
					ch = in.read();
				}
				
				return new StrToken(new String(buf));
			}

			// Integer constants
			else if (ch >= '0' && ch <= '9') {
				//
				//parseInt = int i = ch - '0';
				// TODO: scan the number and convert it to an integer
					int j = 0;
					buf = new byte[BUFSIZE];
					while(ch >= '0' && ch <= '9'){
						buf[j] = (byte) ch;
						j++;
						ch = in.read();
					}
				// Put the character after the integer back into the input
				// in.unread(ch);

				in.unread(ch);
				return new IntToken(Integer.parseInt(new String(buf).trim()));
			}

			// Identifiers
			else if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z' || isSpecialIdentifier(ch))){
				int i = 0;
					buf = new byte[BUFSIZE];
					while (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || isSpecialIdentifier(ch)) {
						if (ch >= 'A' && ch <= 'Z') {
							ch += 32;
						}
						buf[i] = (byte) ch;
						i++;
						ch = in.read();
					}

				/* or ch is some other valid first character for an identifier */ 
				// TODO: scan an identifier into the buffer variable buf

				// Put the character after the identifier back into the input
				// in.unread(ch);

				return new IdentToken(new String(buf));
			}

			// Illegal character
			else {
				System.err.println("Illegal input character '" + (char)ch + '\'');
				return getNextToken();
			}

			}catch (IOException e) {
				System.err.println("IOException: " + e.getMessage());
				return null;
			}
		}
	}
