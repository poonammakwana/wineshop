package ecom.com.wineshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping(value = "/wine")
public class WineshopApplication {
	
	@RequestMapping(value = "/keyword")
	public String display() {
		return "hello wine!";
	}

	public static void main(String[] args) {
		SpringApplication.run(WineshopApplication.class, args);
	}
}
