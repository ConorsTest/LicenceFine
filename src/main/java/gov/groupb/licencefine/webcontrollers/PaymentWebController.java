package gov.groupb.licencefine.webcontrollers;

import gov.groupb.licencefine.databasecontrollers.Fine;
import gov.groupb.licencefine.databasecontrollers.FineRepository;
import gov.groupb.licencefine.validators.CardForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentWebController {
    private final FineRepository fineRepository;

    public PaymentWebController(FineRepository fineRepository) {
        this.fineRepository = fineRepository;
    }

    @GetMapping("/{refNum}")
    public String showPaymentPage(@PathVariable String refNum, Model model,
                                  CardForm cardForm) {

        Fine fine = fineRepository.findByRefNum(refNum);

        model.addAttribute("fine", fine); //This is still needed for the details on the left hand side of the screen.
        model.addAttribute("cardForm", cardForm);

        return "payment";
    }

    @PostMapping("/process")
    public String processPayment(
            @Valid CardForm cardForm,
            BindingResult result,
            Model model) {
        if(result.hasErrors()){
            System.err.println(result.getAllErrors());
            System.err.println("Oh No");
            return "payment";
        }
        model.addAttribute("Success message",
                "Details submitted successfully");

        Fine fine = fineRepository.findByRefNum(cardForm.getRefNum());

        fine.setEmail(cardForm.getEmail());
        fine.setPaid(true);

        fineRepository.save(fine);

        System.err.println("success");
        return "redirect:/payment/success";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }
}
