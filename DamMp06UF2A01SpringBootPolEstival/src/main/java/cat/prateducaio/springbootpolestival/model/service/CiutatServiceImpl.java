package cat.prateducaio.springbootpolestival.model.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import cat.prateducaio.springbootpolestival.model.domain.Ciutat;
import cat.prateducaio.springbootpolestival.model.repository.CiutatRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CiutatServiceImpl implements CiutatService {

	@Autowired
	CiutatRepository ciutatRepository;

	@Override
	public Ciutat afegir(Ciutat ciutat) {
		validateCity(ciutat);
		return ciutatRepository.save(ciutat);
	}

	@Override
	public Ciutat modificar(Ciutat ciutat) {
		validateCity(ciutat);
		return ciutatRepository.save(ciutat);
	}

	@Override
	public void borrar(int id) {
		ciutatRepository.deleteById(id);
	}

	@Override
	public Optional<Ciutat> buscarPerId(int id) {
		return ciutatRepository.findById(id);
	}

	@Override
	public List<Ciutat> getAll() {
		return ciutatRepository.findAll();
	}

	private void validateCity(Ciutat ciutat) {
		if (ciutat == null) {
			throw new RuntimeException("L'objecte 'Ciutat' és nul.");
		} else if (ciutat.getNom() == null || ciutat.getNom().length() < 2) {
			throw new RuntimeException("El nom referent a l'objecte 'Ciutat' és massa curt.");
		} else if (ciutat.getCodiPostal() == null || ciutat.getCodiPostal().length() < 5) {
			throw new RuntimeException("El codi referent a l'objecte 'Ciutat' no és vàlid.");
		}
	}

}
