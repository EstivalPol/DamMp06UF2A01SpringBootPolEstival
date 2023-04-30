package cat.prateducaio.springbootpolestival.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cat.prateducaio.springbootpolestival.model.domain.Ciutat;
import cat.prateducaio.springbootpolestival.model.service.CiutatService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/ciutat")
public class CiutatController {

	@Autowired
	CiutatService ciutatService;

	@PostMapping("/afegir")
	public ResponseEntity<?> afegir(@RequestBody Ciutat ciutat) {
		ResponseEntity<?> responseEntity;

		try {
			Ciutat tempCiutat = ciutatService.afegir(ciutat);
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(tempCiutat);
		} catch (Exception e) {
			responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return responseEntity;
	}

	@PutMapping("/modificar")
	public ResponseEntity<?> modificar(@RequestBody Ciutat ciutat) {
		ResponseEntity<?> responseEntity;

		try {
			Ciutat tempCiutat = ciutatService.modificar(ciutat);
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(tempCiutat);
		} catch (Exception e) {
			responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return responseEntity;
	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<String> borrar(@PathVariable int id) {
		ResponseEntity<String> responseEntity;

		try {
			ciutatService.borrar(id);
			responseEntity = ResponseEntity.status(HttpStatus.OK).body("La ciutat amb el ID: (" + id + ") ha estat eliminada.");
		} catch (Exception e) {
			responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return responseEntity;
	}

	@GetMapping("/buscarPerId/{id}")
	public ResponseEntity<?> buscarPerId(@PathVariable int id) {
		ResponseEntity<?> responseEntity;

		try {
			Optional<Ciutat> city = ciutatService.buscarPerId(id);
			if (city.isPresent()) {
				responseEntity = ResponseEntity.status(HttpStatus.OK).body(city);
			} else {
				responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("La ciutat amb el ID: (" + id + ") no existeix en la base de dades.");
			}
		} catch (Exception e) {
			responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return responseEntity;
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> responseEntity;

		try {
			List<Ciutat> cities = ciutatService.getAll();
			if (cities != null) {
				responseEntity = ResponseEntity.status(HttpStatus.OK).body(cities);
			} else {
				responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hi ha ciutats registrades en la base de dades.");
			}
		} catch (Exception e) {
			responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return responseEntity;
	}

}
