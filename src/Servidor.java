import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	private ServerSocket servidor;
	private Socket cliente;
	private Scanner scanner;
	private PrintStream saida;
	private ProtocoloServidor protocoloServidor;
	
	public Servidor(int port) throws IOException{
		this.servidor = new ServerSocket(port);
	    System.out.println("Porta "+port+" aberta!");
	    this.protocoloServidor = new ProtocoloServidor(this);
	}
	
	public void iniciar() throws IOException{
		this.cliente = servidor.accept();
		this.saida = new PrintStream(this.cliente.getOutputStream());
	    System.out.println("Nova conexão com o cliente com ip:" + cliente.getInetAddress().getHostAddress() );
	}
	
	public void rodar() throws IOException{
	     this.scanner = new Scanner(this.cliente.getInputStream());
	     while (this.scanner.hasNextLine()) {
	    	 this.protocoloServidor.processar(this.scanner.nextLine());
	     }	     
	}
	public void fechar() throws IOException{
		this.scanner.close();
		this.servidor.close();
	    this.cliente.close();
	}
	public void enviarParaCliente(String s){
		this.saida.println(s);
	}
}