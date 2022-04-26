
//El paquete significa la ruta donde se alojaran 

package es.indra.principal.Modelo;


/**
 * La clase vehiculo es el modelo general de donde se saca la copia para las
 * demas clases esta se encarga de generar los atributos principales que se
 * requieren para cada objeto
 * 
 * @author Indra // Se debe de colocar autor Indra, en todos los proyectos por
 *         que es una practica segura, no se deben colocar nombre de las
 *         personas que realizo los comentarios o modificaciones
 *         
 *         Se agrega linea al comentario para realizar un cambio y 
 *         se refleje en el Subversion
 *         Nuevamente se revisa y se crea otra linea 
 *
 */

public class Vehiculo {

	// Atributos de la clase vehiculo, sus caracteristicas

	private String placa;

	private String marca;

	private String modelo;

	private String color;

	private float precio;

	// Complemento par que el constructor funcione correctamente

	public Vehiculo() {

		this.placa = new String();
		this.marca = new String();
		this.modelo = new String();
		this.color = new String();
		this.precio = 0f;

	}

	// Se declara e inicializa el constructor

	public Vehiculo(String placa, String marca, String modelo, String color, float precio) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.precio = precio;

	}

	// Fin declaracion constructor

	// Para generar un texto o comentario java doc de un metodo se debe escribir
	// /*** y luego enter
	// donde nos mostrara luego el nombre de las variables y parametros que esta
	// utilizando el metodo, tambien si se genera un arroba se despliegan mas
	// opciones para creacion de comentarios

	/***
	 * 
	 * @param placa  Esta es la placa del vehiculo
	 * @param marca  Esta es la marca de la empresa como Mazda, Honda, Susuki, entre
	 *               otros
	 * @param modelo Este caso el modelo seria el año de creacion
	 * @param color  Color del vehiculo
	 * @param precio Precio del vehiculo
	 * @return retorna un booleano true, si los parametros se ingresan correctamente
	 * 
	 */

	// Metdo para registrar un nuevo vehiculo reemplazando los anteriores atributos
	public boolean registrarVehiculo(String placa, String marca, String modelo, String color, float precio) {

		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.precio = precio;

		return true;

	}

	// Metodo para cambiar precio a un vehiculo

	public boolean cambiarPrecio(float newPrecio) {

		this.precio = newPrecio;
		System.out.println("Mensaje para saber que estamos dentro del metodo cambiar precio de clase vehiculo");
		return true;

	}

	// Metodo para obtener el precio de un vehiculo

	public float obtenerPrecio() {

		return this.precio;

	}

	// Metodo para obtener placa

	public String obtenerPlacaActual() {
		return this.placa;
	}

	// Metodo boolean para saber si una placa existe y guardar la consulta
	// en otra variable llamada consultaPlaca para luego sacar esa informacion

	public String buscarPlaca(String newPlaca) {

		// if(this.placa.length() != 0) {
		if (newPlaca.equals(this.placa)) {
			return this.placa;
		} else {
			return null;
		}
		// }

		// return null;
	}

	// Comienzo de getters and setters
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

}
