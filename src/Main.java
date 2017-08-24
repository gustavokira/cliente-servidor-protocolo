import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Atividades ats = new Atividades();
		
		ats.listarOpcoesIniciais();
		
		Scanner s = new Scanner(System.in);
		int opcao = s.nextInt();
		//para remover o \n depois que o nextInt deixa
		s.nextLine();
		int porta;
		String ip;
		switch(opcao){
		case 1:
			System.out.println("CLIENTE");
//			System.out.println("digite o número do ip na qual o servidor está rodando");
			ip = s.nextLine();
			
			System.out.println("digite o número da porta na qual o servidor está rodando");
			porta = s.nextInt();
			ats.rodarCliente(ip,porta);
			break;
		case 2:
			System.out.println("SERVIDOR");
			System.out.println("digite o número da porta na qual o programa irá rodar.");
			porta = s.nextInt();
			ats.rodarServidor(porta);
			break;
		}
		
		s.close();
		System.out.println("acaboooo!!!!");
	}
}