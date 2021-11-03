public class FabricaAnimal{
    public Animal getAnimal(String especie, String nome){
        switch(especie){
            case "Pato": 
                return new Pato(nome);
            //break;
            case "Cachorro": 
                return new Cachorro(nome);
            //break;
            default:
                return null;
        }
    }
}