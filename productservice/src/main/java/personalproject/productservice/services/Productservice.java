package personalproject.productservice.services;

import java.util.List;

import personalproject.productservice.Models.Category;
import personalproject.productservice.Models.Product;
import personalproject.productservice.exceptions.ProductNotExistException;
//import personalproject.productservice.repositories.projections.ProductProjection;

public interface Productservice {
    Product getSingleProduct(Long id) throws ProductNotExistException;

    List<Product> getAllProducts();

    Product replaceProduct(Long id , Product product);

    Product updateProduct(Long id , Product product);

    Product addNewProduct(Product product);

    boolean deleteProduct(Long id);
}
