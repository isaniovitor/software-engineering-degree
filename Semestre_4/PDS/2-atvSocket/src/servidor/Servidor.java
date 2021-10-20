package servidor;

import cliente.Cliente;
import cliente.GerenciadorConfiguracaoCliente;

public class Servidor {

	GerenciadorConexao gerenciadorConexao;
	public static void main(String[] args) {
		Servidor servidor = new Servidor();
		servidor.inicia();
		//Cliente cliente = new Cliente();
	}
	
	public Servidor(){}

	public void inicia(){
		GerenciadorConfiguracaoServidor configuracaoServidor = new GerenciadorConfiguracaoServidor(12345);
		gerenciadorConexao = new GerenciadorConexao(configuracaoServidor);
		this.gerenciadorConexao.disponibilizaServico();
	}
}
