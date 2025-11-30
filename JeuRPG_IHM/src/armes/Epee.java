package armes;

public class Epee extends Arme {
	
	public Epee() {
		super("Épée", 10, 50); 
	}
	
	public void effetSpecial() {
		System.out.println("Coup critique !"); 
	}
	
}