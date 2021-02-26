package com.webtutsplus.ecommerce.controller;

import com.stripe.model.Charge;
import com.webtutsplus.ecommerce.model.PaymentBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private StripeClient stripeClient;

    @Autowired
    PaymentController(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    @PostMapping("/charge")
    public Charge chargeCard(PaymentBody body) throws Exception {

        //Need to generate the token from front end
        String token = body.getToken();
        Double amount = body.getAmount();
        return this.stripeClient.chargeCreditCard(token, amount);
    }
}
