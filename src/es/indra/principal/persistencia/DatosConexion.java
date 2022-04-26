package es.indra.principal.persistencia;

/**
 * Constantes que definen los datos de conexion a la BD, esta no es una buena practica
 * lo normal es definirlas en un archivo .properties o yml
 * @author indra
 *
 */


public class DatosConexion {
	
	public static final String DRIVER = "org.mariadb.jdbc.Driver";
	public static final String URLPREFIJO = "jdbc:mariadb://";
	public static final String HOST = "localhost";
	public static final String PUERTO = "3306";
	public static final String BD = "prueba";
	public static final String USER = "user=jcherrerab";
	public static final String PASSWORD = "password=JuanC152022.+-*";
	public static final String DOSPUNTOS = ":";
	public static final String PREGUNTA = "?";
	public static final String AND = "&";
	public static final String SLASH = "/";

}
