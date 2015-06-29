package beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "medida")
public class Medida implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idMedida;
	private String nombre;
	private String abreviasion;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idMedida", unique = true, nullable = false)
	public Long getIdMedida() {
		return idMedida;
	}
	public void setIdMedida(Long idMedida) {
		this.idMedida = idMedida;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAbreviasion() {
		return abreviasion;
	}
	public void setAbreviasion(String abreviasion) {
		this.abreviasion = abreviasion;
	}
	
	public Medida(){		
	}
	
	public Medida(String nom, String abr){
		this.abreviasion=abr;
		this.nombre=nom;
	}
	

}
