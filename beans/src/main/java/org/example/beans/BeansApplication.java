package org.example.beans;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeansApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeansApplication.class, args);
	}

	@Bean
	public CommandLineRunner myCommandLineRunner(ApplicationContext ctx) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println(ctx.getBean("newColoredCar"));
				System.out.println(ctx.getBean("newModeledCar"));
			};
		};
	}
}
