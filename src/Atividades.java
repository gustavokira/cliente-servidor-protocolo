import java.io.IOException;

public class Atividades {
	
	
	public void listarOpcoesIniciais(){
		System.out.println("digite:");
		System.out.println("1)Rodar cliente");
		System.out.println("2)Rodar servidor");
	}
		
	public void rodarServidor(int porta){
		Servidor servidor;
		try {
			while(true){
				servidor = new Servidor(porta);
				servidor.iniciar();
				servidor.rodar();
				servidor.fechar();
			}
		} catch (IOException e) {
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.println("Problemão. Chamar o professor. Caso ele diga 'já vai', esperar com calma e serenidade.");
			System.out.println("Neste meio tempo, veja na internet os comandos do windows: tasklist e tskill");
			System.out.println("--------------------------------------------------------------------------------------------------");
		}
	}
	
	public void rodarCliente(String ip, int porta){
		Cliente cliente;
		try {
			cliente = new Cliente(ip,porta);
			cliente.iniciar();
			cliente.rodar();
			cliente.fechar();
		} catch (IOException e) {
			System.out.println("--------------------------------------------------------------------------------------------------");
			System.out.println("Problemão. Chamar o professor. Caso ele diga 'já vai', esperar com calma e serenidade.");
			System.out.println("--------------------------------------------------------------------------------------------------");
		}
	}
}