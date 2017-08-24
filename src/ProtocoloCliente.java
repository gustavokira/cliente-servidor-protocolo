import java.io.IOException;

public class ProtocoloCliente {

	private Cliente cliente;
	private boolean conectado;
	
	public ProtocoloCliente(Cliente cliente){
		this.cliente = cliente;
		this.conectado = true;
	}
	
	public void processar(String s) throws IOException{
		System.out.println("mensagem do servidor:");
		System.out.println(s);
		System.out.println("------------------------");
		
		if(s.equals("q")){
			this.conectado = false;
		}else{
			System.out.println("comando sem efeito...");
		}
	}
	public boolean estaConectado(){
		return this.conectado;
	}
}
