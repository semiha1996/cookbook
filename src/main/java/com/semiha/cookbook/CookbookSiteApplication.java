package com.semiha.cookbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan ({"com.semiha.cookbook"})
public class CookbookSiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookbookSiteApplication.class, args);
	}

}
