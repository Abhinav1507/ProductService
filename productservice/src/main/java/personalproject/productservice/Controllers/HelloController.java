package personalproject.productservice.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



//This class will be serviving Rest (Http) APIs//
//localhost:8080/hello//
@RestController
@RequestMapping("/hello")
public class HelloController {
    
    @GetMapping("/say/{name}/{times}")
    public String sayHello(@PathVariable("name") String name,
    @PathVariable("times") int times){

        String answer = "";
        for (int i=0; i<times ; ++i){
            answer += "Hello " + name;
            answer += "\n";
        }
        return answer;
    }
}
