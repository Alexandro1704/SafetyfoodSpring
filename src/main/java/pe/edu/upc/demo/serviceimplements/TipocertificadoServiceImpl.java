package pe.edu.upc.demo.serviceimplements;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Tipocertificado;
import pe.edu.upc.demo.repositories.ITipocertificadoRepository;
import pe.edu.upc.demo.serviceinteface.ITipocertificadoService;

@Service
public class TipocertificadoServiceImpl implements ITipocertificadoService{

	@Autowired
	private ITipocertificadoRepository tipocertificadoRepository;
	@Override
	public void insert(Tipocertificado tipocertificado) {
		// TODO Auto-generated method stub
		tipocertificadoRepository.save(tipocertificado);
	}

	@Override
	public List<Tipocertificado> list() {
		// TODO Auto-generated method stub
		return tipocertificadoRepository.findAll();
	}

	@Override
	public void delete(int idTipocertificado) {
		// TODO Auto-generated method stub
		tipocertificadoRepository.deleteById(idTipocertificado);
	}

	@Override
	public Optional<Tipocertificado> listId(int idTipocertificado) {
		// TODO Auto-generated method stub
		return tipocertificadoRepository.findById(idTipocertificado);
	}

	@Override
	public void Update(Tipocertificado tipocertificado) {
		// TODO Auto-generated method stub
		tipocertificadoRepository.save(tipocertificado);
	}

}
