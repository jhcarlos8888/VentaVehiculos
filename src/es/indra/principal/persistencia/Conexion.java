package es.indra.principal.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



public class Conexion {
	
	//Se crea un atributo tipo Connection, este atributo es del
	//java.sql.Connection que sirve para realizar una conexion
	//a bases de datos relacionales SQL, donde se crea para mantener activa
	//solamente una sola conexion a base de datos
	//Este atributo es el que generara las sesiones en la base de datos
	private Connection con;
	
	
	
	private boolean conPool = true;
	
	//Se crea un constructor que internamente se llama a un metodo publico 
	//llamado getConexion
	
	
	
	//Constructor que tendra una condicional donde si el atributo conPool es 
	//verdadero entonces se iniciara una conexion tipo Pool de varias conexiones abiertas
	public Conexion() {
	

			if(conPool)
				this.iniciarConexionPool();
			else
				this.getConexion();	
		
	}

	
	
	//se crea un metodo que devolvera un objeto tipo Connection
	//llamado getConexion, este trabajara con el atributo con 
	//creado anteriormente
	
	public void iniciarConexion() {
		
		
		//Se crea una condicional donde pregunta si this.con esta vacio entonces crear
		//una nueva conexion a base de datos donde se tendran los datos para poder 
		//acceder si con == a null si no tiene nada entonces se ejecuta el codigo
		//es decir si no se tiene una conexion a base de datos
		
			
			
			
			//jdbc:mariadb://localhost:3306/DBName?user=root&password=myPassword
			String url = DatosConexion.URLPREFIJO + DatosConexion.HOST + DatosConexion.DOSPUNTOS + DatosConexion.PUERTO + DatosConexion.SLASH +
					DatosConexion.BD + DatosConexion.PREGUNTA + DatosConexion.USER + DatosConexion.AND + DatosConexion.PASSWORD;
			
			System.out.println("URL de conexion: " + url);
			
			
			try {
				
				
				//Se activa el Driver para pode manipular la base de datos 
				//donde la direccion de el driver se encuentra en la clase 
				//DatosConexion
				Class.forName(DatosConexion.DRIVER);
				
				//Luego se le asigna a el atributo con la uRL para crear una conexion a base
				//de datos, donde se llama a la clase DriverMaganer para traer una nueva conexion
				//donde se le pasa como parametro la varible String url que contiene todos
				//los datos de acceso, entonces ya con esto tenemos una conexion activa
				this.con = DriverManager.getConnection(url);
				
				
				//Se crea una catch para poder guardar el error en caso de que pase
				//algo con la conexion
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
				
				//Si se tiene un error la conexion no sera creada y se asigna un null
				//Mostrara errores SQL Exception
				this.con = null;
			}			
		

	}
	
	
	
	
	
	@SuppressWarnings("static-access")
	public void iniciarConexionPool() {
		
		this.con = Pool.getInstancia().getConexion();
		
	}
	
	
	
	
	public Connection getConexion() {
		
		if(this.con == null) {
			this.iniciarConexion();
		}
		
		return this.con;
	}
	
	
	//Este metodo cierra una conexion a base de datos
	
	public void cerrarConexion() {
				
		try {
			
			if(con != null) {
				con.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}
	
	
	
	//Se crea un metodo de tipo Statement para realizar operaciones dentro la base
	//de datos como un CRUD, este es un objeto para poder manipular la base de datos
	
	public Statement getStatement() {
		
		//Primero declaramos un objeto Statement st y le damos un valor null
		Statement st = null;
		
		
		try {
			//a este objeto se le asigna el atributo con que llama a una
			//funcion createStatement a partir de una conexion anteriormente
			//creada
			st = this.con.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//Entonces se retorna el Statement que se llamo 
		return st;
	}
	
	
	
	
	//se crea un metodo para cerrar un statement que recibe por parametro
	//un objeto Statement
	
	public void cerrarStatement(Statement statement) {
				
		try {
			if(statement != null)
				statement.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	//getPreparedStatement es practicamente lo mismo que hace 
	//el metodo getStatement, pero al crearse un metodo PreparedStatement
	//no crea autamaticamente un constructor vacio, entonces tiene que recibir
	//un objeto string sql para poder funcionar, como por ejemplo un Insert, Update, Delete
	//entre otro comando de lenguaje SQL para poder realizar una funcion especifica
	//De hecho esto nos servira para manipular mejor un objeto que lo necesitemos 
	// y ya tenga una plantilla predefinida
	
	
	public PreparedStatement getPreparedStatement(String sql) {
		
		//Se declara el objeto y se inicializa con null
		
		PreparedStatement ps = null;
		try {
			//se asigna al objeto un objeto sql pasado anteriormente por parametro
			//esto entonces se activa para poder funcionar correctamente
			ps = this.con.prepareStatement(sql);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return ps;		
		
	}
	
	
	//metodo para cerrar el preparedStatement donde recibe como parametro un objeto 
	//creado anteriormente 
	public void cerrarPrepared(PreparedStatement ps) {
		
		try {
			if(ps != null)
				ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}
	
	
	//Ahora se sobrecargara un metodo creado anteriormente llamado cerrarConexion
	//antes vimos que cerraba una conecion a base de datos, tambien con el mismo
	//nombre del metodo, podemos reutilizarlo y pasarle como parametros un objeto Statement
	//y cerrar o anular la instancia de este objeto
	//Con este metodo se cierra conexion a base de datos y se anula la creacion de un objeto
	//tipo statement para poder manipular una base de datos
	
	public void cerrarConexion(Statement st) {
		
		try {
			//condicion si st esta activa o tiene algo en Ram entonces anule o cierre 
			//ese objeto que esta relacionado a un funcionamiento de base de datos
			if(st != null)
				st.close();
			
			//nuevamente si con, osea existe una conexion entonces tambien cierre esa conexion a 
			//base de datos 
			if(con != null) 
				con.close();			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
	}
	
}
