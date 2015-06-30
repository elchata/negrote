package beans;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Nuevo extends Estado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String horario1;
	private String horario2;
	private String detalle;
	
	public String getHorario1() {
		return horario1;
	}
	public void setHorario1(String horario1) {
		this.horario1 = horario1;
	}
	public String getHorario2() {
		return horario2;
	}
	public void setHorario2(String horario2) {
		this.horario2 = horario2;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	

}
