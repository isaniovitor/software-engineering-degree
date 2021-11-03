public class Troca {
	public static void troca(Indio caciqueQuePediu, Tribo tribo1, Animal 
			animal1, Tribo tribo2, Animal animal2){ 
		tribo1.removeAnimal(caciqueQuePediu, animal1); 
		tribo1.adicionaAnimalNaTribo(caciqueQuePediu, animal2.getNome(), animal2.getNome()); 
		tribo2.removeAnimal(caciqueQuePediu, animal2); 
		tribo2.adicionaAnimalNaTribo(caciqueQuePediu, animal1.getNome(), animal1.getNome()); 
	} 
}
