package com.pawman.b2bmanagement.controller;

import com.pawman.b2bmanagement.service.GetDataService;
import com.pawman.b2bmanagement.service.SaveDataService;

public class DefaultController {
    private static final String REDIRECT = "redirect:/%s";

    protected final GetDataService getDataService;
    protected final SaveDataService saveDataService;

    public DefaultController(GetDataService getDataService, SaveDataService saveDataService) {
        this.getDataService = getDataService;
        this.saveDataService = saveDataService;
    }

    protected String redirect(String page) {
        return String.format(REDIRECT, page);
    }
}
