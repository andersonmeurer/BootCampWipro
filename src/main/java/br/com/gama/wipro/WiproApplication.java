package br.com.gama.wipro;

import java.util.Scanner;

import br.com.gama.wipro.console.AccountManager;
import br.com.gama.wipro.entity.CurrentAccount;
import br.com.gama.wipro.entity.SpecialAccount;

public class WiproApplication {

	public static void main(String[] args) {
		new WiproApplication();
	}

	public WiproApplication() {
		AccountManager accountManager = new AccountManager();

		int option = Integer.MIN_VALUE;
		int accountNumber;
		float balance;

		print();

		Scanner sc =  null;
		try {
			sc = new Scanner(System.in);
			do {
				menu();
				try {
					option = sc.nextInt();
					switch (option) {
					case 1:
						System.out.println("Digite o número da conta:");
						accountNumber = sc.nextInt();
						if (accountManager.isExistAccountNumber(accountNumber)) {
							System.out.println("Numero de conta já existe!\n\n\n");
							sc.next();
							continue;
						}
						System.out.println("Digite o saldo da conta:");
						balance = sc.nextFloat();
						CurrentAccount contaCorrente = new CurrentAccount(accountNumber, balance);
						accountManager.createAccount(contaCorrente);
						break;
					case 2:
						System.out.println("Digite o número da conta:");
						accountNumber = sc.nextInt();
						if (accountManager.isExistAccountNumber(accountNumber)) {
							System.out.println("Numero de conta já existe!\n\n\n");
							sc.next();
							continue;
						}
						System.out.println("Digite o saldo da conta:");
						balance = sc.nextFloat();
						SpecialAccount contaEspecial = new SpecialAccount(accountNumber, balance);
						accountManager.createAccount(contaEspecial);
						break;
					case 3:
						System.out.println("Digite o número da conta:");
						accountNumber = sc.nextInt();
						accountManager.removeAccount(accountNumber);
						break;
					case 4:
						System.out.println("Digite o número da conta:");
						accountNumber = sc.nextInt();
						accountManager.consultAccount(accountNumber);
						break;
					case 0:
						System.out.println("Programa encerrado.");
						break;
					default:
						System.out.println("Opção inválida!");
					}

				} catch (Exception e) {
					System.out.println("Ocorreu um erro.");
					option = 0;
				}

			} while (option != 0);
		} finally {
			if (null != sc) {
				sc.close();
			}
		}
	}

	private void menu() {
		System.out.println("Digite uma Opção\n" 
							+ "1 - Criar Conta Corrente\n" 
							+ "2 - Criar Conta Especial\n"
							+ "3 - Apagar Conta\n" 
							+ "4 - Consultar Conta\n" 
							+ "0 - Encerrar Programa\n");
	}

	private void print() {
		System.out.println(
				"__        ___                 "
				+ "\n" + " \\ \\      / (_)_ __  _ __ ___  \n"
				+ "  \\ \\ /\\ / /| | '_ \\| '__/ _ \\ \n" 
				+ "   \\ V  V / | | |_) | | | (_) |\n"
				+ "    \\_/\\_/  |_| .__/|_|  \\___/ \n"
				+ "              "
					   	+ "|_|              ");

		System.out.println(
				  "  __  __           _               ____              _ \n"
				+ " |  \\/  | __ _ ___| |_ ___ _ __   / ___|__ _ _ __ __| |\n"
				+ " | |\\/| |/ _` / __| __/ _ \\ '__| | |   / _` | '__/ _` |\n"
				+ " | |  | | (_| \\__ \\ ||  __/ |    | |__| (_| | | | (_| |\n"
				+ " |_|  |_|\\__,_|___/\\__\\___|_|     \\____\\__,_|_|  \\__,_|\n");
	}
}
