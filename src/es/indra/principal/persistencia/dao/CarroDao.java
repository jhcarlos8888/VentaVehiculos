package es.indra.principal.persistencia.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import es.indra.principal.Modelo.Carro;
import es.indra.principal.persistencia.Conexion;



//Esta clase es la que me servira para manipular la base de datos
//Dao significa Data Acces Object es decir objeto de acceso a datos
//Son los objetos que permiten hace CRUD en una base de datos


public class CarroDao {
	
	//Se crea atributo de clase Conexion llamado conexion
	//private Conexion conexion;
	
	
	//Se crea un constructor para inicializar los atributos y metodos
	
	public CarroDao() {
		 //Se hace referencia de crear un objeto de atributo conexion 
		//que es de la clase Conexion donde me traera los atributos de la
		//clase,entonces como la clase Padre conexion tiene un constructos
		//que internamente llama a un metodo para que crea una nueva conexion
		//a base de datos, entonces en la clase CarroDao estamos instanciando 
		//esa conexion para poder manipularla ya acceder a ella
		//this.conexion = new Conexion();
	}
	
	
	
	//Se crea un metodo que no retorna nada, pero si es para ingresar datos
	//en este caso recibe como parametros un objeto de clase Carro llamao carro
	//que lo guardaremos dentro de una base de datos
	
	public void insertarCarro(Carro carro) {
		
		
		Conexion conexion = new Conexion();
		//Se crea una cadena que represente el comando Insert del Lenguaje SQL
		//dentro de esta cadena tipo String llamado sql le pasaremos que ingresaremos
		//Muy importante pasar por parametros todos los campos de atributos que contenga
		//la clase carro, esto es obligatorio, pasarle como parametros los campos
		//que se manipularan en la tabla
		String sql = "INSERT INTO vehiculo (placa, tipovehiculo, marca, modelo, color, precio, numPuertas, numValvulas) " 
					+ "VALUES (?,?,?,?,?,?,?,?)";
		
		//Se crea un objeto de tipo PreparedStatement llamado ps
		//este sera igual a this.conexion a un objeto que tiene una conexion 
		//activa a base de datos y se llama a el metodo creado en la clase Conexion
		//llamado getPreparedStatement, donde le pasaremos como parametros la cadena
		//de texto creada en la variable String sql. al pasarle entonces este 
		//parametro se ira hasta donde esta el parametro y me retornada esa cadena que le pasamos
		//entonces la variable ps ya tendra un objeto para poder realizar operaciones
		//dentro de la base de datos
		
		PreparedStatement ps = conexion.getPreparedStatement(sql);
		try {
			
			//estando dentro del objeto ps tipo PreparedStatement realizaremos 
			//la operaciones que necesitemos hacer dentro de la tabla que mencionamos
			//dentro de la cadena String sql
			//Ahora lo que se hace es llamar al objeto ps que tiene el PreparedStatement
			//y por cada campo ir pasandole los campos que vamos a a gregar en la tabla
			ps.setString(1, carro.getPlaca());
			//este segundo campo es el numero de tipo de vehiculo, entonces el numero 1 es un 
			//vehiculo de tipo carro por eso se le asigno directamente el valor
			ps.setInt(2, 1);
			ps.setString(3, carro.getMarca());
			ps.setString(4, carro.getModelo());
			ps.setString(5, carro.getColor());
			ps.setFloat(6, carro.getPrecio());
			ps.setInt(7, carro.getNumPuertas());
			ps.setInt(8, carro.getNumValvulas());
			
			//Esta linea es para decir por medio de este metodo, ejecute todas las instrucciones
			//anteriormente generadas para que se ingrese 
			ps.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			//Finalmente cerramos la conexion con el objeto PreparedStatement
			//obligatoriamente siempre se debe cerrar esta peticion o creacion de objeto
			//si no se cierra este objeto se quedara consumiendo recursos en base de datos
			
			conexion.cerrarPrepared(ps);
			conexion.cerrarConexion();
		}
	}
	
	
	
