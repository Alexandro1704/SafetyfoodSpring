package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Plato;
import pe.edu.upc.demo.repositories.IPlatoRepository;
import pe.edu.upc.demo.serviceinterface.IPlatoService;

@Service
public class PlatoServiceImpl implements IPlatoService{

	@Autowired
	private IPlatoRepository platoRepository;
	
	@Override
	public void insert(Plato plato) {
		platoRepository.save(plato);
		
	}

	@Override
	public List<Plato> list() {
		// TODO Auto-generated method stub
		return platoRepository.findAll();
	}

	@Override
	public void delete(int idPlato) {
		// TODO Auto-generated method stub
		platoRepository.deleteById(idPlato);
	}

	@Override
	public Optional<Plato> listId(int idPlato) {
		// TODO Auto-generated method stub
		return platoRepository.findById(idPlato);
	}

	@Override
	public void update(Plato plato) {
		// TODO Auto-generated method stub
		platoRepository.save(plato);
	}

	

}
