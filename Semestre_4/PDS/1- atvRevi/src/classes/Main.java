package classes;

public class Main {
// private int num = 1;

    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        Caixa caixa = new Caixa();
        Cozinha cozinha = new Cozinha();
        Garcom garcom = new Garcom();

        mesa.abreMesa();
        mesa.addPedidos(new Produto("Arroz"), 2);
        mesa.addPedidos(new Produto("Carne"), 2);
        mesa.addPedidos(new Produto("Salada"), 1);

        garcom.addPedidoCozinha();

        cozinha.fazerComida(mesa);

        caixa.solicitaFechamentoConta(mesa);
        caixa.imprimeConta(mesa);
        caixa.confirmaPagamento(mesa);
        caixa.calculaTroco(mesa);

        mesa.fechaMesa();
    }
}
