package gov.groupb.licencefine.webcontrollers;

import gov.groupb.licencefine.databasecontrollers.FineRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FineWebController {

    private final FineRepository repo;

    public FineWebController(FineRepository repo){
        this.repo = repo;
    }

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/payment")
    public String payment(){
        return "payment";
    }

    @GetMapping("/success")
    public String success(){
        return "success";
    }

}
