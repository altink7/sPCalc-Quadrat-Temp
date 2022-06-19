package slm.slm;

        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/temp")
public class TempController {

    @GetMapping("/{value}")
    public String quadrat(@PathVariable float value){
        return String.format("%1.1f",(value-32)*5/9);
    }
}
