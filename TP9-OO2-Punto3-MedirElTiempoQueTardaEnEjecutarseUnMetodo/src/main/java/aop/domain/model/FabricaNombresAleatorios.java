package aop.domain.model;

import java.util.Random;

public class FabricaNombresAleatorios {

	private static final String LETRAS = "abcdefghijklmnopqrstuvwxyz";
	private Random random;
	private int longitud;

	public FabricaNombresAleatorios() {
		random = new Random();
//        this.longitud = longitud;
		this.longitud = random.nextInt(10);
	}

	public String generarNombreAleatorio() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < longitud; i++) {
			int indice = random.nextInt(LETRAS.length());
			char letra = LETRAS.charAt(indice);
			sb.append(letra);
		}
		return sb.toString();
	}
}
