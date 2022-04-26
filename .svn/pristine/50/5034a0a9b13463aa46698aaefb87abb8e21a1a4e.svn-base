package es.indra.principal.Modelo;

public class Carro extends Vehiculo {

	// Inicio de atributos
	private int numPuertas;

	private int numValvulas;

	// Complemento de constructor de clase carro,
	public Carro() {
		super();
		this.numPuertas = 0;
		this.numValvulas = 0;

	}

	// Constructor de clase carro
	public Carro(String placa, String marca, String modelo, String color, float precio, int numPuertas, int numValvulas) {
		
		super(placa, marca, modelo, color, precio);
		this.numPuertas = numPuertas;
		this.numValvulas = numValvulas;
		
	}

	
	// Metodo para cambiar precio a un carro, se trae un metodo desde la clase
	// vehiculo, para reutilizarse
	// y guardar informacion de objetos creados con la clase carro, ademas tambien
	// podremos agregarle mas codigo
	// a ese metodo que se clono para realizar otros fines

	/* @Overrride */ @Override // El Override lo que hace es llamar a un metodo y sobreescribir completamente
								// el codigo interno
								// podemos entonces modificar sus instrucciones para otros fines
	public boolean cambiarPrecio(float newPrecio) { // Este metodo cambiaPrecio es necesario que tenga el mismo nombre
													// que la clase padre

		float nuevoPrecio = (newPrecio * 0.8f); // creo una nueva variable donde realizo una nueva operacion
		super.setPrecio(nuevoPrecio); // Esta linea llama la variable del objeto padre de la clase Vehiculo,
										// se debe realizar un super.setPrecio para guardarla en el objeto de carro
										// pues la variable precio esta dentro de la clase vehiculo y lo
										// que estamos haciendo es reutilizar esa variable para crear una nueva variable
										// imaginaria
										// en la memoria del objeto de clase Carro, en este caso le asignamos un valor
										// al la variable imaginaria precio de la clase carro para que pueda mostar algo
										// cuando se crean instancias de la clase Carro en otras clases
		System.out.println(
				"Mensaje para saber que estamos dentro de metodo cambiar precio de clase Carro " + nuevoPrecio);
		// return super.cambiarPrecio(nuevoPrecio); // Este metodo me retorna el codigo
		// que se necesita para cambiar un precio
		// previamente creado en la clase vehiculo, esto nos ayuda a no crear

		return true;

	}

	// Comienzo de getters and setters

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public int getNumValvulas() {
		return numValvulas;
	}

	public void setNumValvulas(int numValvulas) {
		this.numValvulas = numValvulas;
	}

}
