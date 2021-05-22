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
			System.out.println("Posición valida.");
		} else {
			System.out.println("Posición no valida o descarta.");
		}
	}

	private boolean posicionValida(Ficha ficha, Posicion posBiomaIzq, Posicion posBiomaDer) {
		return posicionVacia(posBiomaIzq, posBiomaDer) && existeBiomaAdyacente(ficha, posBiomaIzq, posBiomaDer);
	}

	public boolean existeBiomaAdyacente(Ficha ficha, Posicion posBiomaIzq, Posicion posBiomaDer) {
		boolean pieza1Arriba = false;
		boolean pieza1Abajo = false;
		boolean pieza1Izq = false;
		boolean pieza1Der = false;

		boolean pieza2Arriba = false;
		boolean pieza2Abajo = false;
		boolean pieza2Izq = false;
		boolean pieza2Der = false;
		
		if(tablero[posBiomaIzq.getX() - 1][posBiomaIzq.getY()] != null) {
			pieza1Arriba = tablero[posBiomaIzq.getX() - 1][posBiomaIzq.getY()].name() == ficha.getBiomaIzq().name() ||
			tablero[posBiomaIzq.getX() - 1][posBiomaIzq.getY()].name() == Bioma.CASTILLO.toString();
		}
		if(tablero[posBiomaIzq.getX()][posBiomaIzq.getY() - 1] != null) {
			pieza1Izq = tablero[posBiomaIzq.getX()][posBiomaIzq.getY() - 1].name() == ficha.getBiomaIzq().name() ||
			tablero[posBiomaIzq.getX()][posBiomaIzq.getY() - 1].name() == Bioma.CASTILLO.toString();
		}
		if(tablero[posBiomaIzq.getX() + 1][posBiomaIzq.getY()] != null) {
			pieza1Abajo = tablero[posBiomaIzq.getX() + 1][posBiomaIzq.getY()].name() == ficha.getBiomaIzq().name() ||
			tablero[posBiomaIzq.getX() + 1][posBiomaIzq.getY()].name() == Bioma.CASTILLO.toString();
		}
		if(tablero[posBiomaIzq.getX()][posBiomaIzq.getY() + 1] != null) {
			pieza1Der = tablero[posBiomaIzq.getX()][posBiomaIzq.getY() + 1].name() == ficha.getBiomaIzq().name() ||
			tablero[posBiomaIzq.getX()][posBiomaIzq.getY() + 1].name() == Bioma.CASTILLO.toString();
		}
		
		if(tablero[posBiomaDer.getX() - 1][posBiomaDer.getY()] != null) {
			pieza2Arriba = tablero[posBiomaDer.getX() - 1][posBiomaDer.getY()].name() == ficha.getBiomaDer().name() ||
			tablero[posBiomaDer.getX() - 1][posBiomaDer.getY()].name() == Bioma.CASTILLO.toString();
		}
		if(tablero[posBiomaDer.getX()][posBiomaDer.getY() - 1] != null) {
			pieza2Izq = tablero[posBiomaDer.getX()][posBiomaDer.getY() - 1].name() == ficha.getBiomaDer().name() ||
			tablero[posBiomaDer.getX()][posBiomaDer.getY() - 1].name() == Bioma.CASTILLO.toString();
		}
		if(tablero[posBiomaDer.getX() + 1][posBiomaDer.getY()] != null) {
			pieza2Abajo = tablero[posBiomaDer.getX() + 1][posBiomaDer.getY()].name() == ficha.getBiomaDer().name() ||
			tablero[posBiomaDer.getX() + 1][posBiomaDer.getY()].name() == Bioma.CASTILLO.toString();
		}
		if(tablero[posBiomaDer.getX()][posBiomaDer.getY() + 1] != null) {
			pieza2Der = tablero[posBiomaDer.getX()][posBiomaDer.getY() + 1].name() == ficha.getBiomaDer().name() ||
			tablero[posBiomaDer.getX()][posBiomaDer.getY() + 1].name() == Bioma.CASTILLO.toString();
		}
		return pieza1Arriba || pieza1Abajo || pieza1Izq || pieza1Der || pieza2Arriba || pieza2Abajo || pieza2Izq || pieza2Der;
	}
	
	public boolean posicionVacia(Posicion posBiomaIzq, Posicion posBiomaDer) {
		return tablero[posBiomaIzq.getX()][posBiomaIzq.getY()] == null && tablero[posBiomaDer.getX()][posBiomaDer.getY()] == null;
	}
	
	public int getPuntuacion() {
		return 0;
	}
	
	public void mostrarTablero() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(tablero[i][j] + "\t\t");
			}
			System.out.println();
		}
	}
}
