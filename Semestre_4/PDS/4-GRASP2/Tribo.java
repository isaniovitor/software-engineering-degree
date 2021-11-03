import java.util.ArrayList;
import java.util.Iterator;

public class Tribo {
	private ArrayList<Animal> animais; 
	private ArrayList<Indio> indios; 
	private Indio cacique; 
	public Tribo() { 
		animais = new ArrayList<Animal>(); 
	} 
	public int getNumPatas() { 
		int result = 0; 
		for (Animal a : animais) { 
			result += a.getNumPatas(); 
		} 
		return result; 
	} 
	public ArrayList<Animal> getAnimais() { 
		return animais; 
	} 
	public void removeAnimal(Indio caciqueQuePediu, Animal animal) { 
        if (this.cacique.getNome().equals(caciqueQuePediu.getNome())){
		this.animais.remove(animal); 
        }
	} 
	public void addIndio(Indio indio) { 
		this.indios.add(indio); 
	} 
	public ArrayList<Indio> getIndios() { 
		return indios; 
	} 
	public void setCacique(Indio cacique) { 
		this.cacique = cacique; 
	} 
	public Indio getCacique() { 
		return this.cacique; 
	} 
    
    public boolean animalEstaNaTribo(Animal animal){ 
		boolean achou=false; 
		Iterator<Animal> it = this.animais.iterator(); 
		while ((it.hasNext()) && (!achou)){ 
			if (it.next().equals(animal)){ 
				achou = true; 
			} 
		} 
		return achou; 
	} 
    
    public void adicionaAnimalNaTribo(Indio caciqueQuePediu, 
			String nome, String especie){ 
        FabricaAnimal fabrica = new FabricaAnimal();
		if 
		(this.cacique.getNome().equals(caciqueQuePediu.getNome())){ 
			animais.add(fabrica.getAnimal(especie, nome));
		} 
	} 
        
}
