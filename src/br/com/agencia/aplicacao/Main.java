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
		System.out.println("------------------------");
		System.out.println("---------AGENCIA--------");
		System.out.println("------------------------");
		System.out.println("1 - L O G I N");
		System.out.println("2 - C A D A S T R A R");
		opc = ler.nextInt();
		
		switch(opc) {
		  case 1:
			  System.out.println("------------------------");
			  System.out.println("---------LOGIN----------");
			  System.out.println("------------------------");
			  System.out.println("Digite o nome de usuario: ");
			  opc = ler.nextInt();
			       	   
			   
		   case 2:
			   
		}
	}ler.close();
}	       
}
