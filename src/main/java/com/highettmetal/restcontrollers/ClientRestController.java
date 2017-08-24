package com.highettmetal.restcontrollers;

import com.fasterxml.jackson.annotation.JsonView;
import com.highettmetal.domain.Client;
import com.highettmetal.domain.User;
import com.highettmetal.jsonviews.Views;
import com.highettmetal.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@Controller
public class ClientRestController {

    private ClientService clientService;

    @Autowired
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @JsonView(Views.Client.class)
    @PostMapping("/api/getUser")
    public ResponseEntity getUser(@RequestBody User user) {
        HashMap<String, Client> returnMap = new HashMap<>();
        Client c = clientService.authenticateClient(user.getUsername(), user.getPassword());
        if (c != null) {
            returnMap.put("user", c);
            return new ResponseEntity(returnMap, HttpStatus.OK);
        } else {
            return new ResponseEntity("Incorrect username/password.", HttpStatus.UNAUTHORIZED);
        }
    }
}
