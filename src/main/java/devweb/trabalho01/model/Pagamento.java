package devweb.trabalho01.model;

import javax.persistence.*;

@Entity
@Table(name = "pagamento")
public class Pagamento {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int idPagamento;

  @Column
  private short ano;

  @Column
  private byte mes;

  @Column
  private float valor;

  @ManyToOne
  @JoinColumn(name = "idJogador", referencedColumnName = "idJogador")
  private Jogador mJogador;

  public Pagamento(int idPagamento, short ano, byte mes, float valor) {
    this.idPagamento = idPagamento;
    this.ano = ano;
    this.mes = mes;
    this.valor = valor;
  }

  public int getIdPagamento() {
    return this.idPagamento;
  }

  public void setIdPagamento(int idPagamento) {
    this.idPagamento = idPagamento;
  }

  public short getAno() {
    return this.ano;
  }

  public void setAno(short ano) {
    this.ano = ano;
  }

  public byte getMes() {
    return this.mes;
  }

  public void setMes(byte mes) {
    this.mes = mes;
  }

  public float getValor() {
    return this.valor;
  }

  public void setValor(float valor) {
    this.valor = valor;
  }

  @Override
  public String toString() {
    return "Código do pagamento: " + idPagamento + "\nAno: " + ano + "\nMes: " + mes + "\nValor: " + valor
        + "\nCódigo do jogador: ";
  }
}
