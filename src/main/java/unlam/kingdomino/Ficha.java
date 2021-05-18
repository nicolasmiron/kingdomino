package main.java.unlam.kingdomino;

public class Ficha {
	private Bioma biomaIzq;
	private Bioma biomaDer;
	
	public Ficha() {
		this.biomaIzq = Bioma.randomBioma();
		this.biomaDer = Bioma.randomBioma();
	}
}
