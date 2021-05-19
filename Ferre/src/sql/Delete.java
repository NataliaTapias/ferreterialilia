package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Delete {
	
	
	Conexion con=new Conexion();
	Connection conn=con.conectarMySQL();
	PreparedStatement preparedStmt ;
	
	public boolean EliminarUsuario(String cedula) throws SQLException{
		  String query = "DELETE FROM `usuarios` WHERE `cedula` = ?;";
	      preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString(1, cedula);
	      preparedStmt.execute();
	      JOptionPane.showMessageDialog(null, "Usuario Eliminado");
	      return true;
	}
	
	public boolean EliminarProducto(int id) throws SQLException{
		  String query = "DELETE FROM `productos` WHERE `idproductos` = ?;";
	      preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setInt(1, id);
	      preparedStmt.execute();
	      JOptionPane.showMessageDialog(null, "Producto Eliminado");
	      return true;
	}
	
}
