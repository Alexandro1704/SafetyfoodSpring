package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Departamento;
import pe.edu.upc.demo.repositories.IDepartamentoRepository;
import pe.edu.upc.demo.serviceinterface.IDepartamentoService;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService{

	@Autowired
	private IDepartamentoRepository departamentoRepository;
	
	@Override
	public void insert(Departamento departamento) {
		departamentoRepository.save(departamento);
		
	}

	@Override
	public List<Departamento> list() {
		// TODO Auto-generated method stub
		return departamentoRepository.findAll();
	}

	@Override
	public void delete(int idDepartamento) {
		// TODO Auto-generated method stub
		departamentoRepository.deleteById(idDepartamento);
	}

	@Override
	public Optional<Departamento> listId(int idDepartamento) {
		// TODO Auto-generated method stub
		return departamentoRepository.findById(idDepartamento);
	}

	@Override
	public void update(Departamento departamento) {
		// TODO Auto-generated method stub
		departamentoRepository.save(departamento);
	}

	

}
