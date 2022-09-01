package br.com.agencia.model;

public class Passagem {
  
  private int passagem_id;
  private String dia_viagem;
  private String mes_viagem;
  private String ano_viagem;
  private String origem;
  private String destino;

  public int getPassagemId() {
    return passagem_id;
  }

  public void setPassagemId(int passagem_id) {
    this.passagem_id = passagem_id;
  }

  public String getDiaViagem() {
    return dia_viagem;
  }

  public String getMesViagem() {
    return mes_viagem;
  }

  public String getAnoViagem() {
    return ano_viagem;
  }

  public void setDataViagem(String dia_viagem, String mes_viagem, String ano_viagem) {
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
