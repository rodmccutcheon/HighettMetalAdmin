package com.highettmetal.restcontrollers;

import com.highettmetal.domain.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuoteRestController {

    @PostMapping("/api/sendQuote")
    public ResponseEntity sendQuote(@RequestBody Quote quote) {
        System.out.println("****** Quote Request ******");
        System.out.println(quote.toString());
        return new ResponseEntity(HttpStatus.OK);
    }
}
