package sql;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import objetos.Facturas;
import objetos.Gastos;
import objetos.Usuarios;
import objetos.Productos;
import sql.Conexion;

public class Select {
	
	Conexion con=new Conexion();
	Connection conn=con.conectarMySQL();
	Statement stmt = null;
	ResultSet rs = null;
	
	public Usuarios Login(String user, String pass){
		Usuarios nuevo = null;
		nuevo=new Usuarios("noes","noes","noes","noes","noes","noes","noes","noes","noes","0000-00-00 00:00:00","0000-00-00 00:00");
		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM usuarios WHERE correo='"+user+"' AND contra='"+pass+"';");
		    while (rs.next()) {
		    	int idu=rs.getInt("idusuarios");
		    	String idus=Integer.toString(idu);
		    	String nombre = rs.getString("nombres");
		    	String cedula = rs.getString("cedula");
		    	String direccion = rs.getString("direccion");
		    	String tel = rs.getString("tel");
		    	String contactoEmergencia = rs.getString("contemer");
		    	String tipo = rs.getString("tipo");
		    	String correo = rs.getString("correo");
		    	String contra = rs.getString("contra");
		    	String creadoEn = rs.getTimestamp("creadoEn").toString();
		    	String ActuEn = rs.getTimestamp("ActuEn").toString();
		    	 nuevo=new Usuarios(idus,nombre,cedula,direccion,tel,contactoEmergencia,tipo,correo,contra,creadoEn,ActuEn);
		    	
		    }
		}
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return nuevo;
	}
	
	public ArrayList<Usuarios> usuarios(){
		Usuarios nuevo = null;
		ArrayList<Usuarios> array = new ArrayList<Usuarios>();
		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM usuarios;");
		    while (rs.next()) {
		    	String idus=rs.getString("idusuarios");
		    	String nombre = rs.getString("nombres");
		    	String cedula = rs.getString("cedula");
		    	String direccion = rs.getString("direccion");
		    	String tel = rs.getString("tel");
		    	String contactoEmergencia = rs.getString("contemer");
		    	String tipo = rs.getString("tipo");
		    	String correo = rs.getString("correo");
		    	String contra = rs.getString("contra");
		    	String creadoEn = rs.getTimestamp("creadoEn").toString();
		    	String ActuEn = rs.getTimestamp("ActuEn").toString();
		    	nuevo=new Usuarios(idus,nombre,cedula,direccion,tel,contactoEmergencia,tipo,correo,contra,creadoEn,ActuEn);
		    	
		    	array.add(nuevo);
		    	
		    }
		}
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return array;
		
	}
	
	public ArrayList<Usuarios> CedulaUsuarios(String cedu){
		Usuarios nuevo = null;
		ArrayList<Usuarios> array = new ArrayList<Usuarios>();
		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM usuarios WHERE cedula='"+cedu+"';");
		    while (rs.next()) {
		    	String idus=rs.getString("idusuarios");
		    	String nombre = rs.getString("nombres");
		    	String cedula = rs.getString("cedula");
		    	String direccion = rs.getString("direccion");
		    	String tel = rs.getString("tel");
		    	String contactoEmergencia = rs.getString("contemer");
		    	String tipo = rs.getString("tipo");
		    	String correo = rs.getString("correo");
		    	String contra = rs.getString("contra");
		    	String creadoEn = rs.getTimestamp("creadoEn").toString();
		    	String ActuEn = rs.getTimestamp("ActuEn").toString();
		    	nuevo=new Usuarios(idus,nombre,cedula,direccion,tel,contactoEmergencia,tipo,correo,contra,creadoEn,ActuEn);
		    	
		    	array.add(nuevo);
		    	
		    }
		}
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return array;
		
	}
	
	public ArrayList<Gastos> gastos(){
		Gastos nuevo = null;
		ArrayList<Gastos> array = new ArrayList<Gastos>();
		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM gastos;");
		    while (rs.next()) {
		    	String quien = rs.getString("quien");
		    	int cuanto = rs.getInt("cuanto");
		    	String porque = rs.getString("porque");
		    	String tipo = rs.getString("tipo");
		    	Date fecha = rs.getDate("fecha");
		    	int usuario = rs.getInt("usuarios_idusuarios");
		    	nuevo=new Gastos(quien,cuanto,porque,tipo,fecha,usuario);
		    	
		    	array.add(nuevo);
		    	
		    }
		}
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return array;
	}
	
	public ArrayList<Productos> Productos(){
		Productos nuevo = null;
		ArrayList<Productos> array = new ArrayList<Productos>();
		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM productos;");
		    while (rs.next()) {
		    	int id = rs.getInt("idproductos");
		    	String nombres = rs.getString("nombres");
		    	String descripcion = rs.getString("descripcion");
		    	int pcompra = rs.getInt("preciocompra");
		    	int cantidad = rs.getInt("cantidad");
		    	int limite= rs.getInt("limite");
		    	int pventa = rs.getInt("precioventa");
		    	Date fecha = rs.getDate("fechaproducto");
		    	int usuario = rs.getInt("usuarios_idusuarios");
		    	
		    	nuevo=new Productos(id,nombres,descripcion,pcompra,pventa,fecha,cantidad,limite,usuario);
		    	
		    	array.add(nuevo);
		    	
		    }
		}
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return array;
	}
	
	public ArrayList<Productos> idProductos(int id){
		Productos nuevo = null;
		ArrayList<Productos> array = new ArrayList<Productos>();
		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM productos WHERE idproductos='"+id+"';");
		    while (rs.next()) {
		    	int idd = rs.getInt("idproductos");
		    	String nombres = rs.getString("nombres");
		    	String descripcion = rs.getString("descripcion");
		    	int pcompra = rs.getInt("preciocompra");
		    	int cantidad = rs.getInt("cantidad");
		    	int limite= rs.getInt("limite");
		    	int pventa = rs.getInt("precioventa");
		    	Date fecha = rs.getDate("fechaproducto");
		    	int usuario = rs.getInt("usuarios_idusuarios");
		    	nuevo=new Productos(idd,nombres,descripcion,pcompra,pventa,fecha,cantidad,limite,usuario);
		    	
		    	array.add(nuevo);
		    	
		    }
		}
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return array;
		
	}
	
	public ArrayList<Productos> nomProductos(String nom){
		Productos nuevo = null;
		ArrayList<Productos> array = new ArrayList<Productos>();
		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM productos WHERE nombres='"+nom+"';");
		    while (rs.next()) {
		    	int idd = rs.getInt("idproductos");
		    	String nombres = rs.getString("nombres");
		    	String descripcion = rs.getString("descripcion");
		    	int pcompra = rs.getInt("preciocompra");
		    	int cantidad = rs.getInt("cantidad");
		    	int limite= rs.getInt("limite");
		    	int pventa = rs.getInt("precioventa");
		    	Date fecha = rs.getDate("fechaproducto");
		    	int usuario = rs.getInt("usuarios_idusuarios");
		    	nuevo=new Productos(idd,nombres,descripcion,pcompra,pventa,fecha,cantidad,limite,usuario);
		    	
		    	array.add(nuevo);
		    	
		    }
		}
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return array;
		
	}
	public ArrayList<Gastos> gastosFech(String fecha1,String fecha2){
		Gastos nuevo = null;
		ArrayList<Gastos> array = new ArrayList<Gastos>();
		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM ferre.gastos where fecha between '"+fecha1+"' and '"+fecha2+"';");
		    while (rs.next()) {
		    	String quien = rs.getString("quien");
		    	int cuanto = rs.getInt("cuanto");
		    	String porque = rs.getString("porque");
		    	String tipo = rs.getString("tipo");
		    	Date fecha = rs.getDate("fecha");
		    	int usuario = rs.getInt("usuarios_idusuarios");
		    	nuevo=new Gastos(quien,cuanto,porque,tipo,fecha,usuario);
		    	
		    	array.add(nuevo);
		    	
		    }
		}
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return array;
	}
	public ArrayList<Facturas> facturaFech(String fecha1,String fecha2){
		Facturas nuevo = null;
		ArrayList<Facturas> array = new ArrayList<Facturas>();
		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM ferre.factura where fecha between '"+fecha1+"' and '"+fecha2+"';");
		    while (rs.next()) {
		    	int id=rs.getInt("idfactura");
		    	Date fecha = rs.getDate("fecha");
		    	int TPC = rs.getInt("TPC");
		    	int total = rs.getInt("total");
		    	int subtotal = rs.getInt("subtotal");
		    	int iva = rs.getInt("iva");
		    	nuevo=new Facturas(id,fecha,TPC,total,subtotal,iva);
		    	
		    	array.add(nuevo);
		    	
		    }
		}
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return array;
		
	}
	public ArrayList<Productos> ProductosFech(String fecha1,String fecha2){
		Productos nuevo = null;
		ArrayList<Productos> array = new ArrayList<Productos>();
		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery("SELECT * FROM ferre.productos where fechaproducto between '"+fecha1+"' and '"+fecha2+"';");
		    while (rs.next()) {
		    	int id = rs.getInt("idproductos");
		    	String nombres = rs.getString("nombres");
		    	String descripcion = rs.getString("descripcion");
		    	int pcompra = rs.getInt("preciocompra");
		    	int cantidad = rs.getInt("cantidad");
		    	int limite= rs.getInt("limite");
		    	int pventa = rs.getInt("precioventa");
		    	Date fecha = rs.getDate("fechaproducto");
		    	int usuario = rs.getInt("usuarios_idusuarios");
		    	
		    	nuevo=new Productos(id,nombres,descripcion,pcompra,pventa,fecha,cantidad,limite,usuario);
		    	
		    	array.add(nuevo);
		    	
		    }
		}
		catch (SQLException ex){
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return array;
	}
	
	public static void main(String[] args) {
		Select he=new Select();
		ArrayList<Usuarios> ho=he.usuarios();
		
		
		Iterator<Usuarios> nombreIterator = ho.iterator();
		while(nombreIterator.hasNext()){
			Usuarios elemento = nombreIterator.next();
			System.out.print(elemento.getNombres()+" / ");
		}
	}
}
