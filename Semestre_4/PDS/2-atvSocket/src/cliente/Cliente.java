package cliente;
import cliente.GerenciadorConexao;
public class Cliente {

	GerenciadorConexao gerenciadorConexao;
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
	}

	public Cliente(){
		GerenciadorConfiguracaoCliente configuracaoCliente = new GerenciadorConfiguracaoCliente("host",12345);
		gerenciadorConexao = new GerenciadorConexao(configuracaoCliente);
		this.gerenciadorConexao.estabeleConexao();
	}
}
