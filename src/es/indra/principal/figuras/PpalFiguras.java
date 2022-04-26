package es.indra.principal.figuras;

import java.util.HashMap;


//Se crea una clase ejecutable donde se realizaran las operaciones del programa
public class PpalFiguras {

	public static void main(String[] args) {

		//Se crea un objeto de clase Circulo
		Circulo circulo = new Circulo();

		// Se crea un objeto HashMap llamado param para realizar la peticion
		// y obtener los parametros
		HashMap<String, Integer> param = new HashMap<String, Integer>();
		//Se ingresa la llave y el numero par calcular el area
		param.put("RADIO", 2);
		// se crea variable area para calcular el area de un circulo
		float area = circulo.calcularArea(param);
		
		System.out.println("Area del circulo: " + area);
		
	}

}
