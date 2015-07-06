package beans;

import java.util.Date;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "canasto")
public class Canasto extends Contenedor{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private byte[] imagen;
	private int descuento;
	private boolean activo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Canasto(Long id, Date fecha, Map<Producto, Integer> productos,
			String nombre, byte[] imagen, int descuento, boolean activo) {
		super(id, fecha, productos);
		this.nombre = nombre;
		this.imagen = imagen;
		this.descuento = descuento;
		this.activo = activo;
	}
	
	public Canasto(){
		
	}
	
	public double darPrecio(){
		double precio = super.darPrecio();
		return precio - (precio * descuento / 100);
	}
	
}
