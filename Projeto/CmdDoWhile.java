public class CmdDoWhile extends Command{
	private String  conteudo;
	
	
	public CmdDoWhile(String conteudo){		
		this.conteudo = conteudo;
	}

	public String toJava(){
		return"while ("+conteudo+");\n";
		 
	}	
}