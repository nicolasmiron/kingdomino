package main.java.unlam.kingdomino;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Ronda {

	public static void nuevaRonda(List<Jugador> jugadores, List<Ficha> fichas) {
		generarOrdenDeRonda(jugadores);
		for (Jugador jugador : jugadores) {
			Scanner scanner = new Scanner(System.in);
			int nro = scanner.nextInt();
			jugador.colocarFichaEnTablero();
			jugador.elegirFicha(fichas, nro);
		}
	}

	private static void generarOrdenDeRonda(List<Jugador> jugadores) {
		Collections.sort(jugadores, (j1, j2) -> {
			return j1.getFichaActual().getNro().compareTo(j2.getFichaActual().getNro());
		});
	}

}
