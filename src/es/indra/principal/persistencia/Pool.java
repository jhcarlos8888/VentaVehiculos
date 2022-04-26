package es.indra.principal.persistencia;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Pool {
	
	
	//Se crea un atributo para poder guardar los datos para saber hacia donde se debe conectar
   //es decir el enlace hacia donde se conectara para generar el pool	
	private static HikariConfig config;
	
     // Ahora se crea un atributo datasource que seria el objeto que me manejara las 
	//conexiones a base de datos,es quien libera y ocupa 
	private static HikariDataSource ds;
	

	
	
	//Ahora se crea un constructor donde se iniciara un metodo llamado iniciarPool
	//donde sera el que iniciara una nueva conexion a base de datos
	public Pool() {
		
		iniciarPool();
	}
	

	
	public static void iniciarPool() {

		config = new HikariConfig();
		//config.setDataSourceClassName("org.mariadb.jdbc.MariaDbDataSource");
		config.setJdbcUrl("jdbc:mariadb://localhost:3306/prueba");
		config.setUsername("jcherrerab");
		config.setPassword("JuanC152022.+-*");
	
		
		
		//Esta propiedad me permite solamente entregar 12 conexiones activas
		//permitiendo liberar y gestionar mejor este tipo de acciones
		config.setMaximumPoolSize(12);
		//config.addDataSourceProperty("cachePrepStmts", "true");
		//config.addDataSourceProperty("prepStmtCacheSize", "250");
		//config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		//Ahora se inicializa el objeto ds datasource quien se encargara de dar 
		// la gestion y la creacion de el pool de conexiones
		ds = new HikariDataSource(config);
		
	}
	
	
	//Este metodo es para poder realizar una conexion a base de datos
	//inicara la conexion como un pool de conexiones
	public static Connection getConexion() {
		
		//Se crea un objeto tipo Connection sin inicializar
		Connection con;
		
		
		//en una condicion si el objeto ds no tiene nada, es decir si no
		// se tiene ninguna conexion activa a base de datos
		//se activa el metodo iniciar pool
		if(ds == null) {
			iniciarPool();			
		}
		
		try {
			//Ahora cojeremos el objeto con y le asignaremos el comando para activar
			//el pool de conexiones y acceso a la base de datos
			con = ds.getConnection();
		} catch (SQLException e) {
			
			//Si falla algo en la creacion de el objeto 
			// con entonces estara null
			e.printStackTrace();
			con = null;
		}
		
		return con;
	}
	
	
	
	
	//Se crea un metodo que no retorna nada y recibe por parametro un objeto 
	//tipo Connection, para cerrar una conexion de pool conexiones
	public static void cerrarConexion(Connection con) {
		
		if(con != null) {
			
			try {
				//Cerramos la conexion a base de datos
				con.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
	}
	
	
	//Metodo para cerrar o eliminar el objeto que almacena la cantidad 
	//de conexiones y 
	public static void cerrarDataSource() {
		
		if(ds != null)
			ds.close();
	}

}
