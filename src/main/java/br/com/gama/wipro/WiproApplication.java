package br.com.gama.wipro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.gama.wipro.console.AccountManager;
import br.com.gama.wipro.entity.Account;
import br.com.gama.wipro.entity.CurrentAccount;
import br.com.gama.wipro.entity.SpecialAccount;

public class WiproApplication {

	public static void main(String[] args) {

		List<Account> accounts = new ArrayList<>();

		CurrentAccount contaCorrente;
		SpecialAccount contaEspecial;
		AccountManager gerenciaConta = new AccountManager(accounts);

		int opcao = Integer.MIN_VALUE;
		int accountNumber;
		float balance;

		Scanner sc = new Scanner(System.in);

		System.out.println("__        ___                 "
				 + "\n" + " \\ \\      / (_)_ __  _ __ ___  \n"
						+ "  \\ \\ /\\ / /| | '_ \\| '__/ _ \\ \n" 
						+ "   \\ V  V / | | |_) | | | (_) |\n"
						+ "    \\_/\\_/  |_| .__/|_|  \\___/ \n" + "              "
					   		          + "|_|              ");

		System.out.println("  __  __           _               ____              _ \n"
				+ " |  \\/  | __ _ ___| |_ ___ _ __   / ___|__ _ _ __ __| |\n"
				+ " | |\\/| |/ _` / __| __/ _ \\ '__| | |   / _` | '__/ _` |\n"
				+ " | |  | | (_| \\__ \\ ||  __/ |    | |__| (_| | | | (_| |\n"
				+ " |_|  |_|\\__,_|___/\\__\\___|_|     \\____\\__,_|_|  \\__,_|\n");

		do {
			System.out.println("Digite uma Opção\n" 
								+ "1 - Criar Conta Corrente\n" 
								+ "2 - Criar Conta Especial\n"
								+ "3 - Apagar Conta\n" 
								+ "4 - Consultar Conta\n" 
								+ "0 - Encerrar Programa\n");

			try {

				opcao = sc.nextInt();
				switch (opcao) {
				case 1:
					System.out.println("Digite o número da conta:");
					accountNumber = sc.nextInt();
					System.out.println("Digite o saldo da conta:");
					balance = sc.nextFloat();
					contaCorrente = new CurrentAccount(accountNumber, balance);
					gerenciaConta.createAccount(contaCorrente);
					break;
				case 2:
					System.out.println("Digite o número da conta:");
					accountNumber = sc.nextInt();
					System.out.println("Digite o saldo da conta:");
					balance = sc.nextFloat();
					contaEspecial = new SpecialAccount(accountNumber, balance);
					gerenciaConta.createAccount(contaEspecial);
					break;
				case 3:
					System.out.println("Digite o número da conta:");
					accountNumber = sc.nextInt();
					gerenciaConta.removeAccount(accountNumber);
					break;
				case 4:
					System.out.println("Digite o número da conta:");
					accountNumber = sc.nextInt();
					gerenciaConta.getAccount(accountNumber);
					break;
				case 0:
					System.out.println("Programa encerrado.");
					break;
				default:
					System.out.println("Opção inválida!");
				}

			} catch (Exception e) {
				System.out.println("Ocorreu um erro.");
				opcao = 0;
			}


		} while (opcao != 0);
		
		sc.close();

	}
}
