public class CmdIf extends Command{
	private String  conteudo;
	
	public CmdIf(String conteudo){		
		this.conteudo = conteudo;
		System.out.println("Conteudo Se = "+conteudo);
	}
	
	public String toJava(){
		return "if ("+conteudo+");\n";
	}	
}