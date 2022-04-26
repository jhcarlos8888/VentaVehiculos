package es.indra.principal.Servicios; //Ruta del paquete 



//Se importan las rutas de las clases principales a las cuales se realizaran las operaciones
import es.indra.principal.Modelo.Carro;
import es.indra.principal.Modelo.Moto;


public interface IVentaVehiculos {
	
	//Se crean los metodos principales para realizar en el programa
	
	//Adicionar carro, se debe tener en cuenta el orden en que se esta creado el contructor de la clase padre Vehiculo
	//y la clase hija carro
	public void adicionarCarro(String placa, String marca, String modelo, String color, float precio, int numPuertas, int numValvulas) throws Exception;
	
	//Adicionar Moto
	public void adicionarMoto(String placa, String marca, String modelo, String color, float precio, int cilindraje, String tipo);
	
	//Consultar si un carro existe por medio de la placa
	public Carro consultarCarro(String placa);
	
	//Consultar si una moto existe por medio de la placa
	public Moto consultarMoto(String placa);
	
	//Metodo para modificar el precio a un carro dentro de una base de datos
	public Carro modificarPrecioAutomovil(String placa, float precio);
	
	
 
}

