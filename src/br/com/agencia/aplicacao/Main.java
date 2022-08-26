package br.com.agencia.aplicacao;

import java.util.Date;
import java.util.Scanner;

import br.com.agencia.dao.ClienteDAO;
import br.com.agencia.model.Cliente;

public class Main {

	public static void main(String[] args) {

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
			  System.out.println("Digite o nome de usuario: ");
			  String usuario = ler.next();
				System.out.println("Digite a senha: ");
				String senha = ler.next();
			  if(senha == "123" && usuario == "admin"){

				  while(sair == true) {
						System.out.println("------------------------");
						System.out.println("------BEM-VINDO(A)------");
						System.out.println("------------------------");
						System.out.println("1 - Listar aeroportos");
						System.out.println("2 - Compara passagens");
						System.out.println("3 - Alterar senha");
						System.out.println("4 - Sair");
						opcc = ler.nextInt();

						switch(opcc) {
							case 1:

							case 2:

							case 3:

							case 4:
							  sair = false;
								break;
						}
					}
				}else{
					System.out.println(ClienteDAO.loginUsuario(usuario));
				}
				break;

		  case 2:
			  System.out.println("------------------------");
			  System.out.println("---------CADASTRO--------");
			  System.out.println("------------------------");
			  System.out.println("Digite o nome (sem espaço): ");
				Cliente cliente = new Cliente();
			  String nome = ler.next();
				cliente.setNome(nome);
				System.out.println("Digite o nome do meio (sem espaço): ");
				String nome_meio = ler.next();
				cliente.setNomeMeio(nome_meio);
				System.out.println("Digite o nome final (sem espaço): ");
				String nome_final = ler.next();
				cliente.setNomeFinal(nome_final);
				cliente.setDataCadastro(new Date());
				System.out.println("Digite o usuario: ");
			  String usuarioCadastro = ler.next();
				cliente.setUsuario(usuarioCadastro);
				System.out.println("Digite a senha: ");
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
