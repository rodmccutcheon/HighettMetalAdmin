package com.highettmetal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by rodmccutcheon on 12/7/17.
 */
@Controller
public class IndexController {

    @GetMapping("/")
    String index() {
        return "index";
    }
}
