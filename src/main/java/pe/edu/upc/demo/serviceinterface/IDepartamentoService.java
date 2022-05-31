package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.Departamento;

public interface IDepartamentoService {

	public void insert(Departamento departamento);

	public List<Departamento> list();

	public void delete(int idDepartamento);

	Optional<Departamento> listId(int idDepartamento);
	
	public void update(Departamento departamento);
	
	
}
