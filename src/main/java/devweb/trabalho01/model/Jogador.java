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

  @OneToMany(targetEntity = Pagamento.class, mappedBy = "jogador", cascade = CascadeType.ALL)
  private Set<Pagamento> pagamento;

  public Jogador() {
  }

  public Jogador(String nome, String email, Date dataNasc) {
    this.nome = nome;
    this.email = email;
    this.dataNasc = dataNasc;
  }

  public Set<Pagamento> getListaPagamento() {
    return pagamento;
  }

  public void setPagamento(Set<Pagamento> pagamento) {
    this.pagamento = pagamento;
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