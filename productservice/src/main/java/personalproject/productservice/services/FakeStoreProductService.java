package personalproject.productservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import personalproject.productservice.Models.Category;
import personalproject.productservice.Models.Product;
import personalproject.productservice.dtos.FakeStoreProductDto;
import personalproject.productservice.exceptions.ProductNotExistException;

@Service("fakestoreservice")
public class FakeStoreProductService implements Productservice{
    
    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    private Product ConvertFakeStoreProducttoProduct(FakeStoreProductDto FakeStoreProduct){
        Product product=new Product();
        product.setTitle(FakeStoreProduct.getTitle());
        product.setId(FakeStoreProduct.getId());
        product.setPrice(FakeStoreProduct.getPrice());
        product.setDescription(FakeStoreProduct.getDescription());
        product.setImgUrl(FakeStoreProduct.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(FakeStoreProduct.getCategory());

        return product;
    }
    

    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistException {
        FakeStoreProductDto productDto=restTemplate.getForObject(
            "https://fakestoreapi.com/products/"+id, 
            FakeStoreProductDto.class);

        if (productDto==null){
            throw new ProductNotExistException(
                "Product with id : " + id + " doesn't exist."
            );
        }
        return ConvertFakeStoreProducttoProduct(productDto);
    }

    @Override
    public List<Product> getAllProducts(){
        FakeStoreProductDto[] response = restTemplate.getForObject(
            "https://fakestoreapi.com/products",
            FakeStoreProductDto[].class
        );

        List<Product> answer = new ArrayList<>();
        for (FakeStoreProductDto dto: response){
            answer.add(ConvertFakeStoreProducttoProduct(dto));
        }

        return answer;

    }

    @Override
    public Product replaceProduct(Long id , Product product){
        //restTemplate.put(null, product);

        RequestCallback requestCallback = restTemplate.httpEntityCallback(new FakeStoreProductDto(),FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = 
            new HttpMessageConverterExtractor<>(FakeStoreProductDto.class,restTemplate.getMessageConverters());
        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor,new Object[]{});
        

        return ConvertFakeStoreProducttoProduct(response);
    }

    @Override
    public Product updateProduct(Long id, Product product){
        return null;
    }

    @Override
    public Product addNewProduct(Product product){
        return null;
    }

    @Override
    public boolean deleteProduct(Long id){
        return false;
    }
}
