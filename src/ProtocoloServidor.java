import java.io.IOException;

public class ProtocoloServidor {

	private Servidor servidor;
	
	public ProtocoloServidor(Servidor servidor){
		this.servidor = servidor;
	}
	
	public void processar(String s) throws IOException{
		System.out.println("mensagem do cliente:");
		System.out.println(s);
		System.out.println("------------------------");
		
		if(s.equals("q")){
			System.out.println("fechar cliente");
			this.servidor.enviarParaCliente("q");
		}else{
			this.servidor.enviarParaCliente("s:"+s);
		}
	}
}
