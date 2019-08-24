public class CmdAttr extends Command{
	private String  conteudo;
	 
	
	public CmdAttr(String conteudo){		
		this.conteudo = conteudo;
	}
	
	 
	public String toJava(){
		return conteudo ;
		 
	}
}
