
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration
@Controller
@SpringBootApplication  
public class TesterMan{
	
	public static void main(String[] args) throws Exception {  
        SpringApplication.run(TesterMan.class, args);  
    }  
    @RequestMapping("/tt")
    public String index(Map<String,Object> a){
    	System.out.println(2);
    	return "/tt";
    }
}