package br.com.gama.wipro.console;

import java.util.List;

import br.com.gama.wipro.entity.Account;

public class AccountManager {

	private List<Account> accounts;

	public AccountManager(List<Account> accounts) {
		super();
		this.accounts = accounts;
	}

	public void createAccount(Account account) {
		this.accounts.add(account);
		System.out.println(account);

	}

	public void removeAccount(Integer number) {

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

	public void getAccount(Integer number) {

		boolean contaEncontrada = false;

		for (Account account : accounts) {
			if (account.getNumber() == number) {
				contaEncontrada = true;
				System.out.println(account.toString());
				break;
			}
		}

		if (!contaEncontrada) {
			System.out.println("Conta não encontrada");
		}

	}

}
