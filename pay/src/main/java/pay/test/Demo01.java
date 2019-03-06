package pay.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Demo01 {

    @RequestMapping(value = "/getString",method = RequestMethod.GET)
    public String getString(){
        return "success";
    }
}
