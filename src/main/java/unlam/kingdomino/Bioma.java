package main.java.unlam.kingdomino;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Bioma {
	BOSQUE,
	MONTA�A,
	LAGO,
	TRIGAL;
	
	private int cantCoronas;
	
	Bioma() {
		this.cantCoronas = new Random().nextInt(3);
	}
	
	private static final List<Bioma> VALUES =
		    Collections.unmodifiableList(Arrays.asList(values()));
	
	public static Bioma randomBioma() {
		return VALUES.get(new Random().nextInt(VALUES.size()));
	}

	public int getCantCoronas() {
		return cantCoronas;
	}
	
}
