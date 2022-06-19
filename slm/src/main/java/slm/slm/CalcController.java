package slm.slm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/calc")
public class CalcController {

    @GetMapping("/{value1}/{func}/{value2}")
    public String calc(@PathVariable String value1, @PathVariable String func,@PathVariable String value2){
        if(func.equals("+")) return String.valueOf(Integer.parseInt(value1)+Integer.parseInt(value2));
        else if(func.equals("-")) return String.valueOf(Integer.parseInt(value1)-Integer.parseInt(value2));
        else if(func.equals("*")) return String.valueOf(Integer.parseInt(value1)*Integer.parseInt(value2));
        else if(func.equals("/")&&Integer.parseInt(value2)!=0) return String.valueOf(Integer.parseInt(value1)/Integer.parseInt(value2));
        else return String.format("%s %s %s %s","no calculation possible", value1,func,value2);
    }

}
