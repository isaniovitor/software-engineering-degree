package barber;

import java.util.Random;

public class Barbearia implements Runnable{

	private int cadeiraDeEspera; 
	boolean cadeiraOcupada = false; 
	int[] clientes;
	boolean barbeiroDorme = false;
	private String nome;
	private int cliNovos;
	int nClientes = 0;

	// Inicializar o barbeiro (construtor)
	public Barbearia(String nome, int cadeiraEspera, int clientes){
		cliNovos = clientes; // Inicializa o número aleatorio de clientes
		this.nome = nome; // Nome do Barbeiro
		this.cadeiraDeEspera = cadeiraEspera; // Cadeiras de espera

		System.out.println("O barbeiro " + nome + " chegou no salão.");
	}

	// Inicializar clientes
	public void Clientes() {
		Random r = new Random(); //Gera número aleatorio
		nClientes = r.nextInt(cliNovos) + 1; 
		clientes = new int[nClientes];

		// Preenche o vetor com o número do cliente
		for(int i = 0; i < clientes.length; i++) {
			clientes[i] = i;
		}
	}

	// Se não há clientes, barbeiro dorme
	public void BarbeiroDorme() throws InterruptedException{

		System.out.println("Não há clientes no salão da barbearia "+nome+".");
		System.out.println("Barbeiro "+nome+" está esperando possíveis clientes.\n");
		Thread.sleep(2000); // Thread espera 

		// Cria clientes
		Clientes();
	}

	// Se há clientes, barbeiro atende
	public void BarbeiroAtende() throws InterruptedException{
		if(nClientes >= 1 && cadeiraOcupada == false) {
			System.out.println("Entrou " +nClientes+" cliente(s) no salão.");
		}else { // Cliente esperando
			System.out.println("Existem "+nClientes+" cliente(s) esperando atendimento.");
		}

		// Atender cliente
		System.out.println("Não há sessão disponível no momento. "+nome);
		nClientes--; // Atendido
		System.out.println("Um cliente está sendo atendido pelo barbeiro "+nome);
		cadeiraOcupada = true;

		Thread.sleep(1000); // Espera terminar

		if(nClientes > cadeiraDeEspera) { // Número de clientes > número de cadeiras
			int cli = nClientes - cadeiraDeEspera; // Clientes que vão embora
			nClientes = nClientes - cli; // Clientes que sobraram

			// Zera posições
			for(int i = 0; i < clientes.length-1; i++) {
				clientes[i] = 0;
			}

			// Atualiza clientes
			for(int j = 0; j < nClientes; j++) {
				clientes[j] = j+1;
			}

			System.out.println(nClientes+" clientes estão esperando.");
			System.out.println(cli + " foram embora.");
		}

		System.out.println("Um cliente realizou sua sessão.");

		if(nClientes == 0) {
			System.out.println("A sessão "+ nome + " está livre\n");
			cadeiraOcupada = false;
		}
	}

	//metodo de execução da thread
	@Override
	public void run() {
		while(true) { //Loop
			if(nClientes == 0) { //Se não há clientes, dorme
				try {
					BarbeiroDorme(); // Espera
				}catch(InterruptedException ex) {
					System.out.println(ex);
				}
			}else { //Se há clientes, atende
				try {
					BarbeiroAtende(); // Atende
				} catch (InterruptedException ex) {
					System.out.println(ex);
				}
			}
		}

	}

	//Principal
	public static void main(String[] args) {

		Barbearia barbeiro = new Barbearia("Jezonel", 2, 5);
		Thread threadBarbeiro = new Thread(barbeiro);
		threadBarbeiro.start();

	}
}

