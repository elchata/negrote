package implementaciones;

import org.springframework.stereotype.Repository;
 
import daos.ProductoDAO; 
import beans.Producto;

@Repository(value = "productoModel")
public class ProductoDAOHibernateJPA extends GenericDAOHibernateJPA<Producto>  implements ProductoDAO {		
	
		public ProductoDAOHibernateJPA() {
			super(Producto.class);
		}

}