public class CmdWhile extends Command{
	private String  conteudo;
	
	
	public CmdWhile(String conteudo){		
		this.conteudo = conteudo;
	}

	public String toJava(){
		return"while ("+conteudo+")\n";
		 
	}	
}