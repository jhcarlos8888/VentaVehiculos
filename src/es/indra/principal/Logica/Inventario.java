package es.indra.principal.Logica;

import java.util.ArrayList;
import java.util.List;

import es.indra.principal.Modelo.Carro;
import es.indra.principal.Modelo.Moto;



public class Inventario {

	// Se declara los atributos de Inventario donde se crean tambien unas listas
	private int cantCarros;
	private int cantMotos;
	private List<Carro> lstCarros;
	private List<Moto> lstMotos;

	
	// Se crea un objeto constructor y se inicializa
	public Inventario() {
		super();

		// Se inicializa los atributos
		this.cantCarros = 0;
		this.cantMotos = 0;

		// Se inicializan las listas con un objeto tipo carro y Moto
		this.lstCarros = new ArrayList<Carro>();
		this.lstMotos = new ArrayList<Moto>();

	}// final de constructor

	// Se crea un metodo para ingresar un objeto carro a la lista Carros de la clase
	// Inventario
	public void ingresarCarro(Carro carro) {

		// Si el parametro carro recibido contiene informacion, entonces siga la
		// siguiente linea
		if (carro != null) {

			// Se asigna a la lista un nuevo nodo o index con un objeto de la clase Carro
			// llamado carro
			this.lstCarros.add(carro);
			// Se adiciona a la variable cantCarros un numero +1
			this.cantCarros += 1;
		}

	}

	// Se crea un metodo para ingresar un objeto carro a la lista Carros de la clase
	// Inventario
	public void ingresarMoto(Moto moto) {

		// Si el parametro carro recibido contiene informacion, entonces siga la
		// siguiente linea
		if (moto != null) {

			// Se asigna a la lista un nuevo nodo o index con un objeto de la clase Carro
			// llamado carro
			this.lstMotos.add(moto);
			// Se adiciona a la variable cantCarros un numero +1
			this.cantMotos += 1;
		}

	}

	public void decrementarCarro(Carro carro) {

		// Se declara variable de objeto carro llamado car para realizar el recorrido en la lista
		Carro car;

		// Se realiza un recorrido para saber cuantos carros o posiciones tenemos
		// actualmente en la lista
		for (int i = 0; i < lstCarros.size(); i++) {

			// Se inicializa la variable con la cantidad de posiciones anteriormente
			// halladas
			car = lstCarros.get(i);

			// Se ingresa a la variable car donde almacena toda la cantidad o carros y se
			// consulta un numero de placa
			if (car.getPlaca().equals(carro.getPlaca())) {
				// Se remueve el carro completo de la posicion donde se encontro el numero de
				// placa
				lstCarros.remove(i);
				// Se borra una cantidad de la variable, ya que se borro completamente un indice
				// o posicion de la lista
				this.cantCarros -= 1;
				// Con break lo que hacemos es para el ciclo for para que no continue borrando
				// la posicion donde
				// se encontro la placa, si no hacemos esto siempre seguira borrando esa
				// posicion, pues sabemos
				// que los demas carros se corren automaticamente segun se vallan removiendo de
				// la lista
				break;

			}

		}

	}

	
	public void decrementarMoto(Moto moto) {

		Moto motocicleta;

		for (int i = 0; i < lstMotos.size(); i++) {

			motocicleta = lstMotos.get(i);

			if (motocicleta.getPlaca().equals(moto.getPlaca())) {

				lstMotos.remove(i);

				this.cantMotos -= 1;
				break;

			}

		}

	}
	
	
	
	public boolean isCarroDisponible(String placa) {
		
		if(placa != null) {
			
			Carro car;
			for(int i= 0; i < lstCarros.size(); i++) {
				
				car = lstCarros.get(i);
				
				if(car.getPlaca().equals(placa)) {
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	
	
	//Se crea un metodo para modificar la lista de carros que se tienen en memoria
	
	public void modificarInventarioCarro(Carro carro) {
		
		//si el objeto carro que recibimos como parametro tiene informacion
		//entonces se cumple las instrucciones dentro de la condicion
		if(carro != null) {
			
			//se crea un objeto carro para poder guardar el recorrido de lista 
			Carro car;
			
			//este bucle for me sirve para recorrer una lista que se tenga almacenada
			
			for(int i= 0; i < lstCarros.size(); i++) {
				
				//ahora le asignaremos al objeto carro toda la lista que se encontro 
				//en memoria al realizar el bucle for
				car = lstCarros.get(i);
				
				//ahora pondremos una condicion donde compararemos los registros de la lista 
				//con el objeto que le pasamos como parametros
				//compararemos si las placas coinciden 
				
				if(car.getPlaca().equals(carro.getPlaca())) {
					//entonces si las placas coindicen eliminaremos ese nodo que contiene la placa
					//igual al objeto que le pasamos como parametro desde un principio
					lstCarros.remove(i);
					//luego de eliminar ese registro volveremos a crear un objeto nuevo con 
					//su datos nuevos a la lista carros
					lstCarros.add(carro);	
					
					//break funcionara para salirse del bucle y finalizar el codigo
					break;
				}
			}			
		}
	}
	
	
	
	
	
	public boolean isMotoDisponible(String placa) {
		
		if(placa != null) {
			
			Moto moto;
			for(int i= 0; i < lstCarros.size(); i++) {
				
				moto = lstMotos.get(i);
				
				if(moto.getPlaca().equals(placa)) {
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	
	//Esta es un forma de agregar un objeto moto o vehiculo a una lista inventario de forma mucho mas facil
	//ya que se crea un objeto generico para guardar la informacion que llega 
	
	public void ingresarVehiculo (Object obj) {
		
		if(obj instanceof Carro) {
			this.lstCarros.add( (Carro) obj);
			this.cantCarros += 1;	
		}
		else if(obj instanceof Moto) {
			
			this.lstMotos.add((Moto) obj);
			this.cantMotos += 1;				
		}
	}
	
	


	// Inicio de getters and Setters

	public int getCantCarros() {
		return cantCarros;
	}

	public void setCantCarros(int cantCarros) {
		this.cantCarros = cantCarros;
	}

	public int getCantMotos() {
		return cantMotos;
	}
	
	public void setCantMotos(int cantMotos) {
		this.cantMotos = cantMotos;
	}

}
