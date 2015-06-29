package implementaciones;

import org.springframework.stereotype.Repository;
 
import daos.PedidoDAO; 
import beans.Pedido;

@Repository(value = "pedidoModel")
public class PedidaDAOHibernateJPA extends GenericDAOHibernateJPA<Pedido>  implements PedidoDAO {		
	
		public PedidaDAOHibernateJPA() {
			super(Pedido.class);
		}

}