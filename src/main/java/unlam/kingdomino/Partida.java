package main.java.unlam.kingdomino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Partida {
	private List<Ficha> mazo;
	private List<Jugador> jugadores;
	private boolean primerTurno = true;
	
	public Partida() {
		this.mazo = new ArrayList<>();
		this.jugadores = new ArrayList<>();
	}
	
	public void iniciarPartida() {
		if(cantJugadoresOk()) {
			generarMazo();
			while(!mazo.isEmpty()) {
				ordenarJugadores();
				Ronda.nuevaRonda(jugadores, getFichas());
			}
			finalizarPartida();
		} else
			System.out.println("Cantidad de jugadores no valida.");
	}
	
	private void ordenarJugadores() {
		if(primerTurno) {
			Collections.shuffle(jugadores);
			primerTurno = false;
		} else {
			Collections.sort(jugadores, (j1, j2) -> {
				return j1.getFichaActual().getNro().compareTo(j2.getFichaActual().getNro());
			});			
		}
	}

	private void setUpPartida() {
//		List<Ficha> fichasSetUp = getFichas();
//		for (Jugador jugador : jugadores) {
//			System.out.println("Elegir un nro de ficha: ");
//			Scanner scanner = new Scanner(System.in);
//			int nro = scanner.nextInt();
//			jugador.elegirFicha(fichasSetUp, nro - 1);
//		}
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

	private void generarMazo() {
		for(int i = 0; i < jugadores.size() * 12; i++) {
			mazo.add(new Ficha(i));
		}
	}
}
