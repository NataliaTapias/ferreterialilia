package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import objetos.Productos;
import objetos.Usuarios;

public class Update {

	
	Conexion con=new Conexion();
	Connection conn=con.conectarMySQL();
	PreparedStatement preparedStmt ;
	
	public boolean ActuUsuario(Usuarios nuevo) throws SQLException{
		String query = "UPDATE usuarios SET nombres=?, cedula=?, direccion=?, tel=?, contemer=?, tipo=?, correo=?, contra=?, creadoEn=?, actuEn=? WHERE (cedula=?);";
	      preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString(1, nuevo.getNombres());
	      preparedStmt.setString(2, nuevo.getCedula());
	      preparedStmt.setString(3, nuevo.getDireccion());
	      preparedStmt.setString(4, nuevo.getTel());
	      preparedStmt.setString(5, nuevo.getContemer());
	      preparedStmt.setString(6, nuevo.getTipo());
	      preparedStmt.setString(7, nuevo.getCorreo());
	      preparedStmt.setString(8, nuevo.getContra());
	      preparedStmt.setString(9, nuevo.getCreadoEn());
	      preparedStmt.setString(10, nuevo.getActuEn());
	      preparedStmt.setString(11, nuevo.getCedula());
	      preparedStmt.executeUpdate();
	      JOptionPane.showMessageDialog(null, "Usuario Actualizado");
	     return true;
	}
	
	public boolean ActuProducto(Productos nuevo) throws SQLException{
		String query = "UPDATE `productos` SET `nombres`=?, `descripcion`=?, `preciocompra`=?, `cantidad`=?, `limite`=?, `precioventa`=?, `fechaproducto`=?, `usuarios_idusuarios`=? WHERE `idproductos`=?";
	      preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString(1, nuevo.getNombres());
	      preparedStmt.setString(2, nuevo.getDescripcion());
	      preparedStmt.setInt(3, nuevo.getPreciocompra());
	      preparedStmt.setInt(4, nuevo.getCantidad());
	      preparedStmt.setInt(5, nuevo.getLimite());
	      preparedStmt.setInt(6, nuevo.getPrecioventa());
	      preparedStmt.setDate(7, nuevo.getFechaproducto());
	      preparedStmt.setInt(8, nuevo.getUsuarios_idusuarios());
	      preparedStmt.setInt(9, nuevo.getId());
	      preparedStmt.executeUpdate();
	      JOptionPane.showMessageDialog(null, "Producto Actualizado");
	     return true;
	}
	
	
}
