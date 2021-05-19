package objetos;

public class Usuarios {
	
	public String id;
	public String nombres;
	public String cedula;
	public String direccion;
	public String tel;
	public String contemer;
	public String tipo;
	public String correo;
	public String contra;
	public String creadoEn;
	public String actuEn;
	public Usuarios(String id, String nombres, String cedula, String direccion, String tel, String contemer, String tipo,
			String correo, String contra, String creadoEn, String actuEn) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.cedula = cedula;
		this.direccion = direccion;
		this.tel = tel;
		this.contemer = contemer;
		this.tipo = tipo;
		this.correo = correo;
		this.contra = contra;
		this.creadoEn = creadoEn;
		this.actuEn = actuEn;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getContemer() {
		return contemer;
	}
	public void setContemer(String contemer) {
		this.contemer = contemer;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	public String getCreadoEn() {
		return creadoEn;
	}
	public void setCreadoEn(String creadoEn) {
		this.creadoEn = creadoEn;
	}
	public String getActuEn() {
		return actuEn;
	}
	public void setActuEn(String actuEn) {
		this.actuEn = actuEn;
	}
	

}
