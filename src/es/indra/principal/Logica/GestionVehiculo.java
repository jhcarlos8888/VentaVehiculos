package es.indra.principal.Logica;

import es.indra.principal.Modelo.Carro;
import es.indra.principal.Modelo.Moto;
import es.indra.principal.persistencia.dao.CarroDao;

public class GestionVehiculo {
	
	//Se genera un constructor por defecto
	public GestionVehiculo() {
		
	}
	
	
	//Metodo para crear un objeto carro para agregar un nuevo carro recibiendo parametros de clase Carro
	public Carro crearCarro(String placa, String marca, String modelo, String color, float precio, int numPuertas, int numValvulas) {
		
		
		
		//Se crea un nuevo objeto llamado carro con los datos que le llegaron en los parametros del metodo crearCarro
		//Carro carro = new Carro(placa, marca, modelo, color, precio, numPuertas, numValvulas);
		
		
		/***aqui se puede enviar a guardar a BD */
		
		//se crea un objeto de clase Carro y se almacena la operacion
		//del metodo dentro de esta misma clase llamado obtenerCarroByPlaca
		//donde al momento de crear el carro se le pasara como parametro
		//la placa que se estara creando, si la placa no existe en bases de datos
		//entonces se procedera a crear 
		Carro carro = this.obtenerCarroByPlaca(placa);
		
		
		//Esta condicional tendra el objeto anteriormente creado llamado carro
		//y realizara una comparacion donde si la busqueda arrojo un null 
		//o el objeto carro no tiene nada, es decir el objeto que creamos anteriormente
		//entonces procede a realizar una creacion de un nuevo carro
		if(carro == null || carro.getPlaca() == null) {
			
			//Entonces a ese objeto carro sera igual a un nuevo procedimiento donde 
			//le pasaremos como parametros lo que ingresamos dentro del metodo crearCarro
			//ahora tenemos en memoria ram una plantilla de tipo carro lista para usarse
			carro = new Carro(placa, marca, modelo, color, precio, numPuertas, numValvulas);
			
			//Luego creamos un objeto CarroDao para poder manipular los atributos y metodos
			// de esa clase y manipular la base de datos, el objeto lo llamaremos carDao
			CarroDao carDao = new CarroDao();
			//Ahora carDao sera igual a un metodo llamado insertarCarro donde recibira como parametro los 
			//el objeto que anteriormente creamos y que ya esta lleno con los parametros
			carDao.insertarCarro(carro);
		}
		
		
		//Me retorna o devuelve toda la informacion guardada en el objeto carro
		return carro;
	}
	
	
	//Metodo para buscar un carro por medio de la placa
	public Carro obtenerCarroByPlaca(String placa) {
		
		//este metodo deberia consultar el carro sobre la BD, pero como no se esta manejando, se simula
		
		//Esta linea simula una consulta de un carro, entonces cualquier placa a buscar 
		//me retornada un carro con las caracteristicas especificadas
		//return new Carro(placa, "CHEVROLET", "2019", "GRIS", 38000000f, 4, 8);
		
		
		/***Ahora se utilizara una base de datos*/
		
		//Se crea un objeto car para poder retornar el valor de la consulta
		Carro car;
		
		
		//Se crea un objeto de la clase CarroDao carDao y se instancia
		//para poder manipular los atributos y metodos 
		
		CarroDao carDao = new CarroDao();
		
		//el objeto car entonces sera igual a el metodo buscarCarroByPlaca
		//que se encuentra en la clase CarroDao y se le pasa como parametro 
		//la placa a buscar
		car = carDao.buscarCarroByPlaca(placa);
		
		//Se almacena en car la busqueda generada en en la clase CarroDao
		//la busqueda generada en la base de datos
		return car;
		
		
	}
	

	
	//Se crea un metodo para modificar el precio a un carro donde se le pasara 
	//como parametro una placa y un nuevo precio a asignarle a ese objeto carro
	//que finalmente se modificara dentro de la base de datos
	
	public Carro modificarPrecioCarro(String placa, float precio) {
		
		//Se crea primero un objeto tipo carro para obtener primero el registro
		//que cuente con la placa a modificar, entonces despues de tener la placa 
		//se guardara ese registro dentro del objeto carro
		Carro carro = this.obtenerCarroByPlaca(placa);
		
		
		//Se crea una condicion para verificar si el objeto carro tiene informacion 
		// y si al consultar la placa tambien tiene algun dato
		if(carro != null && carro.getPlaca() != null) {
			
			
			//Ahora como sabemos que objeto carro tiene la informacion del carro que coincida 
			//con la placa entonces se le asignara a ese objeto el precio que pasamos por parametro
			carro.setPrecio(precio);
			
			
			//Ahora se crea un objeto de clase CarroDao que es la clase que contiene las operaciones
			//que interactuan con la base de datos, esta la instanciamos para manipular la base de datos
			CarroDao carDao = new CarroDao();
			
			//Aqui ingresaremos el objeto carro dentro del metodo actualizarCarro, si esa operacion 
			//no se efectua entonces al objeto carro le asignaremos null, pero si esa operacion
			//se cumple, entonces retornaremos el objeto carro nuevamente
			if(!carDao.actualizarCarro(carro))
				carro = null;
		}
		//retornaremos el nuevo carro con el cambio establecido
		return carro;		
		
	}
	
	
	
	
	
	
	public Moto crearMoto(String placa, String marca, String modelo, String color, float precio, int cilindraje, String tipo) {
		
		Moto moto = new Moto(placa, marca, modelo, color, precio, cilindraje, tipo);
		
		//aqui se puede enviar a guardar a BD
		
		return moto;
	}
	
	public Moto obtenerMotoByPlaca(String placa) {
		
		//este metodo deberia consultar la moto sobre la BD, pero como no se esta manejando, se simula
		
		return new Moto(placa, "SUSUKI", "2022", "NEGRA CON AZUL", 4500000f, 125, "URBANA");
	}
	
	
	public Carro traerListaCarros(Carro carro) {
		
		
		return carro;
		
	}
	
	
	

}

