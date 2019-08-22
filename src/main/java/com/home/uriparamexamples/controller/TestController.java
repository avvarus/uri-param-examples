package com.home.uriparamexamples.controller;


import com.home.uriparamexamples.exceptions.InvalidCountryException;
import com.home.uriparamexamples.model.Country;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {


// By default it was added to any mapping @ResponseBody
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


    ////http://localhost:8080/save?a=10&b=200

    @GetMapping(value = "/save")
    public ResponseEntity<String> toStrin11(@RequestParam int a, @RequestParam int b) {

        //return ResponseEntity.status(HttpStatus.ACCEPTED).body("Well Done my Boy !! ");

        return ResponseEntity.status(200).body("tesion padadku");
    }

    //http://zetcode.com/springboot/responseentity/

    @GetMapping(value = "/resEntity")
    public ResponseEntity<Country> getCuntry() {

        Country c = new Country();
        c.setName("France");
        c.setPopulation(66984000);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Responded", "MyController");
        headers.add("First Check", "My World");

        return ResponseEntity.accepted().headers(headers).body(c);
    }


    @GetMapping(value = "/resBody")
    @ResponseBody
    public Country resBody() {

        return new Country("India", 879799);
    }


    /**
     *  Uusally no difference between adding @ResponseBody
     */


    @PostMapping(value = "/sav")
    @ResponseBody
    public ResponseEntity<Country> saveCuntry(@RequestBody Country country) {

        if (StringUtils.isEmpty(country.getName())) {

            throw new InvalidCountryException("Country Name is empty !!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ExceptionHandler
    public String handleInvalidCountryException(InvalidCountryException exception) {

        System.out.println("TestController.handleInvalidCountryException -- >");

        return exception.getMessage();
    }
}