	//Metodo para realizar una consulta donde me recorrera la tabla vehiculo de la base de datos
	//en busca de una placa que sea de una vehiculo tipo carro

	public Carro buscarCarroByPlaca(String placa) {
		
		Conexion conexion = new Conexion();
		//Se crea una variable tipo String que tendra almacenado el comando SQL 
		//donde pedira buscar un carro de la base de datos prueba de la tabla vehiculo, donde 
		//se le dara una condicion que el carro que le devuelva sera uno que tenga una placa
		//que se le pasa como parametro y que tenga un campo de tipo vehiculo 1 que en otras
		//palabas 1 es igual a tipo de vehiculo carro. 
		//si la busqueda cumple con esos requisitos se retorna los datos a buscar
		String sql = "SELECT placa, tipovehiculo, marca, modelo, color, precio, numPuertas, numValvulas FROM " + 
						"prueba.vehiculo WHERE placa = '" + placa + "' AND tipovehiculo = 1";
		
		//Se crea una variable tipo carro llamado car y se asigna null
		Carro car = null;
		
		//Se crea una variable tipo Statement llamada st donde sera igual a el atributo 
		//conexion creado dentro de la clase CarroDao y que llamara a el metodo
		//getStatement donde me creara un objeto para poder manipular la base de datos
		
		Statement st = conexion.getStatement();
		
		try {
			
			//Se crea un objeto tipo Resulset llamado rs para guardar la busqueda 
			//que se almacenara en el objeto Statement st donde se le pasara como busqueda 
			//la cadena llamada sql anteriormente creada para buscar un carro especificamente
			ResultSet rs = st.executeQuery(sql);	
			
			//Al momento de nosotros crear una variable para guardar la busqueda 
			//tenemos que decirle por donde debe empezar a realizar la busqueda
			//asi que dentro de un bucle While llamamos a ese comando para realizar la busqueda 
			//y le diremos que empiece desde el primer registro de la tabla con el comando
			// llamado next() que nos ayudara a posicionarnos al inicio de la tabla
			while(rs.next()) {
				//llamaremos al objeto car creado anteriormente y lo inicializaremos
				//lo prepararemos para manipular sus atributos y metodos
				//y dentro de este nuevo objeto ALMACENAREMOS  la consulta a base de datos
				car = new Carro();
				
				//asi que dentro este objeto le asignaremos los valores que se encontraron 
				//en la busqueda que se realizo en la base de datos de la tabla vehiculo
				// se asigna una placa donde es la placa obtenida por la variable rs.getString"placa"
				//y asi seguidamente 
				car.setPlaca(rs.getString("placa"));
				car.setMarca(rs.getString("marca"));
				car.setModelo(rs.getString("modelo"));
				car.setColor(rs.getString("color"));
				car.setPrecio(rs.getFloat("precio"));
				car.setNumPuertas(rs.getInt("numPuertas"));
				car.setNumValvulas(rs.getInt("numValvulas"));
								
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			//Finalmente cerraremos o eliminaremos ese objeto statement st que nos permite 
			//manipular la base de datos
			conexion.cerrarConexion(st);
		}
		//Despues de toda esa consulta retornaremos la instancia de tipo carro con
		//todos los valores anteriormente buscados dentro de la tabla vehiculo
		//el objeto car tendra entonces solamente la consulta realizada
		return car;
	}
	
	
	
	
	
	//Metodo para actualizar un carro existente en base de datos
	
	public boolean actualizarCarro(Carro carro) {
		
		Conexion conexion = new Conexion();
		
		//Se crea una variable boolean para verificar si fue posible la actualizacion
		boolean exito = false;
		
		//Se crea una variable con el codigo sql para modificar un registro
		String sql = "UPDATE prueba.vehiculo " + 
					 "SET marca = ?, " + 
					 "  modelo = ?, " + 
					 "  color = ?, " + 
					 "  precio = ?, " + 
					 "  numPuertas = ?, " + 
					 "  numValvulas = ?  " + 
				     "WHERE placa = ? ";
		
		//se crea un objeto PreparedStatement para crear un objeto que manipulara la base de 
		//datos
		PreparedStatement ps = conexion.getPreparedStatement(sql);
		
		
		try {		
			//Se adiciona entonces los nuevos datos dentro de los campos consultados en la 
			//base de datos, es decir consultamos los parametros que tiene almacenado el objeto carro
			ps.setString(1, carro.getMarca());
			ps.setString(2, carro.getModelo());
			ps.setString(3, carro.getColor());
			ps.setFloat(4, carro.getPrecio());
			ps.setInt(5, carro.getNumPuertas());
			ps.setInt(6, carro.getNumValvulas());
			ps.setString(7, carro.getPlaca());
			//comando para aplicar las instrucciones
			ps.execute();

			//la variable exito sera true por que efectivamente se modifiracon los campos
			exito = true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			//si no se pudo realizar la actualizacion me retornada un false la operacion de actualizar
			exito = false;
			
		}finally {
			
			//se ciera la conexion a base de datos y del PreparedStatement
			conexion.cerrarPrepared(ps);
			conexion.cerrarConexion();
		}		
		
		//se retorna exito si el metodo se ejecuta correctamente
		return exito;
	}
	
	
	
	
	
	//Metodo para traer todos los registros de una base de datos y almacenarlos dentro de una 
	//lista cuando tienen una marca especifica
	
	public List<Carro> buscarCarroByMarca(String marca) {
		
		
		Conexion conexion = new Conexion();
		//Se crea un comando que contiene el codigo para realizar la consulta por 
		//lenguaje SQL dentro de la base de datos
		String sql = "SELECT placa, tipovehiculo, marca, modelo, color, precio, numPuertas, numValvulas FROM " + 
						"prueba.vehiculo WHERE marca = '" + marca + "' AND tipovehiculo = 1";
		
		//Se crea una lista de clase Carro llamada lstCarros
		//y se instancia para podela manipular
		
		List<Carro> lstCarros = new ArrayList<Carro>();
		//Se crea un objeto de clase Carro llamado car y se asigna un valor null
		Carro car = null;
		
		//Se crea un objeto de tipo Statement para poder manipular la base de datos
		//este sera igual a crear un nuevo objeto st
		Statement st = conexion.getStatement();
		
		try {
			
			//Se crea un objeto tipo Resulset llamado rs que me guardara la operacion
			//obtenida por el objeto Statement donde se le paso como parametro el objeto
			//sql que contiene un comando de busqueda
			ResultSet rs = st.executeQuery(sql);
			
			//Se crea un bucle donde comenzara por el primer registro de la tabla
			while(rs.next()) {
				//Se inicializa el objeto car anteriormente 
				//creado que para guardar lo que se genero como busqueda en 
				//la base de datos llamado car
				car = new Carro();
				car.setPlaca(rs.getString("placa"));
				car.setMarca(rs.getString("marca"));
				car.setModelo(rs.getString("modelo"));
				car.setColor(rs.getString("color"));
				car.setPrecio(rs.getFloat("precio"));
				car.setNumPuertas(rs.getInt("numPuertas"));
				car.setNumValvulas(rs.getInt("numValvulas"));
				//Ahora como se conoce cuales son los registros que contienen
				//determinada marca, se almacenaran dentro de una lista llamada lstCarros
				lstCarros.add(car);		
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			//se anula o destruye el objeto statement para cerrar la manipulacion de la 
			//base de datos
			conexion.cerrarStatement(st);
		}
		//retornaremos entonces una lista con todos los registro que contengan 
		//una determinada marca
		return lstCarros;
	}
	
	

}
