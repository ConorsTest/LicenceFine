package gov.groupb.licencefine.web;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/index")

public class LandingWebController {

    @GetMapping

    public String showPaymentPage(){

        return "index";

    }

}

