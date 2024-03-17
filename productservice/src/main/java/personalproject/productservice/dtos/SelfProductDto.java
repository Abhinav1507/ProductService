package personalproject.productservice.dtos;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelfProductDto {
    
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String imgUrl;
    private Long num_of_sales;
    private Date createdAt;
    private Date LastUpdatedAt;
    private boolean isdeleted;
    
}
