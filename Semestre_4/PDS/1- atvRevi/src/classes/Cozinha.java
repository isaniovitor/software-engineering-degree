package classes;

public class Cozinha {

    public Cozinha() {
    }

    public void avisoPedidoPronto(Mesa mesa){
        System.out.println("Pedido feito");
    }

    public void fazerComida(Mesa mesa){
        for (Produto produto : mesa.pedidos.keySet()) {
            try {
               //1s para cada pedido
               System.out.println(produto.getNome() + " sendo preparado");
               Thread.sleep(3000);

               avisoPedidoPronto(mesa);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }   
        }
    }
}