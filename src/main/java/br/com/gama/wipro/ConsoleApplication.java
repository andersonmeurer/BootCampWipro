package br.com.gama.wipro;

import java.util.Scanner;

import br.com.gama.wipro.console.AccountManager;
import br.com.gama.wipro.entities.CreditCard;
import br.com.gama.wipro.entities.CurrentAccount;
import br.com.gama.wipro.entities.SpecialAccount;

public class ConsoleApplication {

	public static void main(String[] args) {
		new ConsoleApplication();
	}

	public ConsoleApplication() {
		AccountManager accountManager = new AccountManager();

		int option = Integer.MIN_VALUE;
		int accountNumber;
		Double balance;

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
						System.out.print("\tCriando conta corrente\n\n\tDigite o número da conta: ");
						accountNumber = sc.nextInt();
						if (accountManager.isExistAccountNumber(accountNumber)) {
							System.out.println("Numero de conta já existe!\n\n\n");
							sc.next();
							continue;
						}
						System.out.print("\n\tDigite o saldo da conta: ");
						balance = sc.nextDouble();
						CurrentAccount contaCorrente = new CurrentAccount(null, accountNumber, balance, new CreditCard(balance));
						accountManager.createAccount(contaCorrente);
						break;
					case 2:
						System.out.print("\tCriando Conta Especial\n\n\tDigite o número da conta a ser criada: ");
						accountNumber = sc.nextInt();
						if (accountManager.isExistAccountNumber(accountNumber)) {
							System.out.print("\n\tNumero de conta já existe!\n\n\n");
							sc.next();
							continue;
						}
						System.out.print("\n\tDigite o saldo da conta: ");
						balance = sc.nextDouble();
						SpecialAccount contaEspecial = new SpecialAccount(null, accountNumber, balance, new CreditCard(balance));
						accountManager.createAccount(contaEspecial);
						break;
					case 3:
						System.out.print("\tDigite o número da conta: ");
						accountNumber = sc.nextInt();
						accountManager.removeAccount(accountNumber);
						break;
					case 4:
						System.out.print("\tDigite o número da conta: ");
						accountNumber = sc.nextInt();
						accountManager.consultAccount(accountNumber);
						break;
					case 0:
						System.out.print("\n\tPrograma encerrado.");
						break;
					default:
						System.out.print("\n\tOpção inválida!");
					}

				} catch (Exception e) {
					System.out.print("\tOcorreu um erro.");
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
		System.out.println("\tDigite um número para seguir com uma das opções:\n\n" 
							+ "\t1 - Criar Conta Corrente\n" 
							+ "\t2 - Criar Conta Especial\n"
							+ "\t3 - Apagar Conta\n" 
							+ "\t4 - Consultar Conta\n" 
							+ "\t0 - Encerrar Programa\n");
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
