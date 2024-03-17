package personalproject.productservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import personalproject.productservice.Models.Category;
import java.util.List;


@Repository
public interface CategoryRepository  extends JpaRepository<Category,Long> {
    
    Optional<Category> findByname(String name);
}
