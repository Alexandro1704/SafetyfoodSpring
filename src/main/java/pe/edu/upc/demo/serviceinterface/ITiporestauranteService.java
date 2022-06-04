package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Tiporestaurante;

public interface ITiporestauranteService {

	public void insert(Tiporestaurante tiporestaurante);

	public List<Tiporestaurante> list();

	public void delete(int idTiporestaurante);

	Optional<Tiporestaurante> listId(int idTiporestaurante);
	
	public void update(Tiporestaurante tiporestaurante);
	
	
}
