package personalproject.productservice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import personalproject.productservice.Models.Category;
import personalproject.productservice.Models.Product;
import personalproject.productservice.dtos.SelfProductDto;
import personalproject.productservice.exceptions.ProductNotExistException;
import personalproject.productservice.repositories.CategoryRepository;
import personalproject.productservice.repositories.ProductRepository;
import personalproject.productservice.repositories.projections.ProductProjection;

@Primary
@Service("SelfProductService")
public class SelfProductService implements Productservice{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }

    private SelfProductDto ConvertProduct_to_Dto(Product product){
        SelfProductDto selfProductDto = new SelfProductDto();

        selfProductDto.setId(product.getId());
        selfProductDto.setCategory(product.getCategory().getName());
        selfProductDto.setCreatedAt(product.getCreatedAt());
        selfProductDto.setDescription(product.getDescription());
        selfProductDto.setPrice(product.getPrice());
        selfProductDto.setTitle(product.getTitle());

        return selfProductDto;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistException {
        // TODO Auto-generated method stub
        Optional<Product> productoptional = productRepository.findById(id);

        if (productoptional.isEmpty()){
            throw new ProductNotExistException("Product with "+ id + " is not present");
        }

        Product product = productoptional.get();
        //Product product = new Product();
        //Product temp = productoptional.get();
        //product.setId(temp.getId());

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List <Product> lp = productRepository.findAll();
        return lp;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'replaceProduct'");
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return productRepository.setProduct(id, product);
    }

    @Override
    public Product addNewProduct(Product product) {
        Optional<Category> category = categoryRepository.findByname(product.getCategory().getName());
        if (category.isEmpty()){

        } else {
            product.setCategory(category.get());
        }

        return productRepository.save(product);

    }

    @Override
    public boolean deleteProduct(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteProduct'");
    }
    
    
}
