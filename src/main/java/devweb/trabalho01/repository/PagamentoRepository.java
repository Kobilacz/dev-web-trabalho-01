package devweb.trabalho01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import devweb.trabalho01.model.Pagamento;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
  List<Pagamento> findAll();

  List<Pagamento> findByCodJogador(int cod_jogador);
}
