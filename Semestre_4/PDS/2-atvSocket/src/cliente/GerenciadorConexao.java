package cliente;

import java.net.Socket;

public class GerenciadorConexao {
	GerenciadorConfiguracaoCliente configuracaoCliente;
	
	public GerenciadorConexao (GerenciadorConfiguracaoCliente configuracaoCliente){
		this.configuracaoCliente = configuracaoCliente;
		
	}

	public void estabeleConexao(){
		try {
		      Socket cliente = new Socket(configuracaoCliente.getHost(),configuracaoCliente.getPorta());
		      System.out.println("Conexao estabelecida!");
		      //ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
		      //entrada.close();
		      //System.out.println("Conex�o encerrada");
		      while(true){
		    	  
		      }
		    }
		    catch(Exception e) {
		      System.out.println("Erro: " + e.getMessage());
		      System.out.println("Conexao Falhou!");
		    }
	}
}
