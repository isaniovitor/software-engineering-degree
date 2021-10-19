package classes;

public class Produto {
    private int preco;
    private String nome;


    public Produto(String nome) {
        this.nome = nome;
    }


    public int getPreco() {
        return this.preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}