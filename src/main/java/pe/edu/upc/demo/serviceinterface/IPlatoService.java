package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Plato;

public interface IPlatoService {

	public void insert(Plato plato);

	public List<Plato> list();

	public void delete(int idPlato);

	Optional<Plato> listId(int idPlato);
	
	public void update(Plato plato);
	
	
}
