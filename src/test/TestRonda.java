package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.java.unlam.kingdomino.Ficha;
import main.java.unlam.kingdomino.Jugador;
import main.java.unlam.kingdomino.Partida;

public class TestRonda {

	@Test
    public void ordenarJugadoresPrimeraRonda() {
        Partida p1 = new Partida();
        Jugador j1 = new Jugador("Federico");
        Jugador j2 = new Jugador("Tomas");
        Jugador j3 = new Jugador("Lucas");
        Jugador j4 = new Jugador("Joel");
        p1.agregarJugador(j1);
        p1.agregarJugador(j2);
        p1.agregarJugador(j3);
        p1.agregarJugador(j4);
        
        System.out.println("Ordenar Jugadores Primera Ronda");
        System.out.println(p1.getJugadores());
        p1.ordenarJugadores();
        System.out.println(p1.getJugadores());
    }
    
    @Test
    public void ordenarJugadoresNoPrimeraRonda() {
        Partida p1 = new Partida();
        Jugador j1 = new Jugador("Federico");
        Jugador j2 = new Jugador("Tomas");
        Jugador j3 = new Jugador("Lucas");
        Jugador j4 = new Jugador("Joel");
        p1.agregarJugador(j1);
        p1.agregarJugador(j2);
        p1.agregarJugador(j3);
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
        Jugador j1 = new Jugador("Federico");
        Jugador j2 = new Jugador("Tomas");
        Jugador j3 = new Jugador("Lucas");
        Jugador j4 = new Jugador("Joel");
        p1.agregarJugador(j1);
        p1.agregarJugador(j2);
        p1.agregarJugador(j3);
        p1.agregarJugador(j4);
        p1.generarMazo();
        List<Ficha> fichas = p1.getFichasParaTurno();
        j1.elegirFicha(fichas, 2);
        assertEquals(fichas.get(2), j1.getFichaActual());
        
        j1.elegirFicha(fichas, 3);
        assertEquals(fichas.get(3), j1.getFichaActual());
    }

}
