package gov.groupb.licencefine.webcontrollers;

import gov.groupb.licencefine.databasecontrollers.FineRepository;
import gov.groupb.licencefine.validators.NumberAndAddressForm;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FineWebController {

    private final FineRepository repo;

    public FineWebController(FineRepository repo){
        this.repo = repo;
    }

    @GetMapping
    public String showIndex(Model model){
        model.addAttribute("numberAndAddressForm",
                new NumberAndAddressForm());
        return "index";
    }

    @PostMapping
    public String postIndex(@Valid NumberAndAddressForm numberAndAddressForm,
                            BindingResult result,
                            Model model){

        if(result.hasErrors()){
            System.err.println(result.getAllErrors());
            return "index";
        }
        model.addAttribute("Success Message",
                "Details Submitted Successfully");
            return "payment";
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
