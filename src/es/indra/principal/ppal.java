package es.indra.principal;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.indra.principal.Modelo.Carro;
import es.indra.principal.Modelo.Moto;
import es.indra.principal.Modelo.Vehiculo;
import es.indra.principal.Servicios.IVentaVehiculos;
import es.indra.principal.Servicios.VentaVehiculo2;
import es.indra.principal.Servicios.VentaVehiculosImpl;

public class ppal {

	// Metodo main sirve para ejecutar esta clase por consola y donde se realizaran las operaciones del programa

	public static void main(String[] args) {

		
		/*** codigo para mostrar el manejo de fecha y hora en java */
		
		// manejo de fechas: fecha a string

		Date fechaActual = new Date();
		System.out.println("Fecha hoy: " + fechaActual.toString());

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // "dd/MM/yyyy hh:mm:ss"
		String strFecha = formato.format(fechaActual);
		System.out.println("Fecha hoy 2: " + strFecha);

		formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // "dd/MM/yyyy hh:mm:ss"
		strFecha = formato.format(fechaActual);
		System.out.println("Fecha hoy 3: " + strFecha);

		// manejo de fechas: string a fecha
		strFecha = "15/03/2022";
		try {
			formato = new SimpleDateFormat("dd/MM/yyyy");
			fechaActual = (Date) formato.parse(strFecha);
			System.out.println("Fecha desde el string: " + fechaActual.toString());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}

		java.sql.Date fechaSql = new java.sql.Date((new Date()).getTime());
		System.out.println("Fecha SQL: " + fechaSql);

		// Fin codigo manejo de fechas

		/***Codigo donde se comenzara a trabajar con los objetos creados del proyecto Vehiculo */
		
		
		
		
		// Se instancia el objeto consutructor, del anterior constructor que se creo
		// en la clase Vehiculo
		
		Vehiculo vehiculo = new Vehiculo();

		// Codigo condicional para registrar un nuevo vehiculo, en este caso
		// las variables actuales se reemplazaran
		
		if (vehiculo.registrarVehiculo("NRU83F", "Discover", "2022", "Blanco", 8000f))

		{
			System.out.println("El vehiculo se registro");

		}

		// Codigo para obtener precio del vehiculo
		
		float precioVehiculo = vehiculo.obtenerPrecio();
		System.out.println("Precio actual " + precioVehiculo);

		// Codigo para cambiar precio al vehiculo

		if (vehiculo.cambiarPrecio(7000000f)) {
			System.out.println("Se cambia precio de vehiculo a " + vehiculo.obtenerPrecio());
		}

		// Codigo para obtener la placa actual

		String placaVehiculo = vehiculo.obtenerPlacaActual();
		System.out.println("Informacion de la placa actual registrada " + placaVehiculo);

		// Codigo para crear una lista y (recorrer-obtener) los atributos de un objeto
		// clase
		// Cada objeto creado de una determinada clase es un nodo de una lista
		// Los nodos comienzan desde la posicion cero, y cada posicion almacena un
		// objeto

		List<Vehiculo> lstVehiculos = new ArrayList<Vehiculo>();

		lstVehiculos.add(vehiculo);

		Vehiculo vehiculo2 = new Vehiculo("JHB187", "Honda", "2021", "Gris", 5000f);

		lstVehiculos.add(vehiculo2);
		
		System.out.println("*****************Primera forma de recorrido de lista lstVehiculos **********************");
		// Primera forma de recorrer una lista
		for (int i = 0; i < lstVehiculos.size(); i++) {

			Vehiculo almListV = lstVehiculos.get(i);
			System.out.println("vehiculo registrado " + (i + 1) + " Placa: " + almListV.obtenerPlacaActual()
					+ " Marca: " + almListV.getMarca());

		}

		System.out.println("*****************Segunda forma de recorrido de lista lstVehiculos **********************");
		
		// Segunda forma de recorrer una lista

		for (Vehiculo vehi : lstVehiculos) {

			System.out.println(
					"vehiculo registrado " + "  Placa: " + vehi.obtenerPlacaActual() + " Marca: " + vehi.getMarca());
		}

		
		/*** Codigo para utilizar un map a un objeto vehiculo */
		
		// Codigo para crear un map; el map sirve para agregarle a un objeto una llave o
		// key tipo String
		// esta llave se le asigna a un atributo existente de un objeto clase que
		// contenga informacion almacenada
		// Esto se hace para poder obtener los demas atributos y metodos de un objeto,
		// si la llave no coincide
		// No dejara traer informacion y generara error
		// El map me sirve para obtener informacion mas rapidamente de un determinado
		// valor que se encuentre dentro de un objeto

		Map<String, Vehiculo> mapVehiculos = new HashMap<String, Vehiculo>();

		// Se le ingresa la llave a los objetos anteriormente creados
		mapVehiculos.put("NRU83F", vehiculo);
		mapVehiculos.put("JHB187", vehiculo2);

		// Se crea un objeto alMapV para traer informacion y almacenarla
		Vehiculo alMapV = mapVehiculos.get("JHB187");
		System.out.println("Modelo obtenido con el metodo  Map: " + alMapV.getModelo());

		// Variable creada que guarda informacion de un atributo constante de la clase
		// Constantes
		String dato = Constantes.RUNT;
		System.out.println(dato);

		
		/*** Codigo donde se crea un objeto carro */
		

		// Nuevo objeto de clase Carro llamado car para asignarle un precio al objeto
		// car de clase Carro
		Carro car = new Carro();
		car.setColor("Rojo");
		car.cambiarPrecio(145700f);
		System.out.println("Valor del carro: " + car.getPrecio());

		/*** Codigo donde se crea un objeto Moto */
		
		// Se crea un objeto de clase Moto inmediatamente ingresando parametros de la
		// clase Vehiculo
		// este ejemplo es mas practico ya que se creo anteriormente un constructor con
		// todos los
		// atributos de la clase vehiculo
		Moto moto = new Moto("JUM203", "Honda", "2022", "Gris Claro", 78512f, 180, "Enduro");
		moto.cambiarPrecio(5200000f);
		moto.cambiarCilindraje(250);
		moto.cambiarCilindraje("320");
		System.out.println("Valor de la moto : " + moto.getPrecio() + ", CC cilindraje: " + moto.getCilindraje());
		// Linea para disparar un error exeption try catch de la clase Moto,entonces
		// mostrara en consola
		// que el parametro que esperaba el metodo cambiarCilindraje era un numero
		// solamente, pero como se agrego
		// las letras cc entonces no se puede convertir el String a entero
		moto.cambiarCilindraje("320cc");
		System.out.println("cilindraje luego de que se disparara la exepcion al agregar un valor errado, VALOR: "
				+ moto.getCilindraje());
		System.out.println("************************************************");

		// Se declara un objeto tipo clase Vehiculo, pero se inicializa con su clase
		// hija Carro
		// en este caso automaticamente asigna los demas atributos que tiene clase
		// vehiculo
		// a clase carro, esto permite llamar los metodos que se encuentran en la clase
		// hija
		// para realizar los calculos que se requieran
		// Al inicializar con una clase hija se le esta dando prioridad al codigo de que
		// utilice
		// los metodos de la clase hija Carro
		Vehiculo vehiculo4 = new Carro();
		vehiculo4.cambiarPrecio(100000f);
		System.out.println("Valor de vehiculo 4: " + vehiculo4.getPrecio());

		// Se crea un objeto de clase vehiculo, aca se le da prioridad a los metodos
		// originales
		// que tiene la clase padre Vehiculo
		Vehiculo vehiculo5 = new Vehiculo();
		vehiculo5.cambiarPrecio(100000f);
		System.out.println("Valor de vehiculo 5: " + vehiculo5.getPrecio());

		System.out.println("***************************************");

		
		/***Codigo a ejecutar de la interfas */
		// Se crea un objeto de la clase Interfas llamado ventaCarro y se inicializa con
		// una de sus implementaciones, clase implementada
		IVentaVehiculos ventaCarro = new VentaVehiculosImpl();
		// VentaVehiculosImpl ventaCarro = new VentaVehiculosImpl();

		// En esa seccion se adiciona al objeto tipo carro un nuevo carro y este a su
		// vez esta dentro de un codigo
		// que tiene un sistema de exepciones, un try que ejecuta el codigo si no tiene
		// ningun error al compilar
		// pero si el codigo no se ejecuta correctamente se dispara la funcion catch
		// donde emitira un mensaje
		// comentando que el codigo dentro la funcion try no se completo correctamente
		try {
		
			ventaCarro.adicionarCarro("CAR123", "HYUNDAI", "2020", "GRIS", 27000000f, 4, 8);
			
			
			
			System.out.println("Marca del CARRO 6: " + ventaCarro.consultarCarro("CAR123").getMarca());
			
			car = ventaCarro.modificarPrecioAutomovil("CAR123", 8200000f);
			System.out.println("Valor del CARRO 7, placa: " + car.getPlaca() + ", valor: " + car.getPrecio() + ", marca:" + car.getMarca()); 
			
			
			
			
			} catch (Exception ex) {
			ex.printStackTrace();
		}

		
		
		
		
		
		IVentaVehiculos ventaMoto = new VentaVehiculo2();
		ventaMoto.adicionarMoto("AXC", "HONDA", "2015", "ROJO", 7500000f, 200, "URBANA");

		
		
		
		
		// se cumple paso por referencia, comparten los mismos campos de memoria
		// El vehiculo5 al ser igual a vehiculo4 se autoasigna los mismos campos en
		// memoria, entonces
		// cuando se modifica un atributo de alguno de los dos objetos, automaticamente
		// cambia para los dos, no solamente para un objeto
		// se actualiza la variable automaticamente
		vehiculo5 = vehiculo4;
		vehiculo5.setPrecio(1500000f);
		// se cambio el precio de vehiculo5 entonces vehiculo 4 tambien tendra ese mismo
		// valor, y esto se llama paso por referencia
		// comparten los mismos atributos en memoria
		System.out.println("Valor del vehiculo 4 segunda vez: " + vehiculo4.getPrecio());
		System.out.println("Valor del vehiculo 5 segunda vez: " + vehiculo5.getPrecio());

		// Se va a comparar una variable int tipo primitiva con una clase padre tipo
		// Integer

		// Se crea una variable con valor tipo entero primitivo
		int a = 5;

		// Se crea un objeto de tipo clase Integer (Entero), y se pasa como parametro un
		// valor
		Integer ab = new Integer(5);
		// Se crea un objeto bc tipo clase Integer y se asigna un metodo estatico
		// valueof obliga a que lo entregado por parametro se conviera en un entero
		Integer bc = Integer.valueOf(5);

		// Se realiza una condicion para compara los valores de amba informacion
		// anterior, una variable y una clase
		// En este caso se compara una variable tipo primitivo con una clase tipo
		// Integer, pero se debe tener en
		// cuenta que se debe colocar .intValue() seguido de la clase o variable para
		// que se realice una comparacion
		// pero con el valor entero que contiene dicha clase. intValue() permite mostrar
		// el valor entero
		if (a == ab.intValue()) {
			System.out.println("Los valores son iguales");
		} else {
			System.out.println("Los valores son diferentes");
		}

		// En este caso se comparan los valores enteros de dos clases Integer, se debe
		// realizar la conversion de esta
		// forma para que no se tenga ningun problema de ejecucion en el codigo
		if (ab.intValue() == bc.intValue()) {
			System.out.println("Los valores son iguales, entre clases Integer");
		} else {
			System.out.println("Los valores son diferentes");
		}

		// Se crea un objeto tipo clase float y se inicializa con una instancia del
		// mismo donde
		// valueOf obliga a que lo ingresado por parametro se convierta en un valor tipo
		// float
		Float dc = Float.valueOf("5.65");

		// Se llama a la clase a y se le asigna un objeto tipo float, que al colocarle
		// intValue convierte el valor que
		// tenga el objeto dc en un valor entero
		a = dc.intValue();
		System.out.println("El valor de la variable a es " + a);

		// En este caso queremos redondear el valor del objeto dc tipo float a su numero
		// mas cercano hacia arriba
		System.out.println("El valor del objeto dc redondeado es " + Math.round(dc));


		
		
	}

}
