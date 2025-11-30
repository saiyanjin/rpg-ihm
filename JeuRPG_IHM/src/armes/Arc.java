package armes;

public class Arc extends Arme {
	
	public Arc() {
    	super("Arc", 6, 40); 
    }
    
	public void effetSpecial() {
    	System.out.println("Tir critique !"); 
	}
    
}