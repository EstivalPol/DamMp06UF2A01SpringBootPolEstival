package cat.prateducaio.springbootpolestival.model.service;

import java.util.List;
import java.util.Optional;

import cat.prateducaio.springbootpolestival.model.domain.Ciutat;

public interface CiutatService {
	Ciutat afegir(Ciutat ciutat);
	Ciutat modificar(Ciutat ciutat);
	void borrar(int id);
	Optional<Ciutat> buscarPerId(int id);
	List<Ciutat> getAll();
}
