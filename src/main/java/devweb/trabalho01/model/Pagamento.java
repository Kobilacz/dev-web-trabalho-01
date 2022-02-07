package devweb.trabalho01.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pagamento")
public class Pagamento {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int idPagamento;

  @Column
  private short ano;

  @Column
  private short mes;

  @Column
  private float valor;

  @ManyToOne()
  @JoinColumn(name = "idJogador")
  @JsonIgnore
  private Jogador jogador;

  public Jogador getJogador() {
    return this.jogador;
  }

  public void setJogador(Jogador jogador) {
    this.jogador = jogador;
  }

  public Pagamento() {

  }

  public Pagamento(short ano, short mes, float valor, Jogador jogador) {
    this.ano = ano;
    this.mes = mes;
    this.valor = valor;
    this.jogador = jogador;
  }

  public int getIdPagamento() {
    return idPagamento;
  }

  public void setIdPagamento(int idPagamento) {
    this.idPagamento = idPagamento;
  }

  public short getAno() {
    return ano;
  }

  public void setAno(short ano) {
    this.ano = ano;
  }

  public short getMes() {
    return mes;
  }

  public void setMes(short mes) {
    this.mes = mes;
  }

  public float getValor() {
    return valor;
  }

  public void setValor(float valor) {
    this.valor = valor;
  }
}
