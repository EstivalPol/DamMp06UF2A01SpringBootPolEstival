package cat.prateducaio.springbootpolestival.model.repository;

import org.springframework.stereotype.Repository;

import cat.prateducaio.springbootpolestival.model.domain.Ciutat;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CiutatRepository extends JpaRepository<Ciutat, Integer> {}
