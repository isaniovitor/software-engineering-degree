package classes;

public class Caixa {

    public Caixa() {
    }

    public void solicitaFechamentoConta(Mesa mesa){
        System.out.println("Fechamento solicitado");
    }

    public void imprimeConta(Mesa mesa){
        System.out.println("Sua conta deu R$ XXX,XX reais");

    }

    public void confirmaPagamento(Mesa mesa){
        System.out.println("Pagamento confirmado");

    }

     public void calculaTroco(Mesa mesa){
		System.out.println("Troco no valor de RSX,XX reais");
    }
}