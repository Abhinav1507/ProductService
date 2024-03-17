package personalproject.productservice.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import personalproject.productservice.Models.Product;
import personalproject.productservice.repositories.projections.ProductProjection;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository 
    extends JpaRepository<Product,Long>{
    
        Optional<Product> findById(Long id);
        // will return if the Product with given id

        List <Product> findAll();

        Product save(Product product);


        @Modifying
        @Query("update Product p set p= :product where p.id=:id")
        Product setProduct(@Param("id") Long id, @Param("product") Product product);
}
