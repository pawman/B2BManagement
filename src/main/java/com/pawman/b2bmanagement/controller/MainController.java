package com.pawman.b2bmanagement.controller;

import com.pawman.b2bmanagement.helper.MapCommandHelper;
import com.pawman.b2bmanagement.service.SaveDataService;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    private final MapCommandHelper mapCommandHelper;
    private final SaveDataService saveDataService;

    public MainController(MapCommandHelper mapCommandHelper, SaveDataService saveDataService) {
        this.mapCommandHelper = mapCommandHelper;
        this.saveDataService = saveDataService;
    }

}
