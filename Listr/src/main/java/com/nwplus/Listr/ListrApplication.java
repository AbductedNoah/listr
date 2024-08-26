package com.nwplus.Listr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nwplus.Listr.Config.ConnectDatabase;

@SpringBootApplication
public class ListrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListrApplication.class, args);
		ConnectDatabase connect = new ConnectDatabase();
		connect.connectDB();
	}

}
