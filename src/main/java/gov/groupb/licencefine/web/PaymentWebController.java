package gov.groupb.licencefine.web;

import gov.groupb.licencefine.databasecontrollers.Fine;
import gov.groupb.licencefine.databasecontrollers.FineRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/payment")
public class PaymentWebController {
    private final FineRepository fineRepository;

    public PaymentWebController(FineRepository fineRepository) {
        this.fineRepository = fineRepository;
    }

    @GetMapping("/{refNum}")
    public String showPaymentPage(@PathVariable String refNum, Model model) {

        Fine fine = fineRepository.findByRefNum(refNum);

        model.addAttribute("fine", fine);

        return "payment";
    }

    @PostMapping("/process")
    public String processPayment(
            @RequestParam String refNum,
            @RequestParam String email
    ) {

        Fine fine = fineRepository.findByRefNum(refNum);

        fine.setEmail(email);
        fine.setPaid(true);

        fineRepository.save(fine);

        return "redirect:/payment/success";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }
}
