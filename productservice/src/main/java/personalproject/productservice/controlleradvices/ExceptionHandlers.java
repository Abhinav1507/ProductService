package personalproject.productservice.controlleradvices;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import personalproject.productservice.dtos.ArithmeticExceptiondto;
import personalproject.productservice.dtos.exceptiondto;
import personalproject.productservice.exceptions.ProductNotExistException;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptiondto> handleArithmeticException(){
        ArithmeticExceptiondto arithmeticExceptiondto = new ArithmeticExceptiondto();
        arithmeticExceptiondto.setMessage("something is happening");
        return new ResponseEntity<ArithmeticExceptiondto>(arithmeticExceptiondto, HttpStatus.OK);
    }

    @ExceptionHandler(ProductNotExistException.class)
    public ResponseEntity<exceptiondto> handleProductNotExistException(ProductNotExistException productNotExistException ){
        exceptiondto dto = new exceptiondto();
        dto.setMessage(productNotExistException.getMessage());
        dto.setDetail("Check the product id. It probably doesn't exist.");
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    
}
