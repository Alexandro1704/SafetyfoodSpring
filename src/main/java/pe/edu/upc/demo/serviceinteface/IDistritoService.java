package pe.edu.upc.demo.serviceinteface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Distrito;

public interface IDistritoService {

	public void insert(Distrito distrito);

	public List<Distrito> list();

	public void delete(int idDistrito);

	Optional<Distrito> listId(int idDistrito);
	
	public void update(Distrito distrito);
	
	
}
