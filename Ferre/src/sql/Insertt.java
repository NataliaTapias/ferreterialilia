package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import objetos.Gastos;
import objetos.Productos;
import objetos.Usuarios;

public class Insertt {

	Conexion con=new Conexion();
	Connection conn=con.conectarMySQL();
	PreparedStatement preparedStmt ;
	
	public boolean NuevoUsuario(Usuarios nuevo) throws SQLException{
		String query = "INSERT INTO `usuarios` (`nombres`, `cedula`, `direccion`, `tel`, `contemer`, `tipo`, `correo`, `contra`, `creadoEn`, `actuEn`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
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
	      preparedStmt.execute();
	      JOptionPane.showMessageDialog(null, "Usuario Creado");
	      return true;
	     
	}
	public boolean NuevoGasto(Gastos nuevo) throws SQLException{
		
		String query = "INSERT INTO `gastos` (`quien`, `cuanto`, `porque`, `tipo`, `fecha`, `usuarios_idusuarios`) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
	      preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString(1, nuevo.getQuien());
	      preparedStmt.setInt(2, nuevo.getCuanto());
	      preparedStmt.setString(3, nuevo.getPorque());
	      preparedStmt.setString(4, nuevo.getTipo());
	      preparedStmt.setDate(5, nuevo.getFecha());
	      preparedStmt.setInt(6, nuevo.getUsuarios_idusuarios());
	      preparedStmt.execute();
	      JOptionPane.showMessageDialog(null, "Registro Guardado");
	     return true;
	}
	
	public boolean NuevoProducto(Productos nuevo) throws SQLException{
		String query = "INSERT INTO `ferre`.`productos` (`nombres`, `descripcion`, `preciocompra`, `cantidad`, `limite`,`precioventa`, `fechaproducto`, `usuarios_idusuarios`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	      preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString(1, nuevo.getNombres());
	      preparedStmt.setString(2, nuevo.getDescripcion());
	      preparedStmt.setInt(3, nuevo.getPreciocompra());
	      preparedStmt.setInt(4, nuevo.getCantidad());
	      preparedStmt.setInt(5, nuevo.getLimite());
	      preparedStmt.setInt(6, nuevo.getPrecioventa());
	      preparedStmt.setDate(7, nuevo.getFechaproducto());
	      preparedStmt.setInt(8, nuevo.getUsuarios_idusuarios());
	      preparedStmt.execute();
	      JOptionPane.showMessageDialog(null, "Producto Creado");
	     
	      return true;
	}
	
}
