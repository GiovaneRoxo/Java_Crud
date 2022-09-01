package br.com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agencia.factory.ConnectionFactory;
import br.com.agencia.model.Passagem;

public class PassagemDAO {

    // metodo para inserir uma passagem no banco de dados
  public static void inserir(Passagem passagem) {

    String sql = "INSERT INTO passagem(passagem_id, Dia_viagem, Mes_viagem, Ano_viagem, Destino, Origem) VALUES (?, ?, ?, ?, ?, ?)";
			
    Connection conn = null;
    PreparedStatement pstm = null;
    
    
    try {
      //cria conexão com banco de dados
      conn = ConnectionFactory.createConnectionToMySQL();
      pstm = (PreparedStatement) conn.prepareStatement(sql); 
      
      pstm.setInt(1, passagem.getPassagemId());
      pstm.setInt(2, passagem.getDiaViagem());
      pstm.setInt(3, passagem.getMesViagem());
      pstm.setInt(4, passagem.getAnoViagem());
      pstm.setString(5, passagem.getDestino());
      pstm.setString(6, passagem.getOrigem());
      pstm.execute();

      System.out.println("Passagem comprada com sucesso!");

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
    // metodo para deletar uma passagem no banco de dados
  public static void deletarPassagem(int passagem_id){
    String sql = "DELETE * FROM passagem WHERE passagem_id = ?";
    Connection conn = null;
    PreparedStatement pstm = null;
    
    try {
      conn = ConnectionFactory.createConnectionToMySQL();
      pstm = (PreparedStatement) conn.prepareStatement(sql);
      pstm.setInt(1, passagem_id);
      pstm.execute();
      System.out.println("Passagem cancelada com sucesso!");
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
    // metodo para atualizar uma passagem no banco de dados
  public static void atualizarPassagem(Passagem passagem){
    String sql = "UPDATE passagem SET Dia_viagem = ?, mes_viagem = ?, Ano_viagem = ?, Destino = ?, Origem = ? WHERE passagem_id = ?";
    Connection conn = null;
    PreparedStatement pstm = null;
    
    try {
      conn = ConnectionFactory.createConnectionToMySQL();
      pstm = (PreparedStatement) conn.prepareStatement(sql);
      pstm.setInt(1, passagem.getDiaViagem());
      pstm.setInt(2, passagem.getMesViagem());
      pstm.setInt(3, passagem.getAnoViagem());
      pstm.setString(4, passagem.getDestino());
      pstm.setString(5, passagem.getOrigem());
      pstm.setInt(6, passagem.getPassagemId());
      pstm.execute();
      System.out.println("Passagem atualizada com sucesso!");
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
    // metodo para listar passagens no banco de dados
  public static List<Passagem> listarPassagens(){
    
    String sql = "SELECT * FROM passagem";
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rset = null;

    List<Passagem> passagens = new ArrayList<Passagem>();
    
    try {
      conn = ConnectionFactory.createConnectionToMySQL();
      pstm = (PreparedStatement) conn.prepareStatement(sql);
      
      rset = pstm.executeQuery();

      while(rset.next()) {
        Passagem passagem = new Passagem();
          
        passagem.setDataViagem(rset.getInt("Dia_viagem"),rset.getInt("Mes_viagem"),rset.getInt("Ano_viagem"));
        passagem.setDestino(rset.getString("Destino"));
        passagem.setOrigem(rset.getString("Origem"));
        passagem.setPassagemId(rset.getInt("passagem_id"));
        passagens.add(passagem);
      }


      System.out.println("Passagens listadas com sucesso!");
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
    return passagens;
  
  }
}
