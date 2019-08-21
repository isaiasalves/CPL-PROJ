public class CmdElse extends Command{
	private String  conteudo;
	
	public CmdElse(String conteudo){		
		this.conteudo = conteudo;
	}
	
	
	public String toJava(){
		return "\n else  \n";
		 
	}
}
