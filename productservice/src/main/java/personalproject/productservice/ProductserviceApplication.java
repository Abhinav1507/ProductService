package personalproject.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import personalproject.productservice.Models.Product;

@SpringBootApplication
public class ProductserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
		Product product = new Product();
		product.getId();
		//product.setId(0.00);
	}

}
