package es.indra.principal.Servicios;



//Se importan las clases donde se requieren extraer los datos
import es.indra.principal.Logica.GestionVehiculo;
import es.indra.principal.Logica.Inventario;
import es.indra.principal.Modelo.Carro;
import es.indra.principal.Modelo.Moto;



//Esta clase es la implementacion o ejecucion de las instrucciones de los metodos creados en la clase 
//Interfas IVentaVehiculos
public class VentaVehiculosImpl implements IVentaVehiculos {
	
	
	//Se agregan dos atributos de clase del paquete o ruta Logica
	private GestionVehiculo gestionVehiculo;
	private Inventario inventario;
	
	
	

	//Se crea un constructor con los atributos de clase
	public VentaVehiculosImpl() {
		
		this.gestionVehiculo = new GestionVehiculo();
		this.inventario = new Inventario();
	}

	
	
	
	
	@Override
	public void adicionarCarro(String placa, String marca, String modelo, String color, float precio, int numPuertas,
			int numValvulas) throws Exception{
		
		//El codigo esta dentro de un sistema try catch para constatar que el metodo se ejecute correctamente
		try {
			//Creo un objeto de clase Carro y le asigno un metodo de GesTion Vehiculo
			Carro carro = gestionVehiculo.crearCarro(placa, marca, modelo, color, precio,numPuertas, numValvulas);
			
			//Se adiciona el objeto a la lista
			//inventario.ingresarCarro(carro);
			
			inventario.ingresarVehiculo(carro);			
			//Se crea una variable a con un valor de objeto clase Integer donde tratara de convertir
			//lo que se recibe por parametro a entero, si esto falla se disparara un error 
			//y se almacenara en el catch dentro del objeto exception ex
			//==> int a = Integer.parseInt("16E12");
			
		}catch(Exception ex){
			//la palabra throw lo que hace es poder crear nuestro propio mensaje de error 
			throw new Exception("Error en adicionar Carro " + ex.getMessage());
		}
		
		
		
		
	}
	
	
	

	@Override
	public Carro modificarPrecioAutomovil(String placa, float precio) {
			
		Carro carro = gestionVehiculo.modificarPrecioCarro(placa, precio);
		inventario.modificarInventarioCarro(carro);
		
		return carro;

	}
	
	
	
	

	@Override
	public void adicionarMoto(String placa, String marca, String modelo, String color, float precio, int cilindraje,
			String tipo) {

		Moto moto = gestionVehiculo.crearMoto(placa, marca, modelo, color, precio, cilindraje, tipo);
		inventario.ingresarMoto(moto);
		
	}

	@Override
	public Carro consultarCarro(String placa) {
		
		if(this.inventario.isCarroDisponible(placa)) {
			Carro carro = this.gestionVehiculo.obtenerCarroByPlaca(placa);
			return carro;
		}
		return null;
	}

	
	@Override
	public Moto consultarMoto(String placa) {
		
		if(this.inventario.isMotoDisponible(placa)) {
			Moto moto = this.gestionVehiculo.obtenerMotoByPlaca(placa);
			return moto;
		}
		return null;
		
	}










	




	

}
