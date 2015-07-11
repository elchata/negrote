package implementaciones;

import java.util.List;

import beans.Provincia;
import daos.ProvinciaDAO;

public class ProvinciaDAOHibernateJPA extends GenericDAOHibernateJPA<Provincia>
		implements ProvinciaDAO {

	public ProvinciaDAOHibernateJPA() {
		super(Provincia.class);
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

}
