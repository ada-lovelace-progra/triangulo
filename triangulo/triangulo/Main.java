package triangulo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String readLine = "";
		Scanner lector = new Scanner(System.in);
		while (!readLine.contains("salir")) {
			Triangulo t = new Triangulo();
			readLine = lector.nextLine();
			while (readLine.length() != 0 && !readLine.contains("salir")) {
				t.agregarLado(readLine);
				readLine = lector.nextLine();
			}
			if (!readLine.contains("salir"))
				System.out.println(t.print());
		}
		lector.close();
	}
}
