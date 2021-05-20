package main.java.unlam.kingdomino;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ronda {

	public static void nuevaRonda(List<Jugador> jugadores, List<Ficha> fichas) {
		for (Jugador jugador : jugadores) {
			if(jugador.getFichaActual() != null) {				
				jugador.colocarFichaPreviaEnTablero();
			}
			int nro = inputJugador();
			jugador.elegirFicha(fichas, nro - 1);
		}
	}

	private static int inputJugador() {
		System.out.println("Elegir un nro de ficha: ");
		return new Scanner(System.in).nextInt();
	}			
}
