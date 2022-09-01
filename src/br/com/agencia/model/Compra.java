package br.com.agencia.model;

import java.sql.Date;

public  class Compra {

  private int compra_id;
  private Date data_compra;
  private int passagem_id;
  private int cliente_id;
  private String status_compra;

  public int getCompraId() {
    return compra_id;
  }

  public void setCompraId(int compra_id) {
    this.compra_id = compra_id;
  }

  public Date getDataCompra() {
    return data_compra;
  }

  public void setDataCompra(Date data_compra) {
    this.data_compra = data_compra;
  }

  public int getPassagemId() {
    return passagem_id;
  }

  public void setPassagemId(int passagem_id) {
    this.passagem_id = passagem_id;
  }

  public int getClienteId() {
    return cliente_id;
  }

  public void setClienteId(int cliente_id) {
    this.cliente_id = cliente_id;
  }

  public String getStatusCompra() {
    return status_compra;
  }

  public void setStatusCompra(String status_compra) {
    this.status_compra = status_compra;
  }
}
