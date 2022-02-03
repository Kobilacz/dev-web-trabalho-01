package devweb.trabalho01.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "jogador")
public class Jogador {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int idJogador;

  @Column
  private String nome;

  @Column
  private String email;

  @Column
  private Date dataNasc;

  @OneToMany(mappedBy = "jogador", cascade = CascadeType.ALL)

  private Set<Pagamento> pagamento;

  public Set<Pagamento> getListaPagamento() {
    return pagamento;
  }

  public void setListaPagamento(Set<Pagamento> pagamento) {
    this.pagamento = pagamento;
  }

  public Jogador(String nome, String email, Date dataNasc) {
    this.nome = nome;
    this.email = email;
    this.dataNasc = dataNasc;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDataNasc() {
    return dataNasc;
  }

  public void setDataNasc(Date dataNasc) {
    this.dataNasc = dataNasc;
  }

  public int getIdJogador() {
    return idJogador;
  }

  public void setIdJogador(int idJogador) {
    this.idJogador = idJogador;
  }
}