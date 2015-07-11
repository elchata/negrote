package implementaciones;

<<<<<<< HEAD
import org.springframework.stereotype.Repository;
=======
import java.util.List;
>>>>>>> d5fd05378116bbfe132b15e9fc54ecad50742962

import beans.Provincia;
import daos.ProvinciaDAO;

<<<<<<< HEAD
@Repository(value = "provinciaModel")
=======
>>>>>>> d5fd05378116bbfe132b15e9fc54ecad50742962
public class ProvinciaDAOHibernateJPA extends GenericDAOHibernateJPA<Provincia>
		implements ProvinciaDAO {

	public ProvinciaDAOHibernateJPA() {
		super(Provincia.class);
<<<<<<< HEAD
	} 
=======
	}
	
	@Override
	public Provincia actualizar(Provincia entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Provincia persistir(Provincia entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Provincia> recuperarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Provincia retornarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Provincia retornarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Provincia borrar(Provincia entity) {
		// TODO Auto-generated method stub
		return null;
	}

>>>>>>> d5fd05378116bbfe132b15e9fc54ecad50742962
}
