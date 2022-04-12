package br.com.gama.wipro.console;

import java.util.ArrayList;
import java.util.List;

import br.com.gama.wipro.entity.Account;

public class AccountManager {

	private List<Account> Accounts = new ArrayList<Account>();

	public void createAccount(Account account) {

		Accounts.add(account);
		System.out.println(account);

	}

	public void removeAccount(Integer number) {
		int index = 0;
		for (Account account : Accounts) {
			if (account.getNumber() == number) {
				index = Accounts.indexOf(account);
			}
		}
		
		Accounts.remove(index);

	}

	public String getAccount(Integer number) {
		for (Account account : Accounts) {
			if (account.getNumber() == number) {
				System.out.println(account.toString());
				return account.toString();
			}
		}
		
		System.out.println("Conta não encontrada");
		return "";
	}

}
