package main.java.unlam.kingdomino;

import java.util.List;

public class Jugador {
	private Ficha fichaActual;
	private Tablero tablero;

	public void elegirFicha(List<Ficha> fichasInicio, int n) {
		this.fichaActual = fichasInicio.remove(n); 
	}

	public Ficha getFichaActual() {
		return fichaActual;
	}

	public void colocarFichaPreviaEnTablero() {
		
	}

}
