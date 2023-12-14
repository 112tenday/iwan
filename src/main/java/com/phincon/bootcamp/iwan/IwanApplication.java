package com.phincon.bootcamp.iwan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.scheduling.annotation.EnableScheduling;


@OpenAPIDefinition(info =@Info(title = "Swagger Demo bootcamp", version = "1.0", description = "Documentation"))
@SpringBootApplication
@EnableScheduling
public class IwanApplication {

	public static void main(String[] args) {
		SpringApplication.run(IwanApplication.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// for (int i = 0; i < 10; i++) {
	// Account account = new Account();
	// account.setId(i);
	// System.out.println("id :" + account.getId());, version
	// }

	// boolean max = true;
	// int d = 0;
	// while (max) {
	// d++;
	// Account account = new Account();
	// account.setId(d);
	// System.out.println("while id :" + account.getId());

	// if (d == 5) {
	// max = false;
	// }
	// }

	// }

}
