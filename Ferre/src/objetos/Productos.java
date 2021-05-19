package objetos;

import java.sql.Date;

public class Productos {
	public int id;
	public String nombres;
	public String descripcion;
	public int preciocompra;
	public int cantidad;
	public int limite;
	public int precioventa;
	public Date fechaproducto;
	public int usuarios_idusuarios;
	public Productos(int id, String nombres, String descripcion, int preciocompra,int precioventa, Date fechaproducto,int limite, int cantidad, int usuarios_idusuarios) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.descripcion = descripcion;
		this.preciocompra = preciocompra;
		this.cantidad = cantidad;
		this.limite = limite;
		this.precioventa = precioventa;
		this.fechaproducto = fechaproducto;
		this.usuarios_idusuarios = usuarios_idusuarios;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPreciocompra() {
		return preciocompra;
	}
	public void setPreciocompra(int preciocompra) {
		this.preciocompra = preciocompra;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getLimite() {
		return limite;
	}
	public void setLimite(int limite) {
		this.limite = limite;
	}
	public int getPrecioventa() {
		return precioventa;
	}
	public void setPrecioventa(int precioventa) {
		this.precioventa = precioventa;
	}
	public Date getFechaproducto() {
		return fechaproducto;
	}
	public void setFechaproducto(Date fechaproducto) {
		this.fechaproducto = fechaproducto;
	}
	public int getUsuarios_idusuarios() {
		return usuarios_idusuarios;
	}
	public void setUsuarios_idusuarios(int usuarios_idusuarios) {
		this.usuarios_idusuarios = usuarios_idusuarios;
	}
	
}
