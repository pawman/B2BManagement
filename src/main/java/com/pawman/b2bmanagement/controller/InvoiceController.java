package com.pawman.b2bmanagement.controller;

import com.pawman.b2bmanagement.command.InvoiceCommand;
import com.pawman.b2bmanagement.model.Contract;
import com.pawman.b2bmanagement.model.DataModel;
import com.pawman.b2bmanagement.model.Invoice;
import com.pawman.b2bmanagement.service.GetDataService;
import com.pawman.b2bmanagement.service.SaveDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;

@Controller
public class InvoiceController extends DefaultController {

    public static final String INVOICES = "invoices";
    private static final String ADD_INVOICE = "/addInvoice";

    public InvoiceController(GetDataService getDataService, SaveDataService saveDataService) {
        super(getDataService, saveDataService);
    }

    @GetMapping("/invoices")
    public String invoices(Model model) {
        model.addAttribute("invoices", getDataService.invoices());
        model.addAttribute("invoiceModel", new Invoice());
        return INVOICES;
    }

    @GetMapping("/addInvoice")
    public String addInvoice(Model model) {
        InvoiceCommand invoiceCommand = new InvoiceCommand();
        invoiceCommand.setSaleDate(getDefaultSalesDate());
        invoiceCommand.setDateOfIssue(getDefaultDateOfIssue());
        invoiceCommand.setDateOfPayment(getDefaultDateOfPayment());

        List<Contract> contracts = getDataService.contracts();
        model.addAttribute("contracts", contracts.stream().filter(Contract::isActive).collect(Collectors.toList()));
        model.addAttribute("invoiceCommand", invoiceCommand);
        return ADD_INVOICE;
    }

    @PostMapping("/deleteInvoice")
    public String deleteInvoice(@ModelAttribute("invoiceModel") Invoice invoice) {
        saveDataService.deleteInvoice(invoice.getId());
        return redirect(INVOICES);
    }

    @PostMapping("/addInvoice")
    public String addUser(@ModelAttribute("invoiceCommand") InvoiceCommand invoiceCommand) {

        Optional<Contract> contract = getDataService.getContractById(invoiceCommand.getContract().getContractNumber());

        Invoice invoice = new Invoice();
        invoice.setContract(contract.get());

        List<Invoice> invoices = getDataService.invoices();

        OptionalLong numberOpt = invoices.stream()
                .filter(inv -> inv.getSaleDate().getYear() == LocalDateTime.now().getYear())
                .sorted(Comparator.comparingLong(Invoice::getNumber).reversed())
                .mapToLong(Invoice::getNumber)
                .findFirst();

        invoice.setNumber(numberOpt.orElse(0) + 1);
        invoice.setNumberOfHours(invoiceCommand.getNumberOfHours());

        invoice.setSaleDate(toLocalDataTime(invoiceCommand.getSaleDate()));
        invoice.setDateOfPayment(toLocalDataTime(invoiceCommand.getDateOfPayment()));
        invoice.setDateOfIssue(toLocalDataTime(invoiceCommand.getDateOfIssue()));
        invoice.setMethodOfPayment(invoiceCommand.getMethodOfPayment());

        saveDataService.saveInvoice(invoice);

        return redirect(INVOICES);
    }

    private DataModel getDefaultSalesDate() {
        LocalDateTime now = LocalDateTime.now();
        now = now.minusMonths(1);

        int paymentDay = now.getMonth().length((now.getYear() % 4 == 0));

        now = now.withDayOfMonth(paymentDay);

        return new DataModel(now);
    }

    private DataModel getDefaultDateOfIssue() {
        LocalDateTime now = LocalDateTime.now();
        now = now.minusMonths(1);

        int paymentDay = now.getMonth().length((now.getYear() % 4 == 0));
        now = now.withDayOfMonth(paymentDay);

        return new DataModel(now);
    }

    private DataModel getDefaultDateOfPayment() {
        LocalDateTime now = LocalDateTime.now();
        now = now.withDayOfMonth(14);

        return new DataModel(now);
    }

    private LocalDateTime toLocalDataTime(DataModel dataModel) {
        return LocalDateTime.of(dataModel.getYear(), dataModel.getMonth(), dataModel.getDay(), 0, 0);
    }
}
