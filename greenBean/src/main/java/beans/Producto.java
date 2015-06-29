package beans;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "producto")
public class Producto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idProducto;
	private String nombre;
	private Medida medida;
	private byte[] imagen;
	private List<Precio> precios= new ArrayList<Precio>(0);
	private int stock;
	private String descripcion;
	private boolean activo=true;
	private Map<Cliente,Integer> visitas = new HashMap<Cliente,Integer>();

	private List<Categoria> categorias = new ArrayList<Categoria>(0);
	
	private List<Pedido> ventas = new ArrayList<Pedido>(0);
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idProducto", unique = true, nullable = false)
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
    @ManyToOne
	@JoinColumn(name = "idMedida")
	public Medida getMedida() {
		return medida;
	}
    
	public void setMedida(Medida medida) {
		this.medida = medida;
	}
	
	@Lob
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	

	@ManyToMany(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(
			name="producto_categoria",
		    joinColumns={@JoinColumn(name="idProducto", referencedColumnName="idProducto")},
		    inverseJoinColumns={@JoinColumn(name="idCategoria", referencedColumnName="idCategoria")})
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	@JoinTable(name="prod_pedido",
		joinColumns={
			@JoinColumn(name="idProducto", referencedColumnName="idProducto")
			},
		inverseJoinColumns={
			@JoinColumn(name="idPedido", referencedColumnName="idPedido")
			})
	@ManyToMany
	public List<Pedido> getVentas() {
		return ventas;
	}
	public void setVentas(List<Pedido> ventas) {
		this.ventas = ventas;
	}
	
	@OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Precio> getPrecios() {
		return precios;
	}
	public void setPrecios(List<Precio> precios) {
		this.precios = precios;
	}	
	
	public Producto(){
		
	}
	
	public Producto (String nombre, int stock){
		this.nombre=nombre;
		this.stock=stock;
	}
	
	@ElementCollection(fetch = FetchType.LAZY)
	@LazyCollection(LazyCollectionOption.FALSE)
	public Map<Cliente,Integer> getVisitas() {
		return visitas;
	}
	public void setVisitas(Map<Cliente,Integer> visitas) {
		this.visitas = visitas;
	}

}
