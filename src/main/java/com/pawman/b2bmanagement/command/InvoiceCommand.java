package com.pawman.b2bmanagement.command;

import com.pawman.b2bmanagement.model.Contract;
import com.pawman.b2bmanagement.model.DataModel;


public class InvoiceCommand {

    private static final String PRZELEW = "przelew";

    private Contract contract;

    private int numberOfHours;

    private DataModel saleDate;

    private DataModel dateOfIssue;

    private DataModel dateOfPayment;

    private String methodOfPayment = PRZELEW;

    public InvoiceCommand() {
    }

    public InvoiceCommand(Contract contract, DataModel saleDate, DataModel dateOfIssue, DataModel dateOfPayment, String methodOfPayment, int numberOfHours) {
        this.contract = contract;
        this.saleDate = saleDate;
        this.dateOfIssue = dateOfIssue;
        this.dateOfPayment = dateOfPayment;
        this.numberOfHours = numberOfHours;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public DataModel getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(DataModel saleDate) {
        this.saleDate = saleDate;
    }

    public DataModel getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(DataModel dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public DataModel getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(DataModel dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getMethodOfPayment() {
        return methodOfPayment;
    }

    public void setMethodOfPayment(String methodOfPayment) {
        this.methodOfPayment = methodOfPayment;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }
}
