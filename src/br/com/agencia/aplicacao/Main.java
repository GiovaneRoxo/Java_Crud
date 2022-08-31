package br.com.agencia.aplicacao;

import java.util.Date;
import java.util.Scanner;

import br.com.agencia.dao.ClienteDAO;
import br.com.agencia.model.Cliente;

public class Main {

	public static void main(String[] args){

		Scanner ler = new Scanner(System.in);
		int opc;
		int opcc;
		boolean loop = true;
		boolean sair = true;

		while(loop == true) {
		System.out.println("------------------------");
		System.out.println("---------AGENCIA--------");
		System.out.println("------------------------");
		System.out.println("1 - L O G I N");
		System.out.println("2 - C A D A S T R A R");
		System.out.println("3 - S A I R");
		opc = ler.nextInt();
		
		switch(opc) {
		  case 1:
			  System.out.println("------------------------");
			  System.out.println("---------LOGIN----------");
			  System.out.println("------------------------");
			  System.out.println("Digite o usuario: ");
			  String usuario = ler.next();
				System.out.println("Digite a senha: ");
				String senha = ler.next();
			  String login = ClienteDAO.login(usuario, senha);
			  if(login != null) {
				  while(sair == true) {
						System.out.println("------------------------");
						System.out.println("------BEM-VINDO(A)------");
						System.out.println("------------------------");
						System.out.println("1 - Listar aeroportos");
						System.out.println("2 - Comprar passagens");
						System.out.println("3 - Alterar senha");
						System.out.println("4 - Deletar conta");
						System.out.println("5 - Sair");
						opcc = ler.nextInt();
						switch(opcc) {
							case 1:

							case 2:

							case 3:
								System.out.println("------------------------");
								System.out.println("---------SENHA----------");
								System.out.println("------------------------");
								System.out.println("Digite a antiga senha: ");
								String antiga = ler.next();
								System.out.println("Digite a nova senha: ");
								String novaSenha = ler.next();
								ClienteDAO.updateSenha(novaSenha, antiga);
								break;
							case 4:
								System.out.println("------------------------");
								System.out.println("---------DELETAR---------");
								System.out.println("------------------------");
								System.out.println("Digite a senha: ");
								String senhaTest = ler.next();
								if(ClienteDAO.validaSenha(senhaTest) == true){
									ClienteDAO.deleteByID(ClienteDAO.getIdByUsuario(usuario));
									sair = false;
								}else{
									System.out.println("Senha incorreta");
								}
								break;
							case 5:
							  sair = false;
								break;
						}
					}
				}else{
					System.out.println("Usuario ou senha invalidos");
				}
				break;

		  case 2:
			  System.out.println("------------------------");
			  System.out.println("---------CADASTRO-------");
			  System.out.println("------------------------");
			  System.out.println("Digite o seu primeiro nome (sem espaço): ");
				Cliente cliente = new Cliente();
			  String nome = ler.next();
				System.out.println("Digite o seu segundo nome (sem espaço): ");
				System.out.println("-----SE NAO POSSUIR, DIGITE n E DEPOIS ENTER-----");
				String segundo_nome = ler.next();
				if(segundo_nome.equals("n")) {
					segundo_nome = null;
				}else{
					nome = nome + " " + segundo_nome;
				}
				cliente.setNome(nome);
				System.out.println("Digite o seu sobrenome do meio (sem espaço): ");
				String nome_meio = ler.next();
				cliente.setNomeMeio(nome_meio);
				System.out.println("Digite o seu ultimo sobrenome (sem espaço): ");
				String nome_final = ler.next();
				cliente.setNomeFinal(nome_final);
				cliente.setDataCadastro(new Date());
				boolean loop2 = true;
				while(loop2 == true) {
					System.out.println("Digite o seu nome de usuario: ");
					String usuarioCadastro = ler.next();
					if(ClienteDAO.validaUsuarios(usuarioCadastro) == true){
						System.out.println("Usuario ja existe, digite outro");
					}else{
						cliente.setUsuario(usuarioCadastro);
						loop2 = false;
					}
				}
				System.out.println("Digite a sua senha: ");
				String senhaCadastro = ler.next();
				cliente.setSenha(senhaCadastro);
				ClienteDAO.save(cliente);
				break;
			case 3:
			  loop = false;
				break;	   
	  }
	}ler.close();
}	       
}
