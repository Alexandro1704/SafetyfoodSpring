package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Tipocertificado;

public interface ITipocertificadoService {

	public void insert(Tipocertificado tipocertificado);

	public List<Tipocertificado> list();

	public void delete(int idTipocertificado);

	Optional<Tipocertificado> listId(int idTipocertificado);
	
	public void update(Tipocertificado tipocertificado);
	
	
}