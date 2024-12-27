package jay.johnray_myportfolio_master;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/")
    public String index() {
        return "views/index";
    }
}
