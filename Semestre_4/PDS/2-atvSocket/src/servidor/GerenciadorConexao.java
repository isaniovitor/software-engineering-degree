package servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class GerenciadorConexao {
	
	GerenciadorConfiguracaoServidor configuracaoServidor;
	
	public GerenciadorConexao (GerenciadorConfiguracaoServidor configuracaoServidor){
		this.configuracaoServidor = configuracaoServidor;
	}

	public void disponibilizaServico(){
		try {
		      // Instancia o ServerSocket ouvindo a porta 12345
		      ServerSocket servidor = new ServerSocket(configuracaoServidor.getPorta());
		      System.out.println("Servidor ouvindo a porta 12345");
		      while(true){
		    	  Socket cliente = servidor.accept();
		          System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
		      }
		      
		    }
		    catch(Exception e) {
		       System.out.println("Erro: " + e.getMessage());
		    }
	}
}
