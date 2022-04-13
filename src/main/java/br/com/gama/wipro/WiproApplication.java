package br.com.gama.wipro;

import java.util.Random;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gama.wipro.console.AccountManager;
import br.com.gama.wipro.entity.CurrentAccount;
import br.com.gama.wipro.entity.SpecialAccount;

//@SpringBootApplication
public class WiproApplication {

	public static void main(String[] args) {
		
		//SpringApplication.run(WiproApplication.class, args);
		
		CurrentAccount contacorrente = new CurrentAccount(1,100.0f);
		SpecialAccount contaespecial = new SpecialAccount(2,100.0f);
		AccountManager gerenciaconta = new AccountManager();
		
		Scanner sc = new Scanner(System.in);
		
		int opcao = 1000;
		
		System.out.println(5502 + " " + new Random().nextInt(1000, 9999) + " " + new Random().nextInt(1000, 9999) + " " + new Random().nextInt(1000, 9999)); 
		
		System.out.println(
				  "  __  __           _               ____              _ \n"
				+ " |  \\/  | __ _ ___| |_ ___ _ __   / ___|__ _ _ __ __| |\n"
				+ " | |\\/| |/ _` / __| __/ _ \\ '__| | |   / _` | '__/ _` |\n"
				+ " | |  | | (_| \\__ \\ ||  __/ |    | |__| (_| | | | (_| |\n"
				+ " |_|  |_|\\__,_|___/\\__\\___|_|     \\____\\__,_|_|  \\__,_|\n");
		
		do{
			System.out.println("Digite uma Opção\n1 - Criar Conta\n"
					+ "2 - Apagar Conta\n"
					+ "3 - Listar Conta\n");
			
			opcao = sc.nextInt();
			
			switch(opcao) {
			case 1:
				gerenciaconta.createAccount(contacorrente);
				break;
			case 2:
				gerenciaconta.removeAccount(1);
				break;
			case 3:
				gerenciaconta.getAccount(1);
				break;
			default:
				System.out.println("Opção inválida");
			
			}
			
			
			
		}while(opcao !=0 );
		
		
		
		
		gerenciaconta.getAccount(1);
		

		
		gerenciaconta.createAccount(contaespecial);
		
	
		
		gerenciaconta.getAccount(2);
		
	
		
		gerenciaconta.getAccount(1);
		
	
	}

}
