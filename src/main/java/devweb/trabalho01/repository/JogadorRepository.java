package devweb.trabalho01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import devweb.trabalho01.model.Jogador;

import java.util.List;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {

  List<Jogador> findByNome(String nome);

  List<Jogador> findAll();
}
