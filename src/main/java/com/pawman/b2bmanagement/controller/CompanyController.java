package com.pawman.b2bmanagement.controller;

import com.pawman.b2bmanagement.model.Bank;
import com.pawman.b2bmanagement.model.Company;
import com.pawman.b2bmanagement.model.User;
import com.pawman.b2bmanagement.service.GetDataService;
import com.pawman.b2bmanagement.service.SaveDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class CompanyController extends DefaultController {

    public static final String COMPANIES = "companies";
    public static final String ADD_COMPANY = "addCompany";

    public CompanyController(GetDataService getDataService, SaveDataService saveDataService) {
        super(getDataService, saveDataService);
    }

    @GetMapping("/companies")
    public String showCompanies(Model model){
        List<Company> companies = getDataService.getCompanies();
        model.addAttribute("companies", companies);
        model.addAttribute("companyModel", new Company());
        return COMPANIES;
    }

    @GetMapping("/addCompany")
    public String showAddCompany(Model model) {
        model.addAttribute("company", new Company());
        model.addAttribute("users", getDataService.getUsers().stream().filter(User::isActive).collect(Collectors.toList()));
        return ADD_COMPANY;
    }

    @PostMapping("/addCompany")
    public String addCompany(@ModelAttribute("company") Company company) {
        Optional<User> userById = getDataService.getUserById(company.getUser().getId());
        company.setUser(userById.get());

        Bank bank = saveDataService.saveBank(company.getBank());
        company.setBank(bank);
        saveDataService.saveCompany(company);

        return redirect(COMPANIES);
    }
    @PostMapping("/disableCompany")
    public String disableCompany(@ModelAttribute("companyModel") Company company) {
        saveDataService.disableCompany(company.getId());
        return redirect(COMPANIES);
    }
}
