package devweb.trabalho01.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "jogador")
public class Jogador {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int cod_jogador;

  @Column
  private String nome;

  @Column
  private String email;

  @Column
  private Date data_nasc;

  /* @OneToMany(mappedBy = "jogador", fetch = FetchType.LAZY, cascade = CascadeType.ALL) */

  public Jogador(String nome, String email, Date data_nasc) {
    this.nome = nome;
    this.email = email;
    this.data_nasc = data_nasc;
  }

  public int getCodJogador() {
    return cod_jogador;
  }

  public void setCodJogador(int cod_jogador) {
    this.cod_jogador = cod_jogador;
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

  @Override
  public String toString() {
    return "Código do jogador: " + cod_jogador + "\nNome: " + nome + "\nEmail: " + email + "\nData de nascimento: " + data_nasc;
  }
}
