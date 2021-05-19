package main.java.unlam.kingdomino;

public class Ficha {
	private Bioma biomaIzq;
	private Bioma biomaDer;
	private Integer nro;
	
	public Ficha(Integer nro) {
		this.nro = nro;
		this.biomaIzq = Bioma.randomBioma();
		this.biomaDer = Bioma.randomBioma();
	}

	public Bioma getBiomaDer() {
		return biomaDer;
	}

	public Bioma getBiomaIzq() {
		return biomaIzq;
	}

	public Integer getNro() {
		return nro;
	}
}
