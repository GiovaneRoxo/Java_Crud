package br.com.agencia.aplicacao;

import java.util.Date;
import java.util.Scanner;

import br.com.agencia.dao.ClienteDAO;
import br.com.agencia.model.Cliente;

public class Main {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		int opc;
		boolean loop = true;


		while(loop == true) {
		System.out.println("----------menu----------");
		System.out.println("----digite uma opção----");
		System.out.println("------------------------");
		System.out.println("1 - Adicionar cliente");
		System.out.println("2 - Ver Clientes");
		System.out.println("3 - Atualizar informações");
		System.out.println("4 - Deletar cliente");
		opc = ler.nextInt();
		
		switch(opc) {
		   case 1:
			   int msg = ClienteDAO.lastID() + 1;
			   Cliente cliente = new Cliente();
			   System.out.println("O ID do cliente é: " + msg);
			   System.out.println("Digite o nome do cliente:");
			   String name = ler.next();
			   cliente.setNome(name);
			   System.out.println("Digite a idade do cliente");
			   int age = ler.nextInt();
			   cliente.setIdade(age);
			   cliente.setDataCadastro(new Date());   	
			   ClienteDAO.save(cliente); 
			   break;	   
			   
		   case 2:
			   System.out.println("----------CLIENTES----------");
			   for(Cliente c : ClienteDAO.getClientes()) {
				   System.out.println(c.getId()+": "+ c.getNome());
		       }
			   msg = ClienteDAO.lastID() + 1;
			   System.out.println("\nDigite 'S' para sair");
			   String sair = ler.next();
			   if(sair != "") {break;}
			 
		   case 3:
			   Cliente c1 = new Cliente();
			   System.out.println("Digite o ID ao qual quer atualizar as informações: ");
			   int aid = ler.nextInt();
			   c1.setId(aid);
			   System.out.println("Digite o novo nome do cliente: ");
			   name = ler.next();
			   c1.setNome(name);
			   System.out.println("Digite a nova idade do cliente: ");
			   age = ler.nextInt();
			   c1.setIdade(age);
			   c1.setDataCadastro(new Date());
			   ClienteDAO.update(c1);
			   break;
			   
		   case 4:
			   System.out.println("Digite o ID do cliente que quer deletar: ");
			   aid = ler.nextInt();
			   ClienteDAO.deleteByID(aid);
			   msg = ClienteDAO.lastID() + 1;
			   break;
		}
	}ler.close();
}	       
}
