package com.highettmetal.restcontrollers;

import com.highettmetal.domain.PickupRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PickupRequestRestController {

    @PostMapping("/api/sendPickupRequest")
    public ResponseEntity sendPickupRequest(@RequestBody Map<String, PickupRequest> payload) {
        System.out.println("****** Pickup Request ******");
        System.out.println(payload.get("pickup_request").toString());
        return new ResponseEntity(HttpStatus.OK);
    }
}
