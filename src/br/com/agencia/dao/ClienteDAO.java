 package br.com.agencia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agencia.factory.ConnectionFactory;
import br.com.agencia.model.Cliente;

public class ClienteDAO {
	
	public static void save(Cliente cliente ) {
			
			String sql = "INSERT INTO clientes(nome, sobrenome_meio, sobrenome_final, idade, datacadastro, usuario, senha) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			
			try {
				//cria conexão com banco de dados
				conn = ConnectionFactory.createConnectionToMySQL();
				pstm = (PreparedStatement) conn.prepareStatement(sql); 
				
				pstm.setString(1, cliente.getNome());
				pstm.setString(2, cliente.getNomeMeio());
				pstm.setString(3, cliente.getNomeFinal());
				pstm.setInt(4, cliente.getIdade());
				pstm.setDate(5, new Date(cliente.getDataCadastro().getTime()));
				pstm.setString(6, cliente.getUsuario());
				pstm.setString(7, cliente.getSenha());
				
				pstm.execute();
				System.out.println("Contato salvo!!");
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

	public static List<Cliente> getClientes(){
		
			String sql = "SELECT * FROM clientes";
			
				List<Cliente> clientes = new ArrayList<Cliente>();
			
				Connection conn = null;
				PreparedStatement pstm = null;
				//recurperar dados do banco
				ResultSet rset = null;
				
				try {
					conn = ConnectionFactory.createConnectionToMySQL();
					
					pstm = conn.prepareStatement(sql);
				
					rset = pstm.executeQuery();
				
						while(rset.next()) {
							Cliente cliente = new Cliente();
								
							cliente.setId(rset.getInt("id"));
							cliente.setNome(rset.getString("nome"));
							cliente.setIdade(rset.getInt("idade"));
							cliente.setDataCadastro(rset.getDate("datacadastro"));
							
							clientes.add(cliente);
						}
						
				}catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(rset!=null) {
							rset.close();
						}if(pstm!=null) {
							pstm.close();
						}if(conn!=null) {
							conn.close();
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				return clientes;
		}

	public static void update(Cliente cliente) {
			
			String sql = "UPDATE `clientes` SET `nome` = ?, `idade` = ?, `datacadastro` = ? "+ 
			"WHERE (`id` = ?);";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionFactory.createConnectionToMySQL();
				
				pstm = (PreparedStatement) conn.prepareStatement(sql);
			
					pstm.setString(1, cliente.getNome());
					pstm.setInt(2, cliente.getIdade());
				pstm.setDate(3, new Date(cliente.getDataCadastro().getTime()));
				pstm.setInt(4, cliente.getId());
				
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

	public static void deleteByID(int id) {
			
			String sql = "DELETE FROM `agencia`.`clientes` WHERE (`id` = ?);";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionFactory.createConnectionToMySQL();
				pstm = (PreparedStatement) conn.prepareStatement(sql);
				
				pstm.setInt(1, id);
				
				pstm.execute();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}if(conn!=null) {
						conn.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	public static int lastID(){
		
		String sql = "SELECT `id` FROM agencia.clientes;";
		
	    List<Cliente> list = new ArrayList<Cliente>();
		
	    Connection conn = null;
	    PreparedStatement pstm = null;
	    //recurperar dados do banco
	    ResultSet rset = null;
	    int maior = Integer.MIN_VALUE;
	    
	    try {
	    	conn = ConnectionFactory.createConnectionToMySQL();
	    	
	    	pstm = conn.prepareStatement(sql);
	    
	    	rset = pstm.executeQuery();
	    
	        while(rset.next()) {
	    	    Cliente x = new Cliente();       
	    	    x.setId(rset.getInt("id"));  
	    	    list.add(x);
	    	    for (int i = 0; i < rset.getInt("id"); i++) {
	    	        if (rset.getInt("id") > maior) {
	    	            maior = rset.getInt("id");
	    	        }
	    	    }
	        }
	        
	    }catch (Exception e) {
	    	e.printStackTrace();
	    }finally {
	    	try {
		    	if(rset!=null) {
		    		rset.close();
		    	}if(pstm!=null) {
		    		pstm.close();
		    	}if(conn!=null) {
		    		conn.close();
		    	}
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    return maior;
	}

	public static String login(String login, String senha) {

			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			

			try {
				conn = ConnectionFactory.createConnectionToMySQL();

				String sql = "SELECT Usuario FROM agencia.clientes WHERE Usuario = ? AND Senha = ? ;";

				pstm = conn.prepareStatement(sql);	
				pstm.setString(1, login);
				pstm.setString(2, senha);	
				rset = pstm.executeQuery();		
				return rset.next() ? rset.getString("Usuario") : null;

				

			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}finally {
				try {
					if(rset!=null) {
						rset.close();
					}if(pstm!=null) {
					pstm.close();
					}if(conn!=null) {
					conn.close();
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
	}
}
