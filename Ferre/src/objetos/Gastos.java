package objetos;

import java.sql.Date;

public class Gastos {
	public String quien;
	public int cuanto;
	public String porque;
	public String tipo;
	public Date fecha;
	public int usuarios_idusuarios;
	public Gastos(String quien, int cuanto, String porque, String tipo, Date fecha, int usuarios_idusuarios) {
		super();
		this.quien = quien;
		this.cuanto = cuanto;
		this.porque = porque;
		this.tipo = tipo;
		this.fecha = fecha;
		this.usuarios_idusuarios = usuarios_idusuarios;
	}
	public String getQuien() {
		return quien;
	}
	public void setQuien(String quien) {
		this.quien = quien;
	}
	public int getCuanto() {
		return cuanto;
	}
	public void setCuanto(int cuanto) {
		this.cuanto = cuanto;
	}
	public String getPorque() {
		return porque;
	}
	public void setPorque(String porque) {
		this.porque = porque;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getUsuarios_idusuarios() {
		return usuarios_idusuarios;
	}
	public void setUsuarios_idusuarios(int usuarios_idusuarios) {
		this.usuarios_idusuarios = usuarios_idusuarios;
	}
	
}
