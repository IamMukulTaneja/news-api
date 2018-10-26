package com.wingify;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// This class is the main class which tells the spring to run that project in the servlet container and with tomcat server.
@SpringBootApplication
public class Application {

	
	public static void main(String[] args) {
		
		//Run function asks spring to make the servlet container and start the project in it.
		SpringApplication.run(Application.class, args);
		

	}

}
