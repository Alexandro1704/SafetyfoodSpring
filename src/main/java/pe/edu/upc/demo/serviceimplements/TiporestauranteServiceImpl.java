package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Tiporestaurante;
import pe.edu.upc.demo.repositories.ITiporestauranteRepository;
import pe.edu.upc.demo.serviceinterface.ITiporestauranteService;

@Service
public class TiporestauranteServiceImpl implements ITiporestauranteService{

	@Autowired
	private ITiporestauranteRepository tiporestauranteRepository;
	
	@Override
	public void insert(Tiporestaurante tiporestaurante) {
		tiporestauranteRepository.save(tiporestaurante);
		
	}

	@Override
	public List<Tiporestaurante> list() {
		// TODO Auto-generated method stub
		return tiporestauranteRepository.findAll();
	}

	@Override
	public void delete(int idTiporestaurante) {
		// TODO Auto-generated method stub
		tiporestauranteRepository.deleteById(idTiporestaurante);
	}

	@Override
	public Optional<Tiporestaurante> listId(int idTiporestaurante) {
		// TODO Auto-generated method stub
		return tiporestauranteRepository.findById(idTiporestaurante);
	}

	@Override
	public void update(Tiporestaurante tiporestaurante) {
		// TODO Auto-generated method stub
		tiporestauranteRepository.save(tiporestaurante);
	}

	

}
