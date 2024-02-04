package com.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("/orderFallback")
    public String orderServiceFallback(){
        return "Order Service is taking too long to respond or is down. Please try again later";
    }

    @RequestMapping("/productFallback")
    public String itemServiceFallback(){
        return "Product Service is taking too long to respond or is down. Please try again later";
    }
}
