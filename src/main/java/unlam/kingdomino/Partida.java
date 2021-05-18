package main.java.unlam.kingdomino;

import java.util.List;
import java.util.Set;

public class Partida {
	private List<Ficha> mazo;
	private Set<Jugador> jugadores;
	
	public Partida(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
		this.mazo = this.generarMazo();
	}

	public void iniciar() {
		this.setUpPartida();
		while(!mazo.isEmpty()) {
			Ronda.nuevaRonda(jugadores, getFichasParaTurno());
		}
		finalizarPartida();
	}
	
	private void finalizarPartida() {
		// TODO Auto-generated method stub
		
	}

	private List<Ficha> getFichasParaTurno() {
		// TODO Auto-generated method stub
		return null;
	}

	private void setUpPartida() {
		// TODO Auto-generated method stub
		
	}

	private List<Ficha> generarMazo() {
		// TODO Auto-generated method stub
		return null;
	}
}
