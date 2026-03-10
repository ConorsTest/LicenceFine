package gov.groupb.licencefine.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class PaymentWebController {

    @GetMapping()
    public String showPaymentPage(){
        return "payment";
    }
}
