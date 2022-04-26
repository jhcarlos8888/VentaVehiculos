package es.indra.principal.figuras;

import java.util.Map;

import es.indra.principal.Constantes;

//Esta clase es una extension de la clase Figuras Geometricas
public class Circulo extends FigurasGeometricas {
	
	private int radio;
	
	
	
	//Si una clase quiere heredar o ser hija de una clase abstracta, al menos debe 
	//traer un metodo abstracto de la clase padre abstracta
	@Override
	float calcularArea(Map<String, Integer> parametros) {
		
		
		//Se declara variable area
		float area;
		
		//Se crea y se declara variable radioTmp para guardar la informacion que se le pasa 
		//por medio de parametros al metodo calcular Area
		Integer radioTmp = (Integer) parametros.get("RADIO");
		//Se asigna la operacion calculada a radio
		this.radio = radioTmp.intValue();
		//Se asigma a variable area el calculo necesario
		area = (this.radio * this.radio) * Constantes.PI;
		//al calcula el area de circulo,llamamos a la clase padre y prestamos la variable area
		//para que se asigne el valor 
		super.setArea(area);
		
		return area;
	}

}
