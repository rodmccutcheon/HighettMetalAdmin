package com.highettmetal.controllers;

import com.highettmetal.domain.Client;
import com.highettmetal.services.ClientService;
import com.highettmetal.services.ClientTypeService;
import com.highettmetal.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rodmccutcheon on 12/7/17.
 */
@Controller
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;
    private ClientTypeService clientTypeService;
    private ProductCategoryService productCategoryService;

    @Autowired
    public ClientController(ClientService clientService, ClientTypeService clientTypeService, ProductCategoryService productCategoryService) {
        this.clientService = clientService;
        this.clientTypeService = clientTypeService;
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("clients", clientService.listAllClients());
        return "clients/clients";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("client", new Client());
        return "clients/client-form";
    }

    @PostMapping
    public String save(Client client) {
        clientService.saveClient(client);
        return "redirect:/clients/" + client.getId();
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.getClientById(id));
        model.addAttribute("clientTypes", clientTypeService.listAllClientTypes());
        model.addAttribute("productCategories", productCategoryService.findAllProductCategories());
        return "clients/client-show";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.getClientById(id));
        return "clients/client-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "redirect:/clients/";
    }
}
