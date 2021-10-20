package servidor;

public class GerenciadorConfiguracaoServidor {

	int porta;
	
	public GerenciadorConfiguracaoServidor(int porta){
		this.porta = porta;
	}
	
	public int getPorta(){
		return this.porta;
	}
}
