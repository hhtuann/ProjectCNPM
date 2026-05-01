package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Contract implements Serializable {
    private int id;
    private LocalDate contractDate;
    private String paymentMethod;
    private double totalJobWage;
    private String status = "Chưa xác nhận";
    private Customer customer;
    private SalesManager salesManager;
    private ArrayList<ContractJob> contractJobs = new ArrayList<>();

    public Contract() {
        super();
    }

    public Contract(int id, LocalDate contractDate, String paymentMethod, String status, Customer customer, SalesManager salesManager, ArrayList<ContractJob> contractJobs) {
        super();
        this.id = id;
        this.contractDate = contractDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.customer = customer;
        this.salesManager = salesManager;
        this.contractJobs = contractJobs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void calculateTotalJobWage() {
        this.totalJobWage = 0;
        for (ContractJob cj : contractJobs) {
            this.totalJobWage += cj.getTotalShiftWage();
        }
    }

    public double getTotalJobWage() {
        return totalJobWage;
    }

    public void setTotalJobWage(double totalJobWage) {
        this.totalJobWage = totalJobWage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SalesManager getSalesManager() {
        return salesManager;
    }

    public void setSalesManager(SalesManager salesManager) {
        this.salesManager = salesManager;
    }

    public ArrayList<ContractJob> getContractJobs() {
        return contractJobs;
    }

    public void setContractJobs(ArrayList<ContractJob> contractJobs) {
        this.contractJobs = contractJobs;
    }
}
