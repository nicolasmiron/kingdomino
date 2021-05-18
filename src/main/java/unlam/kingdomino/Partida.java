package main.java.unlam.kingdomino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
				Ronda.nuevaRonda(jugadores, getFichasParaTurno());
			}
			this.finalizarPartida();
		}
	}
	
	private void setUpPartida() {
		this.desordenarJugadores();
		this.generarMazo();
		List<Ficha> fichasSetUp = getFichasSetUp();
		for (Jugador jugador : jugadores) {
			jugador.elegirFicha(fichasSetUp, 0);
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

	private List<Ficha> getFichasParaTurno() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Ficha> getFichasSetUp() {
		List<Ficha> fichasSetUp = new ArrayList<>();
		for(int i = 0; i < jugadores.size(); i++) {
			fichasSetUp.add(mazo.remove(new Random().nextInt(mazo.size())));
		}
		return fichasSetUp;
	}

	private void desordenarJugadores() {
		Collections.shuffle(jugadores);
	}

	private void generarMazo() {
		for(int i = 0; i < jugadores.size() * 12; i++) {
			mazo.add(new Ficha());
		}
	}
}
