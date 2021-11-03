public abstract class Animal implements ITemPatas{
	private String nome; 
    int numPatas = 0; 
	public Animal(String aNome) 
	{ 
		nome = aNome; 
	}
	
	public boolean equals(Object obj){ 
		Animal a = (Animal) obj; 
		if  
		((this.nome.equalsIgnoreCase(a.nome))){ 
			return true; 
		} 
		return false; 
	} 
	public String getNome() { 
		return nome; 
	} 
	public void setNome(String nome) { 
		this.nome = nome; 
	} 
    
    public int getNumPatas(){
        return this.numPatas;
    }
}