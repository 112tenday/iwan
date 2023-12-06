package com.phincon.bootcamp.agung;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.phincon.bootcamp.agung.model.Account;

@SpringBootApplication
public class AgungApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AgungApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			Account account = new Account();
			account.setId(i);
			System.out.println("id :" + account.getId());
		}

		boolean max = true;
		int d = 0;
		while (max) {
			d++;
			Account account = new Account();
			account.setId(d);
			System.out.println("while id :" + account.getId());

			if (d == 5) {
				max = false;
			}
		}

	}

}
