package br.com.agencia.model;

public class Passagem {
  
  private int passagem_id;
  private int dia_viagem;
  private int mes_viagem;
  private int ano_viagem;
  private String origem;
  private String destino;

  public int getPassagemId() {
    return passagem_id;
  }

  public void setPassagemId(int passagem_id) {
    this.passagem_id = passagem_id;
  }

  public int getDiaViagem() {
    return dia_viagem;
  }

  public int getMesViagem() {
    return mes_viagem;
  }

  public int getAnoViagem() {
    return ano_viagem;
  }

  public void setDataViagem(int dia_viagem, int mes_viagem, int ano_viagem) {
    this.dia_viagem = dia_viagem;
    this.mes_viagem = mes_viagem;
    this.ano_viagem = ano_viagem;
  }

  public String getOrigem() {
    return origem;
  }

  public void setOrigem(String origem) {
    this.origem = origem;
  }

  public String getDestino() {
    return destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }
}
