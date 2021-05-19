package main.java.unlam.kingdomino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Partida {
	private List<Ficha> mazo;
	private List<Jugador> jugadores;
	
	public Partida() {
		this.mazo = new ArrayList<>();
		this.jugadores = new ArrayList<>();
	}
	
	public void iniciarPartida() {
		if(cantJugadoresOk()) {
			setUpPartida();
			while(!mazo.isEmpty()) {
				Ronda.nuevaRonda(jugadores, getFichas());
			}
			finalizarPartida();
		}	
	}
	
	private void setUpPartida() {
		this.desordenarJugadores();
		this.generarMazo();
		List<Ficha> fichasSetUp = getFichas();
		for (Jugador jugador : jugadores) {
			Scanner scanner = new Scanner(System.in);
			int nro = scanner.nextInt();
			jugador.elegirFicha(fichasSetUp, nro);
		}
	}

	private boolean cantJugadoresOk() {
		return jugadores.size() >= 2 && jugadores.size() <= 4;
	}

	public void agregarJugador(Jugador jugador) {
		if(jugadores.size() < 4) {
			jugadores.add(jugador);
		}
	}

	private void finalizarPartida() {
		this.calcularGanador();
	}

	private Jugador calcularGanador() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Ficha> getFichas() {
		List<Ficha> fichas = new ArrayList<>();
		for(int i = 0; i < jugadores.size(); i++) {
			fichas.add(mazo.remove(new Random().nextInt(mazo.size())));
		}
		Collections.sort(fichas, (f1, f2) -> {
			return f1.getNro().compareTo(f2.getNro());
		});
		return fichas;
	}

	private void desordenarJugadores() {
		Collections.shuffle(jugadores);
	}

	private void generarMazo() {
		for(int i = 0; i < jugadores.size() * 12; i++) {
			mazo.add(new Ficha(i));
		}
	}
}
