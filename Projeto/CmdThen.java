public class CmdThen extends Command{
	private String  conteudo;
	private String instrucao;
	
	public CmdThen(String conteudo){		
		this.conteudo = conteudo;
	}
	
	public String getInstrucao(){		
		return  " {"+conteudo+"};\n";
	}

	public String toJava(){
		this.instrucao = " {"+conteudo+"};\n";
		return instrucao;
	}
}