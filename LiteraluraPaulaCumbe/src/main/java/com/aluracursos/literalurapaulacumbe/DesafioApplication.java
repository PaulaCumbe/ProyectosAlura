package com.aluracursos.literalurapaulacumbe;

import com.aluracursos.literalurapaulacumbe.principal.PrincipalMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

	@Autowired
	private PrincipalMenu principalMenu;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principalMenu.mostrarMenu();
	}
}
