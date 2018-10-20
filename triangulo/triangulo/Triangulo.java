package triangulo;

public class Triangulo {
	private int lado1;
	private int lado2;
	private int lado3;
	private String queEs;

	public Triangulo(int lado1, int lado2, int lado3) {
		agregarLado(lado1);
		agregarLado(lado2);
		agregarLado(lado3);
		queEs = "No se ejecuto el metodo resolver";
	}

	public Triangulo() {
		lado1 = lado2 = lado3 = -1;
		queEs = "No se ejecuto el metodo resolver";
	}

	public void agregarLado(int x) {
		if (x < 0) {
			System.out.println("No se ingreso un numero valido");
			return;
		} else if (lado1 == -1) {
			lado1 = x;
			System.out.println("Lado 1: " + x);
		} else if (lado2 == -1) {
			lado2 = x;
			System.out.println("Lado 2: " + x);
		} else if (lado3 == -1) {
			lado3 = x;
			System.out.println("Lado 3: " + x);
		} else
			System.out.println("Se ingresaron parametros de mas");
	}

	private void resolver() {
		if (lado3 == -1) {
			queEs = "No se ingresaron la cantidad de correctas de parametros";
		}
		if (esTriangulo())
			if (esEquilatero())
				queEs = "Equilatero";
			else if (esIsoceles())
				queEs = "Isoceles";
			else
				queEs = "Escaleno";
		else
			queEs = "No es un triangulo valido";
	}

	private boolean esIsoceles() {
		return lado1 == lado2 || lado1 == lado3 || lado2 == lado3;
	}

	private boolean esEquilatero() {
		return lado1 == lado2 && lado2 == lado3;
	}

	private boolean esTriangulo() {
		return validar(lado1, lado2, lado3, 3);
	}

	private boolean validar(int lado1, int lado2, int lado3, int i) {
		if (i == 0)
			return true;

		return lado1 + lado2 > lado3 ? validar(lado2, lado3, lado1, --i) : false;
	}

	public String print() {
		resolver();
		if (lado3 == -1)
			return queEs;
		return shiftear(lado1, lado2, lado3, 1);
	}

	private String shiftear(int lado1, int lado2, int lado3, int i) {
		if (i == 4)
			return "y es: " + queEs;
		return "Lado " + i + ": " + lado1 + " " + shiftear(lado2, lado3, lado1, ++i);
	}

	public void agregarLado(String readLine) {
		try {
			int x = Integer.parseInt(readLine);
			agregarLado(x);
		} catch (Exception e) {
			System.out.println("No se ingreso un caracter valido");
		}
	}

}
