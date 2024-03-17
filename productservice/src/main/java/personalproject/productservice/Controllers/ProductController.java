package personalproject.productservice.Controllers;

//import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import personalproject.productservice.Models.Product;
import personalproject.productservice.exceptions.ProductNotExistException;
import personalproject.productservice.services.Productservice;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private Productservice productService;
    private RestTemplate restTemplate;

    @Autowired
    public ProductController(@Qualifier("SelfProductService") Productservice productService, RestTemplate restTemplate){
        this.productService=productService;
        this.restTemplate=restTemplate;
    }


    @GetMapping() // localhost:8080/products
    public ResponseEntity<List<Product>> getAllProducts(){
        //return new ArrayList<>();
        ResponseEntity<List<Product>> response = new ResponseEntity<List<Product>>(
            productService.getAllProducts(), HttpStatus.NOT_FOUND);

        return response;

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotExistException{
        return new ResponseEntity<>(productService.getSingleProduct(id),HttpStatus.OK) ;
    }

    @PostMapping()
    public Product addnewProduct(@RequestBody Product product ){
        return productService.addNewProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id, @RequestBody Product product){

    }
}
