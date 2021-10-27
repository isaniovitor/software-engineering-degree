public class ControladorPost {
    RepositorioPosts repositorioPosts;

    public ControladorPost(){
        repositorioPosts = new RepositorioPosts();
    }

    public void adicionaPost(String titulo, String corpo){
        repositorioPosts.adicionar(titulo, corpo);
    }
}
