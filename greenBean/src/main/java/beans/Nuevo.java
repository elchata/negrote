package beans;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Nuevo extends Estado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String detalle;
	
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	

}
