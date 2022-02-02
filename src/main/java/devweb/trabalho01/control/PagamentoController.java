package devweb.trabalho01.control;

import devweb.trabalho01.model.Pagamento;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PagamentoController {
  @Autowired
  PagamentoRepository pagRep;

  // DEL /api/pagamentos -> listar todos os pagamentos ou um pagamento dado um código de jogador
  @GetMapping("/pagamentos")
  public ResponseEntity<List<Pagamento>> getAllPagamentos(
      @RequestParam(required = false) Integer cod_jogador) {

    try {
      List<Pagamento> listPag = new ArrayList<Pagamento>();

      if (cod_jogador == null) {
        pagRep.findAll().forEach(listPag::add);
      } else {
        pagRep.findByCodJogador(Integer.valueOf(cod_jogador)).forEach(listPag::add);
      }

      if (listPag.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(listPag, HttpStatus.ACCEPTED);

    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // POST /api/pagamentos -> criar pagamento
  @PostMapping("/pagamentos")
  public ResponseEntity<Pagamento> createPagamento(@RequestBody Pagamento pagamento) {
    try {
      Pagamento _pagamento = pagRep.save(new Pagamento(pagamento.getCodJogador(), pagamento.getAno(),
          pagamento.getMes(), pagamento.getValor(), pagamento.getCodJogador()));

      return new ResponseEntity<>(_pagamento, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // PUT /api/pagamentos/:cod_pagamento -> atualizar pagamento dado um id
  @PostMapping("/pagamentos/{cod_pagamento}")
  public ResponseEntity<Pagamento> updatePagamento(@PathVariable("cod_pagamento") int cod_pagamento, @RequestBody Pagamento pagamento) {
    Optional<Pagamento> data = pagRep.findById(cod_pagamento);

    if (data.isPresent()) {
      Pagamento pag = data.get();
      pag.setMes(pagamento.getMes());
      pag.setAno(pagamento.getMes());
      pag.setValor(pagamento.getValor());
      pag.setCodJogador(pagamento.getCodJogador());

      return new ResponseEntity<>(pagRep.save(pag), HttpStatus.NOT_FOUND);
    }
    else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // DEL /api/pagamentos/:cod_pagamento -> remover pagamento dado id
  @DeleteMapping("/pagamentos/{cod_pagamento}")
  public ResponseEntity<HttpStatus> deletePagamento(@PathVariable("cod_pagamento") int cod_pagamento) {
    try {
      pagRep.deleteById(cod_pagamento);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // DEL /api/pagamentos -> remover todos os pagamentos
  @DeleteMapping("/pagamentos")
  public ResponseEntity<HttpStatus> deleteAllPagamento() {
    try {
      pagRep.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
