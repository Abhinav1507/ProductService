package personalproject.productservice.Controllers;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import personalproject.productservice.services.Productservice;

@SpringBootTest
public class ProductControllerTest {

    private ProductController productController;

    @MockBean
    private Productservice productservice;

    @Test
    void testProductSameAsService(){
        when(
            productservice.getAllProducts() 
        ).thenReturn(
            new ArrayList<>()
        );
    }

    @Test
    void testAddnewProduct() {

    }

    @Test
    void testDeleteProduct() {

    }

    @Test
    void testGetAllProducts() {

    }

    @Test
    void testGetSingleProduct() {

    }

    @Test
    void testReplaceProduct() {

    }

    @Test
    void testUpdateProduct() {

    }
}
