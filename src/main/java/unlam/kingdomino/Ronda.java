package main.java.unlam.kingdomino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ronda {
	
	public static void nuevaRonda(List<Jugador> jugadores, List<Ficha> fichas) {
		for (Jugador jugador : jugadores) {
			if(jugador.getFichaActual() != null) {
				Posicion posBiomaDer = new Posicion();
				Posicion posBiomaIzq = new Posicion();
				inputJugadorPosFicha(Arrays.asList(posBiomaIzq, posBiomaDer)); 
				jugador.colocarFichaPreviaEnTablero(jugador.getFichaActual(), posBiomaIzq, posBiomaDer);
			}
			int nro = inputJugador();
			jugador.elegirFicha(fichas, nro - 1);
		}
	}

	public static void inputJugadorPosFicha(List<Posicion> posiciones) {
		Scanner scanner = new Scanner(System.in);
		for (Posicion posicion : posiciones) {
			System.out.println("Elegir posición para Bioma:\nX: ");
			posicion.setX(scanner.nextInt());
			System.out.println("Y: ");
			posicion.setY(scanner.nextInt());		
		}
		scanner.close();
	}

	public static int inputJugador() {
		System.out.println("Elegir un nro de ficha: ");
		return new Scanner(System.in).nextInt();
	}	
}
