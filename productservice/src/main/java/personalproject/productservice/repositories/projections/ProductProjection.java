package personalproject.productservice.repositories.projections;

import personalproject.productservice.Models.Category;

public interface ProductProjection {
    Long getId();
    Category getCategory();
    String getTitle();
    
}
