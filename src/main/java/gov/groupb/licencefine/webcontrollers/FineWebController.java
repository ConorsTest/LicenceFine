package gov.groupb.licencefine.webcontrollers;

import gov.groupb.licencefine.databasecontrollers.Fine;
import gov.groupb.licencefine.databasecontrollers.FineRepository;
import gov.groupb.licencefine.validators.NumberAndAddressForm;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

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
        Fine fine = repo.findByRefNum(numberAndAddressForm.getRefNum());
        if(fine == null){
            model.addAttribute("errorMessage",
                    "No Match for Reference Number");
            return "index";
        }
        if(!fine.getAddressLineOne().equals(numberAndAddressForm.getAddressLineOne())
            || !fine.getAddressLineTwo().equals(numberAndAddressForm.getAddressLineTwo())
            || !fine.getTownOrCity().equals(numberAndAddressForm.getTownOrCity())
            || !fine.getCounty().equals(numberAndAddressForm.getCounty())
            || !fine.getPostcode().equals(numberAndAddressForm.getPostcode())){

            model.addAttribute("errorMessage", "No Match for Address and Reference Number");

            return "index";
        }

        model.addAttribute("Success Message",
                "Details Submitted Successfully");
        return "redirect:/payment/" + numberAndAddressForm.getRefNum();
    }

}
