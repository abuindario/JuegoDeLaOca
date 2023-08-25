package com.darioabuin;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static Jugador jugadas(Jugador j) {
		int nuevaCasilla = j.lanzarDados(j.getCasilla());
		j.setCasilla(nuevaCasilla);
		if (j.getCasilla() >= 63) {
			int casillasDeMas = j.getCasilla() - 63;
			j.setCasilla(63 - casillasDeMas);
		}
		System.out.println(j.getNombre() + " avanza a la casilla: " + j.getCasilla());
		return j;
	}

	public static Jugador comprobarCasillaOca(Jugador jug) {
		// Array de casillas de la Oca
		int[] casillasOca = new int[15];
		casillasOca[0] = 1;
		casillasOca[1] = 5;
		casillasOca[2] = 9;
		casillasOca[3] = 14;
		casillasOca[4] = 18;
		casillasOca[5] = 23;
		casillasOca[6] = 27;
		casillasOca[7] = 32;
		casillasOca[8] = 36;
		casillasOca[9] = 41;
		casillasOca[10] = 45;
		casillasOca[11] = 50;
		casillasOca[12] = 54;
		casillasOca[13] = 59;
		casillasOca[14] = 63;

		// Comprobar si el jugador está en una casilla de la Oca
		Oca: for (int i = 0; i < casillasOca.length; i++) {
			if (casillasOca[i] == jug.getCasilla()) {

				// try/catch por si el jugador ha alcanzado la casilla 63
				try {
					System.out.println(jug.getNombre() + " ha caído en la Oca!");

					// El jugador avanza hasta la siguiente casilla de la Oca
					int casillaJugador = casillasOca[i + 1];
					jug.setCasilla(casillaJugador);
					System.out.println(jug.getNombre() + " se encuentra ahora en la casilla " + casillaJugador);
					// Si el jugador avanza hasta la casilla 63, interrumpir la ejecucion
					if (jug.getCasilla() == 63) {
						System.out.println(jug.getNombre() + " ha ganado!");
						break Oca;
					}
					// El jugador tiene que volver a tirar
					System.out.println("De Oca a Oca y tiro porque me toca!");
					System.out.println("*** Introduce cualquier caracter para continuar");
					Scanner scanner = new Scanner(System.in);
					scanner.next();
					jug.setCasilla(casillaJugador);
					jugadas(jug);
				} catch (IndexOutOfBoundsException e) {
					System.out.println(jug.getNombre() + " ha ganado!");
				}
			}
		}
		return jug;
	}

	public static Jugador comprobarCasillaPuente(Jugador jug) {

		do {
			// Comprobar si el jugador ha caido en el primer puente
			if (jug.getCasilla() == 6) {
				jug.setCasilla(12);
				System.out.println(jug.getNombre() + " ha caido en una casilla puente!");
				System.out.println(jug.getNombre() + " se encuentra ahora en la casilla " + jug.getCasilla());
				System.out.println("De puente en puente y tiro porque me lleva la corriente!");
				System.out.println("*** Introduce cualquier caracter para continuar");
				Scanner scanner = new Scanner(System.in);
				scanner.next();
				jugadas(jug);
			}
			// Comprobar si el jugador ha caido en el segundo puente
			else if (jug.getCasilla() == 12) {
				jug.setCasilla(6);
				System.out.println(jug.getNombre() + " ha caido en una casilla puente!");
				System.out.println(jug.getNombre() + " se encuentra ahora en la casilla " + jug.getCasilla());
				System.out.println("De puente en puente y tiro porque me lleva la corriente!");
				System.out.println("*** Introduce cualquier caracter para continuar");
				Scanner scanner = new Scanner(System.in);
				scanner.next();
				jugadas(jug);
			}
		}
		// Bucle do while por si el jugador despues de caer en la casilla 12, va a la 6
		// y vuelve a caer en la 12
		while (jug.getCasilla() == 12);
		return jug;
	}

	public static Jugador comprobarCasillaDado(Jugador jug) {
		do {
			// Comprobar si el jugador ha caido en un dado
			if (jug.getCasilla() == 53) {
				jug.setCasilla(26);
				System.out.println(jug.getNombre() + " ha caido en una casilla dados!");
				System.out.println(jug.getNombre() + " se encuentra ahora en la casilla " + jug.getCasilla());
				System.out.println("De dado a dado y tiro porque me ha tocado!");
				System.out.println("*** Introduce cualquier caracter para continuar");
				Scanner scanner = new Scanner(System.in);
				scanner.next();
				jugadas(jug);
			}
			// Comprobar si el jugador ha caido en un dado
			else if (jug.getCasilla() == 26) {
				jug.setCasilla(53);
				System.out.println(jug.getNombre() + " ha caido en una casilla dados!");
				System.out.println(jug.getNombre() + " se encuentra ahora en la casilla " + jug.getCasilla());
				System.out.println("De dado a dado y tiro porque me ha tocado!");
				System.out.println("*** Introduce cualquier caracter para continuar");
				Scanner scanner = new Scanner(System.in);
				scanner.next();
				jugadas(jug);
			}
			// Bucle do while por si el jugador despues de caer en la casilla 53, va a la 26
			// y vuelve a caer en la 53
		} while (jug.getCasilla() == 26);
		return jug;
	}

	public static Jugador comprobarCasillaPosada(Jugador jug) {
		if (jug.getCasilla() == 19) {
			jug.setTurnosEspera(2);
			System.out.println(jug.getNombre() + " ha caido en la posada!");
			System.out.println(
					jug.getNombre() + " debera permanecer en esta casilla " + jug.getTurnosEspera() + " turnos");
		}
		return jug;
	}

	public static Jugador comprobarCasillaPozoDeBronce(Jugador jug) {
		if (jug.getCasilla() == 31) {
			jug.setTurnosEspera(3);
			System.out.println(jug.getNombre() + " ha caido en el pozo de bronce!");
			System.out.println(
					jug.getNombre() + " debera permanecer en esta casilla " + jug.getTurnosEspera() + " turnos");
		}
		return jug;
	}

	public static Jugador comprobarCasillaMuerte(Jugador jug) {
		if (jug.getCasilla() == 58) {
			System.out.println(jug.getNombre() + " ha caido en la muerte!");
			System.out.println(jug.getNombre() + " debera empezar desde el principio");
			jug.setCasilla(0);
		}
		return jug;
	}

	public static Jugador comprobarCasillaCarcel(Jugador jug) {
		if (jug.getCasilla() == 52) {
			jug.setTurnosEspera(3);
			System.out.println(jug.getNombre() + " ha caido en la carcel!");
			System.out.println(
					jug.getNombre() + " debera permanecer en esta casilla " + jug.getTurnosEspera() + " turnos");
		}
		return jug;
	}

	public static Jugador comprobarCasillaLaberinto(Jugador jug) {
		jug.setCasilla(30);
		System.out.println(jug.getNombre() + " ha caido en el laberinto!");
		System.out.println(jug.getNombre() + " debera retroceder hasta la casilla " + jug.getCasilla());
		return jug;
	}

	public static Jugador crearJugador(int i) {
		String nombre = "";
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Introduce el nombre del jugador " + (i + 1) + ":");
			nombre = scanner.nextLine();
		} while (nombre.trim().equals(""));
		Jugador jug = new Jugador(nombre);
		return jug;
	}

	public static void main(String[] args) {
		// Nueva partida
		System.out.println("** Bienvenidos al Juego de la Oca! **");

		// Creacion de la lista de jugadores
		ArrayList<Jugador> jugadores = new ArrayList<>();

		// Creacion de jugadores
		System.out.println("Cuantas personas van a jugar?");
		int numJugadores = 0;
		Scanner scanner;
		// Evitar que se pasen caracteres que no sean de tipo int al escoger el numero
		// de jugadores
		do {
			scanner = new Scanner(System.in);
			try {
				numJugadores = scanner.nextInt();
				// Evitar que numJugadores no este comprendido entre 1 y 4
				if (numJugadores <= 0 || numJugadores > 4) {
					numJugadores = 0;
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				numJugadores = 0;
				System.out.println("Introduce un numero entre 1 y 4");
			}
		} while (numJugadores == 0);

		// Crear Jugadores
		for (int i = 0; i < numJugadores; i++) {
			Jugador jug = crearJugador(i);
			jugadores.add(jug);
		}

		// Juego
		boolean juegoActivo = true;
		do {
			Juego: for (Jugador jug : jugadores) {

				// Mensaje de informacion de a quien le toca jugar
				System.out.println("");
				System.out.println("***__________________***");
				System.out.println("");
				System.out.println("Ahora es el turno de: " + jug.getNombre() + ", que se encuentra en la casilla "
						+ jug.getCasilla());
				System.out.println("*** Introduce cualquier caracter para continuar");
				scanner.next();
				System.out.println(" ");

				// Comprobar si el jugador tiene turno activo
				if (jug.getTurnosEspera() == 0) {
					// Se ejecuta el turno del jugador
					jugadas(jug);
				} else {
					int turnosEsperaRestantes = jug.getTurnosEspera();
					jug.setTurnosEspera(turnosEsperaRestantes - 1);
					System.out.println(jug.getNombre() + " debera permanecer en esta casilla " + jug.getTurnosEspera()
							+ " turnos mas");
					continue Juego;
				}

				// Definimos las casillas con condiciones especiales
				ArrayList<Integer> casillasEspeciales = new ArrayList<Integer>();
				casillasEspeciales.add(1);
				casillasEspeciales.add(5);
				casillasEspeciales.add(6);
				casillasEspeciales.add(9);
				casillasEspeciales.add(12);
				casillasEspeciales.add(14);
				casillasEspeciales.add(18);
				casillasEspeciales.add(19);
				casillasEspeciales.add(23);
				casillasEspeciales.add(26);
				casillasEspeciales.add(27);
				casillasEspeciales.add(31);
				casillasEspeciales.add(32);
				casillasEspeciales.add(36);
				casillasEspeciales.add(41);
				casillasEspeciales.add(42);
				casillasEspeciales.add(45);
				casillasEspeciales.add(50);
				casillasEspeciales.add(53);
				casillasEspeciales.add(52);
				casillasEspeciales.add(54);
				casillasEspeciales.add(58);
				casillasEspeciales.add(59);

				boolean esUnaCasillaEspecial = true;
				do {
					// Comprobar si la casilla del jugador es una casilla de la Oca y ejecutar
					// jugada
					comprobarCasillaOca(jug);

					// Comprobar si la casilla del jugador es una casilla puente y ejecutar jugada
					comprobarCasillaPuente(jug);

					// Comprobar si la casilla del jugador es una casilla dado y ejecutar juagada
					comprobarCasillaDado(jug);

					// Comprobar si la casilla del jugador es la posada
					comprobarCasillaPosada(jug);

					// Comprobar si la casilla del jugador es la muerte
					comprobarCasillaMuerte(jug);

					// Comprobar si la casilla del jugador es el pozo de bronce
					comprobarCasillaPozoDeBronce(jug);

					// Comprobar si la casilla del jugador es la carcel
					comprobarCasillaCarcel(jug);

					// Si el jugador ha caido en una casilla en la que tiene que permanecer algun
					// turno
					if (jug.getTurnosEspera() != 0) {
						continue Juego;
					}

					// Comprobar si el jugador sigue en una casilla especial
					esUnaCasillaEspecial = casillasEspeciales.contains(jug.getCasilla());
				} while (esUnaCasillaEspecial);

				// Comprobar si el jugador ha llegado al fin de la partida (casilla 63)
				if (jug.getCasilla() == 63) {
					juegoActivo = false;
					break;
				}
			}
		} while (juegoActivo);
	}
}

class Jugador {
	private String nombre;
	// Casilla inicial: 0
	private int casilla = 0;
	// De inicio no tiene turnos que permanecer en una casilla
	private int turnosEspera = 0;

	public Jugador() {
	}

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCasilla() {
		return casilla;
	}

	public void setCasilla(int casilla) {
		this.casilla = casilla;
	}

	public int getTurnosEspera() {
		return turnosEspera;
	}

	public void setTurnosEspera(int turnosEspera) {
		this.turnosEspera = turnosEspera;
	}

	public int lanzarDados(int casillaActual) {
		// En la siguiente linea obtenemos un numero entre 2 y 12 que simula la tirada
		// de dados
		int tirada = (int) (2 + Math.random() * 11);
		System.out.println("Los dados suman " + tirada);
		// En la siguiente linea sumamos la tirada a la casilla del jugador
		int nuevaCasilla = casillaActual + tirada;

		return nuevaCasilla;
	}

}
