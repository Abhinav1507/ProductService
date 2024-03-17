package personalproject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import personalproject.productservice.Controllers.ProductController;

//@SpringBootTest
public class RandomTest {
    
    //@Autowired
    //private ProductController productController;

    @Test
    void testOnePlusOneIsTwo(){
        int i = 1+1;

        assert i==2;

        assertTrue(i==2);
    }
}
