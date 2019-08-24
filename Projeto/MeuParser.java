// $ANTLR 2.7.6 (2005-12-22): "gramatica.g" -> "MeuParser.java"$

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;

public class MeuParser extends antlr.LLkParser       implements MeuParserTokenTypes
 {

	java.util.HashMap<String, String> mapaVar;
	java.util.HashMap<String, String> mapaTipoVar;
	Programa p;
	
	public void setPrograma(String name){
      p = new Programa(name);
    }
	
	public Programa getPrograma(){
       return p;
    }

protected MeuParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public MeuParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected MeuParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public MeuParser(TokenStream lexer) {
  this(lexer,1);
}

public MeuParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
}

	public final void prog() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			mapaVar = new java.util.HashMap<String, String>();
						mapaTipoVar = new java.util.HashMap<String, String>();
					  
					
			match(LITERAL_programa);
			declara();
			bloco();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
	}
	
	public final void declara() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_declare);
			{
			switch ( LA(1)) {
			case LITERAL_String:
			{
				match(LITERAL_String);
				break;
			}
			case LITERAL_int:
			{
				match(LITERAL_int);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(T_Id);
			mapaVar.put(LT(0).getText(), LT(-1).getText()+" "+LT(0).getText());
			{
			_loop6:
			do {
				if ((LA(1)==T_virg)) {
					match(T_virg);
					{
					switch ( LA(1)) {
					case LITERAL_String:
					{
						match(LITERAL_String);
						break;
					}
					case LITERAL_int:
					{
						match(LITERAL_int);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					match(T_Id);
					mapaVar.put(LT(0).getText(), LT(-1).getText()+" "+LT(0).getText());
				}
				else {
					break _loop6;
				}
				
			} while (true);
			}
			match(T_pontof);
			
					      p.setVariaveis(mapaVar.values());
						  System.out.println("Variable list assembled...");
					
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
	}
	
	public final void bloco() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			{
			int _cnt9=0;
			_loop9:
			do {
				if ((_tokenSet_1.member(LA(1)))) {
					cmd();
				}
				else {
					if ( _cnt9>=1 ) { break _loop9; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt9++;
			} while (true);
			}
			match(LITERAL_fimprog);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
	}
	
	public final void cmd() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_leia:
			{
				cmdLeia();
				match(T_pontof);
				break;
			}
			case LITERAL_escreva:
			{
				cmdEscr();
				match(T_pontof);
				break;
			}
			case T_Id:
			{
				cmdAttr();
				match(T_pontof);
				break;
			}
			case LITERAL_se:
			{
				cmdIf();
				break;
			}
			case LITERAL_enquanto:
			{
				cmdWhile();
				break;
			}
			case LITERAL_faca:
			{
				cmdDoWhile();
				match(T_pontof);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
	}
	
	public final void cmdLeia() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_leia);
			match(T_ap);
			match(T_Id);
			
									if (mapaVar.get(LT(0).getText()) == null){
										throw new RuntimeException("ERROR ID "+LT(0).getText()+" não declarado!");
									}
									p.addCommand(new CmdLeitura(LT(0).getText()));
							  	
			match(T_fp);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void cmdEscr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_escreva);
			match(T_ap);
			{
			switch ( LA(1)) {
			case T_texto:
			{
				match(T_texto);
				break;
			}
			case T_Id:
			{
				match(T_Id);
				
													if (mapaVar.get(LT(0).getText()) == null){
													throw new RuntimeException("ERROR ID "+LT(0).getText()+" não declarado!");
												}
								  	  		
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			p.addCommand(new CmdEscrita(LT(0).getText()));
			match(T_fp);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void cmdAttr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(T_Id);
			
					
								if (mapaVar.get(LT(0).getText()) == null){
								   throw new RuntimeException("ERROR ID "+LT(0).getText()+" não declarado!");
								}
			
			match(T_attr);
			expr();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void cmdIf() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_se);
			match(T_ap);
			expr();
			match(T_Oprel);
			p.addCommand(new CmdIf(LT(-1).getText()+" "+LT(0).getText()+" "+LT(1).getText()));
			expr();
			match(T_fp);
			match(LITERAL_entao);
			match(T_ac);
			p.addCommand(new CmdAC(""));
			{
			_loop17:
			do {
				if ((_tokenSet_1.member(LA(1)))) {
					cmd();
				}
				else {
					break _loop17;
				}
				
			} while (true);
			}
			p.addCommand(new CmdFC(""));
			match(T_fc);
			{
			_loop20:
			do {
				if ((LA(1)==LITERAL_senao)) {
					match(LITERAL_senao);
					match(T_ac);
					p.addCommand(new CmdElse(""));
					p.addCommand(new CmdAC(""));
					{
					cmd();
					}
					p.addCommand(new CmdFC(""));
					match(T_fc);
				}
				else {
					break _loop20;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
	}
	
	public final void cmdWhile() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_enquanto);
			match(T_ap);
			expr();
			match(T_Oprel);
			p.addCommand(new CmdWhile(LT(-1).getText()+" "+LT(0).getText()+" "+LT(1).getText()));
			expr();
			match(T_fp);
			match(T_ac);
			p.addCommand(new CmdAC(""));
			{
			_loop23:
			do {
				if ((_tokenSet_1.member(LA(1)))) {
					cmd();
				}
				else {
					break _loop23;
				}
				
			} while (true);
			}
			p.addCommand(new CmdFC(""));
			match(T_fc);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
	}
	
	public final void cmdDoWhile() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			match(LITERAL_faca);
			p.addCommand(new CmdDo(""));
			match(T_ac);
			p.addCommand(new CmdAC(""));
			{
			cmd();
			}
			p.addCommand(new CmdFC(""));
			match(T_fc);
			match(LITERAL_enquanto);
			match(T_ap);
			expr();
			match(T_Oprel);
			p.addCommand(new CmdDoWhile(LT(-1).getText()+" "+LT(0).getText()+" "+LT(1).getText()));
			expr();
			match(T_fp);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final void expr() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			termo();
			{
			_loop29:
			do {
				if ((LA(1)==T_soma||LA(1)==T_subt)) {
					{
					switch ( LA(1)) {
					case T_soma:
					{
						match(T_soma);
						break;
					}
					case T_subt:
					{
						match(T_subt);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					termo();
				}
				else {
					break _loop29;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void termo() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			fator();
			{
			_loop33:
			do {
				if ((LA(1)==T_mult||LA(1)==T_divi)) {
					{
					switch ( LA(1)) {
					case T_mult:
					{
						match(T_mult);
						break;
					}
					case T_divi:
					{
						match(T_divi);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					fator();
				}
				else {
					break _loop33;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
	}
	
	public final void fator() throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case T_Id:
			{
				match(T_Id);
				
								if (mapaVar.get(LT(0).getText()) == null){
										throw new RuntimeException("ERROR ID "+LT(0).getText()+" não declarado!");
									}
								
				break;
			}
			case T_num:
			{
				match(T_num);
				break;
			}
			case T_ap:
			{
				match(T_ap);
				expr();
				match(T_fp);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_6);
		}
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"\"programa\"",
		"\"declare\"",
		"\"String\"",
		"\"int\"",
		"T_Id",
		"T_virg",
		"T_pontof",
		"\"fimprog\"",
		"\"leia\"",
		"T_ap",
		"T_fp",
		"\"escreva\"",
		"T_texto",
		"T_attr",
		"\"se\"",
		"T_Oprel",
		"\"entao\"",
		"T_ac",
		"T_fc",
		"\"senao\"",
		"\"enquanto\"",
		"\"faca\"",
		"T_soma",
		"T_subt",
		"T_mult",
		"T_divi",
		"T_num",
		"T_comment",
		"T_blank"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 50630912L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 54827264L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 1024L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 541696L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 201868288L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 1007174656L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	
	}
