package com.nwplus.Listr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin("http://localhost:4200")
public class ListrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListrApplication.class, args);
	}

}
