package com.webtutsplus.ecommerce.controller;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.SetupIntent;
import com.stripe.model.checkout.Session;
import com.stripe.param.SetupIntentCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import com.webtutsplus.ecommerce.model.CheckoutBody;
import com.webtutsplus.ecommerce.model.StripeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/checkout")
public class StripeController {

    @PostMapping("/create-checkout-session")
    public ResponseEntity<StripeResponse> checkout(@RequestBody CheckoutBody checkoutBody) throws StripeException {

        Stripe.apiKey = "sk_test_51Hr18ILR0wfBoBqmdYfX2snbVHPvMxGsUOUs0bZnOgJ28gGgGzOhvadzEjR0LDRS6naI0RMADLywiSiWD8pkhkEW00xnzbVoVE";

        long quantity = checkoutBody.getQuantity();
        long price = checkoutBody.getPrice()*100;
        String productName = checkoutBody.getProductName();

        SessionCreateParams params = SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                //Have to change the success and cancel url's
                .setSuccessUrl("https://google.com")
                .setCancelUrl("https://google.com")
                .addLineItem(
                        SessionCreateParams.LineItem.builder()
                                .setQuantity(quantity)
                                .setPriceData(
                                        SessionCreateParams.LineItem.PriceData.builder()
                                                .setCurrency("inr")
                                                .setUnitAmount(price)
                                                .setProductData(
                                                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                .setName(productName)
                                                                .build())
                                                .build())
                                .build())
                .build();
        Session session = Session.create(params);
        HashMap<String, String> responseData = new HashMap<String, String>();
        responseData.put("id", session.getId());

        System.out.println(session.getId());

        StripeResponse stripeResponse = new StripeResponse(session.getId());

        return new ResponseEntity<StripeResponse>(stripeResponse,HttpStatus.OK);

    }
//    @GetMapping("/get-setup-intent")
//    public SetupIntent createSetupToken(@RequestBody CheckoutBody checkoutBody) throws StripeException {
//
//        SetupIntentCreateParams params =
//                SetupIntentCreateParams.builder()
//                        .setUsage(SetupIntentCreateParams.Usage.ON_SESSION)
//                        .build();
//
//        SetupIntent setupIntent = SetupIntent.create(params);
//        System.out.println("SetupIntent : " + setupIntent.getId() +  "   " + setupIntent.toString());
//        return setupIntent;
//    }


}
