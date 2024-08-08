package Main;

import java.util.ArrayList;

/**
 * Esta clase define la lógica de cómo se comprueban las soluciones y de las amenazas.
 * 
 * @author <a href="sergiobuil2003@gmail.com">Sergio Buil Laliena</a> 
 */
public class NReinas {
	
	/**
	 * Calcula las soluciones posibles.
	 * 
	 * @param n Número de reinas a colocar.
	 * @return Número de soluciones posibles.
	 */
	static int calculateSolutions(int n) {

		System.out.println("Soluciones posibles para " + n + " reinas:");
		
		ArrayList<ArrayList<Integer>> validSolutions = new ArrayList<>();
		populateValidSolutions(n, validSolutions, new ArrayList<>());
		
		System.out.println("Número de soluciones: ");
		return validSolutions.size();
	}

	/**
	 * Añade las posibles soluciones a la lista y configura el modo texto.
	 * 
	 * @param n Número de reinas a colocar.
	 * @param validSolutions Lista de soluciones.
	 * @param queensYPosition Posición de cada reina.
	 */
	private static void populateValidSolutions(int n, ArrayList<ArrayList<Integer>> validSolutions,
			ArrayList<Integer> queensYPosition) {

		if (queensYPosition.size() == n && !areDiagonalThreatens(queensYPosition)) {

			// Imprime la solución por pantalla.
			for (int i = 0; i < queensYPosition.size(); i++) {
				for (int j = 0; j < queensYPosition.size(); j++) {
					if (queensYPosition.get(i) == j) {
						System.out.print(" A ");
					} else {
						System.out.print(" - ");
					}
				}
				System.out.println("");
			}
			System.out.println("");

			validSolutions.add(new ArrayList<>(queensYPosition));
		}

		for (int i = 0; i < n; i++) {
			if (!queensYPosition.contains(i)) {
				queensYPosition.add(i);
				populateValidSolutions(n, validSolutions, queensYPosition);
				queensYPosition.remove(queensYPosition.size() - 1);
			}
		}

	}

	/**
	 * Calcula las amenazas en diagonal
	 * 
	 * @param aux Lista de posiciones de las reinas.
	 * @return true si hay amenazas en diagonal, false si no las hay.
	 */
	private static boolean areDiagonalThreatens(ArrayList<Integer> aux) {

		for (int i = 0; i < aux.size(); i++) {
			int x = aux.get(i), y = i;
			while (x >= 0 && y >= 0) {
				if (y != i && aux.get(y) == x) {
					return true;
				}
				x--;
				y--;
			}
			x = aux.get(i);
			y = i;
			while (x >= 0 && y < aux.size()) {
				if (y != i && aux.get(y) == x) {
					return true;
				}
				x--;
				y++;
			}
		}
		return false;
	}
}
