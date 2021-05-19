package objetos;

import java.sql.Date;

public class Facturas {
	public int id;
	public Date fecha;
	public int TPC;
	public int total;
	public int subtotal;
	public int iva;
	
	
	
	public Facturas(int id, Date fecha, int tPC, int total, int subtotal, int iva) {
		super();
		this.id = id;
		this.fecha = fecha;
		TPC = tPC;
		this.total = total;
		this.subtotal = subtotal;
		this.iva = iva;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getTPC() {
		return TPC;
	}
	public void setTPC(int tPC) {
		TPC = tPC;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	
	
	
}
