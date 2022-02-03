package devweb.trabalho01.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devweb.trabalho01.repository.JogadorRepository;
import devweb.trabalho01.model.Jogador;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class JogadorController {
  
  @Autowired
  JogadorRepository jogRep;

  // GET /api/jogadores -> listar todos os jogadores ou um jogador dado um nome
  @GetMapping("/jogadores")
  public ResponseEntity<List<Jogador>> getAlljogador(@RequestParam(required = false) String nome) {
    try {
      List<Jogador> lj = new ArrayList<Jogador>();
      
      if (nome == null) {
        jogRep.findAll().forEach(lj::add);
      }
      else {
        jogRep.findByNome(nome).forEach(lj::add);
      }

      if (lj.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(lj, HttpStatus.OK);
      
    }
    catch (Exception e){
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // POST /api/jogadores -> criar jogador
  @PostMapping("/jogadores")
  public ResponseEntity<Jogador> createJogador(@RequestBody Jogador jog) {
    try {
      Jogador _jog = jogRep.save(new Jogador(jog.getNome(), jog.getEmail(), jog.getDataNasc()));
      return new ResponseEntity<>(_jog, HttpStatus.CREATED);
    }
    catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // PUT /api/jogadores/:nome -> atualizar jogador dado um id
  @PutMapping("/jogadores/{idJogador}")
  public ResponseEntity<Jogador> updateJogador(@PathVariable("idJogador") int idJogador, @RequestBody Jogador jog) {
    Optional<Jogador> data = jogRep.findById(idJogador);

    if (data.isPresent()) {
      Jogador _jog = data.get();
      _jog.setNome(jog.getNome());
      _jog.setEmail(jog.getEmail());
      _jog.setDataNasc(jog.getDataNasc());

      return new ResponseEntity<>(jogRep.save(_jog), HttpStatus.OK);
    }
    else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // DEL /api/jogadores/:nome -> remover jogador dado um id
  @DeleteMapping("/jogadores/{idJogador}")
  public ResponseEntity<HttpStatus> deleteById(@PathVariable("idJogador") int idJogador) {
    try {
      jogRep.deleteById(idJogador);
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  // DEL /api/jogadores -> remover todos os jogadores
  @DeleteMapping("/jogadores")
  public ResponseEntity<HttpStatus> deleteAllJogadores() {
    try {
      jogRep.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
