package com.credify.project.utils;

public class LoanDetails {
    private String loanAmount;
    private String monthlyPayment;
    private String term;
    private String interestRate;
    private String APR;

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(String monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getAPR() {
        return APR;
    }

    public void setAPR(String APR) {
        this.APR = APR;
    }
}
