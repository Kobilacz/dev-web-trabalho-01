package devweb.trabalho01.model;

import javax.persistence.*;

@Entity
@Table(name = "pagamento")
public class Pagamento {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int cod_pagamento;

  @Column
  private short ano;

  @Column
  private byte mes;

  @Column
  private float valor;

  @Column
  private int cod_jogador;
/* 
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "cod_jogador", nullable = false) */

  public Pagamento(int cod_pagamento, short ano, byte mes, float valor, int cod_jogador) {
    this.cod_pagamento = cod_pagamento;
    this.ano = ano;
    this.mes = mes;
    this.valor = valor;
    this.cod_jogador = cod_jogador;
  }

  public int getId() {
    return this.cod_pagamento;
  }

  public void setId(int cod_pagamento) {
    this.cod_pagamento = cod_pagamento;
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

  public int getCodJogador() {
    return this.cod_jogador;
  }

  public void setCodJogador(int cod_jogador) {
    this.cod_jogador = cod_jogador;
  }

  @Override
  public String toString() {
    return "Código do pagamento: " + cod_pagamento + "\nAno: " + ano + "\nMes: " + mes + "\nValor: " + valor
        + "\nCódigo do jogador: " + cod_jogador;
  }
}
