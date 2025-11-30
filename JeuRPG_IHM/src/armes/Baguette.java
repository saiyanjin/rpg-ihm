package armes;

public class Baguette extends Arme {
	
	public Baguette() {
		super("Baguette magique", 8, 70); 
	}
    
	public void effetSpecial() {
		System.out.println("Boule de feu lancé !"); 
	}
    
}