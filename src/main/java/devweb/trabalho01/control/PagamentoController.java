package devweb.trabalho01.control;

import devweb.trabalho01.model.Jogador;
import devweb.trabalho01.model.Pagamento;
import devweb.trabalho01.repository.JogadorRepository;
import devweb.trabalho01.repository.PagamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PagamentoController {
  @Autowired
  PagamentoRepository pagRep;

  @Autowired
  JogadorRepository jogRep;

  // GET /api/pagamentos -> listar todos os pagamentos
  @GetMapping("/pagamentos")
  public ResponseEntity<List<Pagamento>> getAllPagamentos() {

    try {
      List<Pagamento> listPag = new ArrayList<Pagamento>();

      pagRep.findAll().forEach(listPag::add);
      if (listPag.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(listPag, HttpStatus.OK);

    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/pagamentos/{idJogador}")
  public ResponseEntity<List<Pagamento>> getAllPagamentos(
      @PathVariable("idJogador") int idJogador) {

    try {
      List<Pagamento> listPag = new ArrayList<Pagamento>();

      listPag.add(pagRep.findById(idJogador).get());
      if (listPag.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(listPag, HttpStatus.OK);

    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // POST /api/pagamentos -> criar pagamento
  @PostMapping("/pagamentos/{idJogador}/jogadores")
  public ResponseEntity<Pagamento> createPagamento(@PathVariable("idJogador") int idJogador,
      @RequestBody Pagamento pagamento) {
    try {
      Optional<Jogador> jogador = jogRep.findById(idJogador);
      if (jogador.isPresent()){
        Pagamento _pagamento = pagRep.save(new Pagamento(pagamento.getAno(), pagamento.getMes(), pagamento.getValor(), jogador.get()));
        return new ResponseEntity<>(_pagamento, HttpStatus.CREATED);
      }
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // PUT /api/pagamentos/:idPagamento -> atualizar pagamento dado um id
  @PostMapping("/pagamentos/{idPagamento}")
  public ResponseEntity<Pagamento> updatePagamento(@PathVariable("idPagamento") int idPagamento, @RequestBody Pagamento pagamento) {

    Optional<Pagamento> data = pagRep.findById(idPagamento);

    if (data.isPresent()) {
      Pagamento pag = data.get();
      pag.setMes(pagamento.getMes());
      pag.setAno(pagamento.getMes());
      pag.setValor(pagamento.getValor());
      pag.setIdPagamento(pagamento.getIdPagamento());

      return new ResponseEntity<>(pagRep.save(pag), HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // DEL /api/pagamentos/:idPagamento -> remover pagamento dado id
  @DeleteMapping("/pagamentos/{idPagamento}")
  public ResponseEntity<HttpStatus> deletePagamento(@PathVariable("idPagamento") int idPagamento) {
    try {
      pagRep.deleteById(idPagamento);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // DEL /api/pagamentos -> remover todos os pagamentos
  @DeleteMapping("/pagamentos")
  public ResponseEntity<HttpStatus> deleteAllPagamento() {
    try {
      pagRep.deleteAll();
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
