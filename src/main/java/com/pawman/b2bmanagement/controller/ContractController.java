package com.pawman.b2bmanagement.controller;

import com.pawman.b2bmanagement.model.Company;
import com.pawman.b2bmanagement.model.Contract;
import com.pawman.b2bmanagement.service.GetDataService;
import com.pawman.b2bmanagement.service.SaveDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ContractController extends DefaultController {

    public static final String CONTRACTS = "contracts";
    private static final String ADD_CONTRACT = "/addContract";

    public ContractController(GetDataService getDataService, SaveDataService saveDataService) {
        super(getDataService, saveDataService);
    }


    @GetMapping("/contracts")
    public String showUsers(Model model) {
        model.addAttribute("contracts", getDataService.contracts());
        model.addAttribute("contractModel", new Contract());
        return CONTRACTS;
    }

    @GetMapping("/addContract")
    public String showAddUser(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("companies", getDataService.getCompanies().stream().filter(Company::isActive).collect(Collectors.toList()));
        return ADD_CONTRACT;
    }

    @PostMapping("/addContract")
    public String addUser(@ModelAttribute("contract") Contract contract) {
        Optional<Company> seller = getDataService.getCompaniesById(contract.getSeller().getId());

        Optional<Company> buyer = getDataService.getCompaniesById(contract.getBuyer().getId());

        contract.setSeller(seller.get());
        contract.setBuyer(buyer.get());
        contract.setVat(23);
        saveDataService.saveContract(contract);

        return redirect(CONTRACTS);
    }

    @PostMapping("/disableContract")
    public String disableContract(@ModelAttribute("contractModel") Contract contract) {
        saveDataService.disableContract(contract.getContractNumber());
        return redirect(CONTRACTS);
    }
}
