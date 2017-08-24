package com.highettmetal.controllers;

import com.highettmetal.services.ClientTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("clientTypes")
public class ClientTypeController {

    private final ClientTypeService clientTypeService;

    @Autowired
    public ClientTypeController(ClientTypeService clientTypeService) {
        this.clientTypeService = clientTypeService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("clientTypes", clientTypeService.listAllClientTypes());
        return "clientTypes/clientTypes";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        clientTypeService.deleteClientType(id);
        return "redirect:/clientTypes";
    }
}
