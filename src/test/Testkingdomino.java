package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import main.java.unlam.kingdomino.Ficha;
import main.java.unlam.kingdomino.Jugador;
import main.java.unlam.kingdomino.Partida;
import main.java.unlam.kingdomino.Posicion;
import main.java.unlam.kingdomino.Ronda;

public class Testkingdomino {

	  @Test
	    public void IniciarPartidaCuatroJugadores() {
	        Partida p1 = new Partida();
	        Jugador j1 = new Jugador("Nico");
	        Jugador j2 = new Jugador("Fede");
	        Jugador j3 = new Jugador("Tomi");
	        Jugador j4 = new Jugador("Joel");
	        p1.agregarJugador(j3);
	        p1.agregarJugador(j2);
	        p1.agregarJugador(j1);
	        p1.agregarJugador(j4);
	        assertEquals(true, p1.cantJugadoresOk());
	    }

	    @Test
	    public void NoIniciarPartida() {
	        Partida p1 = new Partida();
	        Jugador j1 = new Jugador("Nico");
	        Jugador j2 = new Jugador("Fede");
	        Jugador j3 = new Jugador("Tomi");
	        Jugador j4 = new Jugador("Joel");
	        p1.agregarJugador(j3);
	        assertEquals(false, p1.cantJugadoresOk());
	    }
	    
	    @Test
	    public void NoIniciarPartida2() {
	        Partida p1 = new Partida();
	        Jugador j1 = new Jugador("Nico");
	        Jugador j2 = new Jugador("Fede");
	        Jugador j3 = new Jugador("Tomi");
	        Jugador j4 = new Jugador("Joel");
	        p1.agregarJugador(j3);
	        p1.agregarJugador(j2);
	        assertEquals(true, p1.cantJugadoresOk());
	    }
	    
	    @Test
	    public void ordenarJugadoresPrimeraRonda() {
	        Partida p1 = new Partida();
	        Jugador j1 = new Jugador("Nico");
	        Jugador j2 = new Jugador("Fede");
	        Jugador j3 = new Jugador("Tomi");
	        Jugador j4 = new Jugador("Joel");
	        p1.agregarJugador(j3);
	        p1.agregarJugador(j2);
	        p1.agregarJugador(j1);
	        p1.agregarJugador(j4);
	        
	        System.out.println("Ordenar Jugadores Primera Ronda");
	        System.out.println(p1.getJugadores());
	        p1.ordenarJugadores();
	        System.out.println(p1.getJugadores());
	    }
	    
	    @Test
	    public void ordenarJugadoresNoPrimeraRonda() {
	        Partida p1 = new Partida();
	        Jugador j1 = new Jugador("Nico");
	        Jugador j2 = new Jugador("Fede");
	        Jugador j3 = new Jugador("Tomi");
	        Jugador j4 = new Jugador("Joel");
	        p1.agregarJugador(j3);
	        p1.agregarJugador(j2);
	        p1.agregarJugador(j1);
	        p1.agregarJugador(j4);
	        System.out.println("Ordenar Jugadores No Primera Ronda");
	        System.out.println(p1.getJugadores());
	        p1.setPrimeraRonda(false);
	        
	        p1.generarMazo();
	        List<Ficha> fichas = p1.getFichasParaTurno();
	        j1.elegirFicha(fichas, 2);
	        j2.elegirFicha(fichas, 0);
	        j3.elegirFicha(fichas, 3);
	        j4.elegirFicha(fichas, 1);
	        
	        p1.ordenarJugadores();
	        System.out.println(p1.getJugadores());
	    }
	    
	    @Test
	    public void elegirFichas() {
	        Partida p1 = new Partida();
	        Jugador j1 = new Jugador("Nico");
	        Jugador j2 = new Jugador("Fede");
	        Jugador j3 = new Jugador("Tomi");
	        Jugador j4 = new Jugador("Joel");
	        p1.agregarJugador(j3);
	        p1.agregarJugador(j2);
	        p1.agregarJugador(j1);
	        p1.agregarJugador(j4);
	        p1.generarMazo();
	        List<Ficha> fichas = p1.getFichasParaTurno();
	        j1.elegirFicha(fichas, 2);
	        assertEquals(fichas.get(2), j1.getFichaActual());
	        
	        j1.elegirFicha(fichas, 3);
	        assertEquals(fichas.get(3), j1.getFichaActual());
	    }
	    
	    @Test
	    public void generarMazo() {
	        Partida p1 = new Partida();
	        Jugador j1 = new Jugador("Nico");
	        Jugador j2 = new Jugador("Fede");
	        Jugador j3 = new Jugador("Tomi");
	        Jugador j4 = new Jugador("Joel");
	        p1.agregarJugador(j1);
	        p1.agregarJugador(j2);

	        p1.generarMazo();
	        assertEquals(24, p1.getMazo().size());
	        
	        p1.agregarJugador(j3);
	        p1.generarMazo();
	        assertEquals(36, p1.getMazo().size());
	        
	        p1.agregarJugador(j4);
	        p1.generarMazo();
	        assertEquals(48, p1.getMazo().size());
	    }
	    
	    @Test
	    public void colocarFichasEnTablero() {
	        Partida p1 = new Partida();
	        Jugador j1 = new Jugador("Nico");
	        Jugador j2 = new Jugador("Fede");
	        p1.agregarJugador(j1);
	        p1.agregarJugador(j2);

	        p1.generarMazo();
	        
	        List<Ficha> fichas = p1.getFichasParaTurno();
	        j1.elegirFicha(fichas, 1);
	        j1.colocarFichaPreviaEnTablero(j1.getFichaActual(), new Posicion(5,4), new Posicion(6, 4));
	        j1.colocarFichaPreviaEnTablero(j1.getFichaActual(), new Posicion(6,5), new Posicion(5, 5));
	        
	        j1.mostrarTablero();
	        System.out.println(" ");
	    }
	    
	    @Test
	    public void inputJugador() {
	        Partida p1 = new Partida();
	        Jugador j1 = new Jugador("Nico");
	        Jugador j2 = new Jugador("Fede");
	        p1.agregarJugador(j1);
	        p1.agregarJugador(j2);

	        p1.generarMazo();
	        
	        int n = Ronda.inputJugador();
	        System.out.println(n);
	    }
	    
	    @Test
	    public void inputJugadorPosFichas() {
	        Partida p1 = new Partida();
	        Jugador j1 = new Jugador("Nico");
	        Jugador j2 = new Jugador("Fede");
	        p1.agregarJugador(j1);
	        p1.agregarJugador(j2);

	        p1.generarMazo();
			Posicion posBiomaDer = new Posicion();
			Posicion posBiomaIzq = new Posicion();
	        Ronda.inputJugadorPosFicha(Arrays.asList(posBiomaIzq, posBiomaDer));
	        System.out.println(Arrays.asList(posBiomaIzq, posBiomaDer));
	    }
}


