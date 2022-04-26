package es.indra.principal.figuras;

import java.util.Map;

//Se crea una clase abstracta
public abstract class FigurasGeometricas {

	//inicio de atributos
	private float area;
	private float perimetro;
	
	
	
	
	
	//Inicio de getters and setters
	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	public float getPerimetro() {
		return perimetro;
	}
	public void setPerimetro(float perimetro) {
		this.perimetro = perimetro;
	}
	
	//Se crea un metodo abstracto, la clase debe tener al menos un metodo abstracto 
	//el cual no hara nada en su misma clase o no retornara nada, solo se declara y se prepara,
	//pero no se inicializa entonces las clases hijas 
	//podran realizar y colocar las instrucciones para poder ejecutar el metodo
	abstract float calcularArea(Map<String, Integer> parametros);
	
	
	
	
	
}
