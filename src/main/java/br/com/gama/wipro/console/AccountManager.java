package br.com.gama.wipro.console;

import java.util.ArrayList;
import java.util.List;

import br.com.gama.wipro.entities.Account;

public class AccountManager {

	private List<Account> accounts;

	public AccountManager() {
		this.accounts = new ArrayList<>();
	}

	public void createAccount(Account account) {
		this.accounts.add(account);
		System.out.println(account);
	}

	public void removeAccount(int number) {

		int index = 0;
		boolean contaEncontrada = false;

		for (Account account : accounts) {
			if (account.getNumber() == number) {
				contaEncontrada = true;
				index = accounts.indexOf(account);
				System.out.println(account.toString());
				accounts.remove(index);
				break;
			}
		}

		if (!contaEncontrada) {
			System.out.println("Conta não encontrada");
		}
	}

	public void consultAccount(int find) {

		boolean contaEncontrada = false;

		for (Account account : accounts) {
			if (account.getNumber() == find) {
				contaEncontrada = true;
				System.out.println(account.toString());
				break;
			}
		}

		if (!contaEncontrada) {
			System.out.println("Conta não encontrada");
		}
	}

	public boolean isExistAccountNumber(int accountNumber) {
		for (Account account : accounts) {
			if (account.getNumber() == accountNumber) {
				return true;
			}
		}
		return false;
	}
}