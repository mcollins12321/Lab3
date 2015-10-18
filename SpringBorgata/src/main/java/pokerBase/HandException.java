package pokerBase;

import java.util.ArrayList; 

public class HandException extends Exception{
	private ArrayList<Hand> tiedHands; 
	
	public HandException(ArrayList<Hand> hands) { 
		super("Tie between two exploded hands."); 
		this.tiedHands = hands; 
	}
	
	public ArrayList<Hand> getTiedHands() { 
		return tiedHands; 
	}
	
}
