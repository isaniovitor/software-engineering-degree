package cliente;

public class GerenciadorConfiguracaoCliente {
	String host;
	int porta;
	
	public GerenciadorConfiguracaoCliente(String host, int porta){
		this.host = host;
		this.porta = porta;
	}
	
	public String getHost() {
		return host;
	}

	public int getPorta() {
		return porta;
	}
}
