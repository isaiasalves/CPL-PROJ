public class CmdDo extends Command{
	private String  conteudo;
	
	
	public CmdDo(String conteudo){		
		this.conteudo = conteudo;
	}

	 
	public String toJava(){
		return "Do";
		 
	}	
}