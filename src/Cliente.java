import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	
	private Socket cliente;
	private Scanner teclado;
	private String ip;
	private int porta;
	private Scanner scanner;
	private ProtocoloCliente protocoloCliente;
	
	private PrintStream saida; 
	public Cliente(String ip, int porta){
		this.ip = ip;
		this.porta = porta;
		this.protocoloCliente = new ProtocoloCliente(this);;
	}
	
	public void iniciar() throws UnknownHostException, IOException{
		this.cliente = new Socket(this.ip, this.porta);
		System.out.println("O cliente se conectou ao servidor!");
		this.teclado = new Scanner(System.in);
	    this.saida = new PrintStream(this.cliente.getOutputStream());     
	    this.scanner = new Scanner(this.cliente.getInputStream());
	}
	
	public void rodar() throws IOException{
		while (this.teclado.hasNextLine()) {
			
			
			this.saida.println(this.teclado.nextLine());
			
			if(this.scanner.hasNextLine()){
				this.protocoloCliente.processar(this.scanner.nextLine());
			}else{
				System.out.println("parece que o servidor nao enviou nada");
			}
			
			if(!this.protocoloCliente.estaConectado()){
				System.out.println("parece que o servidor fechou....");
				break;
			}
		}
	}
	
	public void fechar() throws IOException{
		this.saida.close();
	    this.teclado.close();
	    this.scanner.close();
	    this.cliente.close();
	}
}