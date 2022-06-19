package slm.slm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/quadrat")
public class QuadratController {

    @GetMapping("/{value}/{power}")//wert und hoch X eingeben
    public int quadrat(@PathVariable int value,@PathVariable int power){
        return (int) Math.pow(value,power);
    }
}
