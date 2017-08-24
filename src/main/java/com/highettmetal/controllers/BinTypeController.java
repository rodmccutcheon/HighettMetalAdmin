package com.highettmetal.controllers;

import com.highettmetal.domain.BinType;
import com.highettmetal.services.BinTypeService;
import com.highettmetal.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.nio.file.Paths;

@Controller
@RequestMapping("binTypes")
public class BinTypeController {

    private final BinTypeService binTypeService;

    private final StorageService storageService;

    private final ServletContext servletContext;

    @Autowired
    public BinTypeController(BinTypeService binTypeService, StorageService storageService, ServletContext servletContext) {
        this.binTypeService = binTypeService;
        this.storageService = storageService;
        this.servletContext = servletContext;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("binTypes", binTypeService.listAllBinTypes());
        return "binTypes/binTypes";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("binType", new BinType());
        return "binTypes/binTypes-form";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("binType", binTypeService.getBinTypeById(id));
        return "binTypes/binTypes-show";
    }

    @PostMapping
    public String save(@RequestParam("file") MultipartFile file, BinType binType) {
        storageService.store(Paths.get(servletContext.getRealPath("/")), file);
        binTypeService.saveBinType(binType);
        return "redirect:/binTypes/" + binType.getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("binType", binTypeService.getBinTypeById(id));
        return "binTypes/binTypes-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        binTypeService.deleteBinType(id);
        return "redirect:/binTypes/";
    }
}
