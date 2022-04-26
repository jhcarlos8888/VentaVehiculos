package es.indra.principal.Modelo;

public class Moto extends Vehiculo {

	private int cilindraje;

	private String tipo;

	// Complemento constructor Moto
	public Moto() {
		super();
		this.cilindraje = 0;
		this.tipo = "";
	}

	// Constructor de clase Moto
	public Moto(int cilindraje, String tipo) {
		super();
		this.cilindraje = cilindraje;
		this.tipo = tipo;
	}

	
	// Constructor creado con los atributos de la clase padre Vehiculo, y se agregan
	// los demas atributos de la clase Moto
	// ademas esto se llamaria sobre carga de metodos, ya que agregamos los
	// atributos cilindraje y tipo a el constructor
	// que previamente trae los atributos de clase vehiculo
	public Moto(String placa, String marca, String modelo, String color, float precio, int cilindraje, String tipo) {
		super(placa, marca, modelo, color, precio);
		this.cilindraje = cilindraje;
		this.tipo = tipo;
	}
	
	
	
	// Metodo para cambiar o asignar un cilindraje a clase moto donde recibe parametro de tipo entero
		public void cambiarCilindraje(int cilindraje) {

			this.cilindraje = cilindraje;

		}

	// Este metodo es para cambiar el cilindraje a la moto de forma String, entonces
	// se llama igual al metodo
	// cambiar cilindraje anterior pero recibe son datos caracteres y luego se
	// convierten a entero,
	// al usar entonces el mismo metodo en la misma clase, pero con otros parametros
	// se le llama sobre carga de metodos
	public void cambiarCilindraje(String srtCilindraje) {
		
		//Se declara un objeto tipo Integer con valor Null
		Integer valor = null;
		// Codigo dentro de un sistema de exepciones
		try {
			//Valor realizara la conversion de lo que recibe el metodo cambiar Cilindraje por parametro
			//entonces si la conversion falla se ejecutara el codigo dentro de catch
			valor = Integer.valueOf(srtCilindraje);
		} catch (Exception ex){
			//Imprimira un erro en consola si el codigo dentro de Try no se pudo ejecutar
			ex.printStackTrace();
		} finally {
			//Si valor no pudo recibir ningun valor entonces se asigna cero
			if(valor == null) {
				this.cilindraje = 0;
			}else {
				//Si el objeto valor si pudo recibir una informacion correcta entonces se asignara su 
				//respectivo cilindraje al atributo del objeto que llamo este metodo de cambiar cilindraje
				this.cilindraje = valor.intValue();
			}
			
		}

	}

	// Inicio getters and setters de clase Moto
	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	

}
