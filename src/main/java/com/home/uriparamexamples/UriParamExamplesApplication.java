package com.home.uriparamexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class UriParamExamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UriParamExamplesApplication.class, args);
    }


    //@PathVariable

    @GetMapping(value = "/get/{a}/{b}")
    public String toStrin(@PathVariable int a, @PathVariable int b) {

        return "Hello World !!" + a + " -- " + b;
    }


    //@RequestParam
    //http://localhost:8080/get?a=10&b=200

    @GetMapping(value = "/get")
    public String toStrin1(@RequestParam int a, @RequestParam int b) {

        return "Hello World !!" + a + " -- " + b;
    }

//    @GetMapping(value = "/get")
//    public String toStrin11(@RequestAttribute int b) {
//
//        return "Hello World !!" + a + " -- " + b;
//    }

}
