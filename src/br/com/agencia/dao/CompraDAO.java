package br.com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.agencia.factory.ConnectionFactory;
import br.com.agencia.model.Compra;

public class CompraDAO {
  
    // inserir  nova compra no banco de dados
  public static void inserirCompra(Compra compra) {
    
    String sql = "INSERT INTO compra(passagem_id, cliente_id, data_compra, status_compra) VALUES (?, ?, ?, ?)";
			
    Connection conn = null;
    PreparedStatement pstm = null;
    
    
    try {
      //cria conexão com banco de dados
      conn = ConnectionFactory.createConnectionToMySQL();
      pstm = (PreparedStatement) conn.prepareStatement(sql); 
      
      pstm.setInt(1, compra.getPassagemId());
      pstm.setInt(2, compra.getClienteId());
      pstm.setDate(3, compra.getDataCompra());
      pstm.setString(4, compra.getStatusCompra());
      pstm.execute();

    }catch (Exception e) {
      e.printStackTrace();
    }finally {
      try {
        if(pstm!=null) {
          pstm.close();
        }
        if(conn!=null) {
          conn.close();
        }
      }catch (Exception e) {
        e.printStackTrace();
      }
    }

  }
  
  public static void alterarCompra() {
    
  }
  
  public static void excluirCompra() {    
  }
}
