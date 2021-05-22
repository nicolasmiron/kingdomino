package test;

import static org.junit.Assert.*;



import org.junit.Test;
import main.java.unlam.kingdomino.Jugador;
import main.java.unlam.kingdomino.Partida;


public class TestPartida {

	  
		@Test
	    public void iniciarPartidaDosJugadores() {
	        Partida p1 = new Partida();
	        Jugador j1 = new Jugador("Federico");
	        Jugador j2 = new Jugador("Tomas");
	        p1.agregarJugador(j1);
	        p1.agregarJugador(j2);
	        assertEquals(true, p1.cantJugadoresOk());
	    }
		
		@Test
	    public void iniciarPartidaTresJugadores() {
	        Partida p1 = new Partida();
	        Jugador j1 = new Jugador("Federico");
	        Jugador j2 = new Jugador("Tomas");
	        Jugador j3 = new Jugador("Lucas");
	        Jugador j4 = new Jugador("Joel");
	        p1.agregarJugador(j1);
	        p1.agregarJugador(j2);
	        p1.agregarJugador(j3);
	        p1.agregarJugador(j4);
	        assertEquals(true, p1.cantJugadoresOk());
	    }
	
		@Test
	    public void iniciarPartidaCuatroJugadores() {
	        Partida p1 = new Partida();
	        Jugador j1 = new Jugador("Federico");
	        Jugador j2 = new Jugador("Tomas");
	        Jugador j3 = new Jugador("Lucas");
	        Jugador j4 = new Jugador("Joel");
	        p1.agregarJugador(j1);
	        p1.agregarJugador(j2);
	        p1.agregarJugador(j3);
	        p1.agregarJugador(j4);
	        assertEquals(true, p1.cantJugadoresOk());
	    }

	    @Test
	    public void noIniciarPartida() {
	        Partida p1 = new Partida();
	        Jugador j1 = new Jugador("Nicolas");
	        p1.agregarJugador(j1);
	        assertEquals(false, p1.cantJugadoresOk());
	    }
	    
	    @Test
	    public void generarMazo() {
	        Partida p1 = new Partida();
	        Jugador j1 = new Jugador("Federico");
	        Jugador j2 = new Jugador("Tomas");
	        Jugador j3 = new Jugador("Lucas");
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
}


