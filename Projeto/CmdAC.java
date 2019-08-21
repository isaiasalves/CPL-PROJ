public class CmdAC extends Command{
	private String  conteudo;
	 
	
	public CmdAC(String conteudo){		
		this.conteudo = conteudo;
	}
	
	 
	public String toJava(){
		return " { \n";
		 
	}
}
