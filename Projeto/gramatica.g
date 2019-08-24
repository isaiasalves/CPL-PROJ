class MeuParser extends Parser;
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
}

prog 	: { mapaVar = new java.util.HashMap<String, String>();
			mapaTipoVar = new java.util.HashMap<String, String>();
		  
		  }
		  "programa" declara bloco 
		;
		
declara	: "declare" ("String" | "int")   
			  	T_Id  {mapaVar.put(LT(0).getText(), LT(-1).getText()+" "+LT(0).getText());}
			  	(
				T_virg ("String" | "int") 
				T_Id  {mapaVar.put(LT(0).getText(), LT(-1).getText()+" "+LT(0).getText());}
			  )* 
			 T_pontof 
			{
		      p.setVariaveis(mapaVar.values());
			  System.out.println("Variable list assembled...");
		    }
		;

bloco 	: (cmd)+ "fimprog"
		;
		
cmd		: cmdLeia 		T_pontof
		| cmdEscr		T_pontof
		| cmdAttr		T_pontof
		| cmdIf
		| cmdWhile
		| cmdDoWhile	T_pontof
		;


cmdLeia : "leia" T_ap 
			     T_Id { 
						if (mapaVar.get(LT(0).getText()) == null){
							throw new RuntimeException("ERROR ID "+LT(0).getText()+" não declarado!");
						}
						p.addCommand(new CmdLeitura(LT(0).getText()));
				  	  }
			T_fp    
		;

cmdEscr : "escreva" T_ap ( 
							T_texto 
							| 
							T_Id { 
									if (mapaVar.get(LT(0).getText()) == null){
									throw new RuntimeException("ERROR ID "+LT(0).getText()+" não declarado!");
								}
				  	  		}
			) 	{ p.addCommand(new CmdEscrita(LT(0).getText())); }
			
			T_fp  
		;

cmdAttr : T_Id 	{
		
					if (mapaVar.get(LT(0).getText()) == null){
					   throw new RuntimeException("ERROR ID "+LT(0).getText()+" não declarado!");
					}
}	

		  T_attr expr

		;

cmdIf 	:  "se"     T_ap	 expr  T_Oprel 	{p.addCommand(new CmdIf(LT(-1).getText()+" "+LT(0).getText()+" "+LT(1).getText())); } expr T_fp  
		   "entao"  T_ac	 {p.addCommand(new CmdAC(""));} (cmd)* {p.addCommand(new CmdFC(""));} 	    T_fc       
		  ("senao"  T_ac     {p.addCommand(new CmdElse(""));} {p.addCommand(new CmdAC(""));} (cmd)  {p.addCommand(new CmdFC(""));}   T_fc )* 
		
		;

cmdWhile: "enquanto" T_ap expr T_Oprel {p.addCommand(new CmdWhile(LT(-1).getText()+" "+LT(0).getText()+" "+LT(1).getText())); } expr T_fp
		   T_ac  {p.addCommand(new CmdAC(""));} (cmd)* {p.addCommand(new CmdFC(""));} T_fc 
		;

cmdDoWhile: "faca" {p.addCommand(new CmdDo(""));} T_ac {p.addCommand(new CmdAC(""));} (cmd) {p.addCommand(new CmdFC(""));} T_fc 
			"enquanto" T_ap expr T_Oprel {p.addCommand(new CmdDoWhile(LT(-1).getText()+" "+LT(0).getText()+" "+LT(1).getText())); } expr T_fp
		;		

expr    : termo (( T_soma | T_subt ) termo)*
		;

termo 	: fator (( T_mult | T_divi ) fator)*
		;

fator   : T_Id 
		  { 
				if (mapaVar.get(LT(0).getText()) == null){
						throw new RuntimeException("ERROR ID "+LT(0).getText()+" não declarado!");
					}
				}
		| T_num  
		| T_ap expr T_fp
		;

class MeuLexer extends Lexer;

options{
	caseSensitive = true;
	charVocabulary = '\0'..'\377';
    k = 4;
}



T_Id 		: ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9' )*
			;
	
T_comment   : "//"
			;
		 
T_virg		: ','
			;
			
T_Oprel		:("==" | '<' | '>' | "<=" | ">= " | "!=" )
			;

T_pontof	: '.'
			;

T_num       : ('0'..'9')+ ('.'('0'..'9')+)?
			; 

T_soma		:'+'
			;

T_subt		:'-'
			;

T_mult  	: '*'
			;

T_divi 		:'/'
			;
		
T_ap		: '('
			;
		
T_fp		:')'
			;

T_ac		:'{'
			;

T_fc		:'}'
			;

T_texto		: '"' ( 'a'..'z' | '0'..'9' | ' ' | 'A'..'Z' )+ '"'
	  		;

T_attr  	: ":="
			;

T_blank 	: ( ' ' | '\n' {newline();}| '\r' | '\t' ) {_ttype=Token.SKIP;}
			;
