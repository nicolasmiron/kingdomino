package main.java.unlam.kingdomino;

public class Tablero {
	
	private Bioma[][] tablero;
	
	public Tablero() {
		tablero = new Bioma[9][9];
		tablero[4][4] = Bioma.CASTILLO;
	}
	
	public void colocarFicha(Ficha ficha, Posicion posBiomaIzq, Posicion posBiomaDer) {
		if(posicionValida(ficha, posBiomaIzq, posBiomaDer)) {			
			tablero[posBiomaIzq.getX()][posBiomaIzq.getY()] = ficha.getBiomaIzq();
			tablero[posBiomaDer.getX()][posBiomaDer.getY()] = ficha.getBiomaDer();
		}
	}

	private boolean posicionValida(Ficha ficha, Posicion posBiomaIzq, Posicion posBiomaDer) {
		return false;
	}
	
	public int getPuntuacion() {
		return 0;
	}
}
