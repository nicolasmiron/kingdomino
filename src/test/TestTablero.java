package test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import main.java.unlam.kingdomino.Ficha;
import main.java.unlam.kingdomino.Jugador;
import main.java.unlam.kingdomino.Partida;
import main.java.unlam.kingdomino.Posicion;
import main.java.unlam.kingdomino.Ronda;

public class TestTablero {

	@Test
    public void verTableroPorJugador() {
        Partida p1 = new Partida();
        Jugador j1 = new Jugador("Nicolas");
        Jugador j2 = new Jugador("Gustavo");
        p1.agregarJugador(j1);
        p1.agregarJugador(j2);

        j1.mostrarTablero(j2);
        System.out.println(" ");
    }
    
    @Test
    public void colocarFichasEnTablero() {
        Partida p1 = new Partida();
        Jugador j1 = new Jugador("Nicolas");
        Jugador j2 = new Jugador("Gustavo");
        p1.agregarJugador(j1);
        p1.agregarJugador(j2);

        p1.generarMazo();
        
        List<Ficha> fichas = p1.getFichasParaTurno();
        j1.elegirFicha(fichas, 1);
        j1.colocarFichaPreviaEnTablero(j1.getFichaActual(), new Posicion(5,4), new Posicion(6, 4));
        j1.colocarFichaPreviaEnTablero(j1.getFichaActual(), new Posicion(6,5), new Posicion(5, 5));
        
        j1.mostrarTablero(j1);
        System.out.println(" ");
    }
    
    @Test
    public void inputJugadorEleccionFicha() {
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
    public void inputJugadorPosicionesFicha() {
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
