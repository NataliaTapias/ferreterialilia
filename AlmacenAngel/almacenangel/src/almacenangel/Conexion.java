package almacenangel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Librer?a de MySQL
    public String driver = "com.mysql.jdbc.Driver";
    // Nombre de la base de datos
    public String database = "almacenAngel";
    // Host
    public String hostname = "localhost";
    // Puerto
    public String port = "3306";
    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql:// localhost : 3306 /  almacenAngel ?useSSL=false";
    // Nombre de usuario
    public String username = "root";
    // Clave de usuario
    public String password = "31183283119";

    public Connection conectarMySQL() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("conectado");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
    public static void main(String[] args) {
		Conexion con = new Conexion();
		con.conectarMySQL();
	}
}