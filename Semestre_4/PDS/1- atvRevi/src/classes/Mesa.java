package classes;

import java.util.HashMap;

public class Mesa {
	boolean isTableOpen = false;
	HashMap<Produto, Integer> pedidos = new HashMap<>();

	public Mesa() {
	}

	public void abreMesa(){
		setIsTableOpen(true);
		System.out.println("Mesa ocupada");
	}

	public void fechaMesa(){
		setIsTableOpen(false);
		System.out.println("Mesa livre");
	}

	public void addPedidos(Produto pedido, int qtd){
		pedidos.put(pedido, qtd);
		System.out.println("Pedido add");
	}

	public HashMap<Produto,Integer> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(HashMap<Produto,Integer> pedidos) {
		this.pedidos = pedidos;
	}

	public boolean getIsTableOpen() {
		return this.isTableOpen;
	}

	public void setIsTableOpen(boolean isTableOpen) {
		this.isTableOpen = isTableOpen;
	}
}
