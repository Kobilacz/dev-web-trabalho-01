package devweb.trabalho01.model;

import java.sql.Date;
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
  private Date data_nasc;

  @OneToMany(mappedBy = "mJogador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<Pagamento> pagamento;

  public Jogador(String nome, String email, Date data_nasc) {
    this.nome = nome;
    this.email = email;
    this.data_nasc = data_nasc;
  }

  public int getIdJogador() {
    return idJogador;
  }

  public void setIdJogador(int idJogador) {
    this.idJogador = idJogador;
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
    return data_nasc;
  }

  public void setDataNasc(Date data_nasc) {
    this.data_nasc = data_nasc;
  }
  
  public Set<Pagamento> getPagamento() {
    return pagamento;
  }

  public void setPagamento(Set<Pagamento>pagamento) {
    this.pagamento = pagamento;
  }

  @Override
  public String toString() {
    return "Código do jogador: " + idJogador + "\nNome: " + nome + "\nEmail: " + email + "\nData de nascimento: " + data_nasc;
  }
}
