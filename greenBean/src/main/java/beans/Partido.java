package beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name = "partido")
public class Partido implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idPartido;
	private String nombre;
	private Provincia provincia;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPartido", unique = true, nullable = false)
	public Long getIdPartido() {
		return idPartido;
	}
	public void setIdPartido(Long idPartido) {
		this.idPartido = idPartido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@ManyToOne
	@JoinColumn(name = "idProvincia")
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
	@Transient
	long auxProv;

	@Transient
	public long getAuxProv() {
		return auxProv;
	}
	@Transient
	public void setAuxProv(long auxProv) {
		this.auxProv = auxProv;
	}
	
	public Partido(){
		
	}
	

}
