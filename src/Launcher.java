package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase principal que lanza la aplicación.
 * 
 * @author <a href="mailto:sbl1003@alu.ubu.es"> Sergio Buil Laliena </a>
 */
public class Launcher {

	/**
	 * Método main en el que se pide por teclado el número de reinas a colocar.
	 * 
	 * @param args Argumentos
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// Recogida del input del usuario.
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Introduce el número de reinas a colocar (tiene que ser mayor que 3): ");
			int nReinas = scanner.nextInt();
			System.out.println(NReinas.calculateSolutions(nReinas));
		} catch (InputMismatchException e) {
			System.out.println("Error: Debes ingresar un número válido.");
		} finally {
			// Código a ejecutar después del bloque try o catch.
			System.out.println("Fin del programa");
		}
	}
}
