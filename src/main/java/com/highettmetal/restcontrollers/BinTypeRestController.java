package com.highettmetal.restcontrollers;

import com.highettmetal.domain.BinType;
import com.highettmetal.services.BinTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class BinTypeRestController {

    private BinTypeService binTypeService;

    @Autowired
    public BinTypeRestController(BinTypeService binTypeService) {
        this.binTypeService = binTypeService;
    }

    @GetMapping("/api/getBins")
    public HashMap<String, List<BinType>> getBinTypes() {
        HashMap<String, List<BinType>> returnMap = new HashMap<>();
        returnMap.put("bins", binTypeService.listAllBinTypes());
        return returnMap;
    }
}
