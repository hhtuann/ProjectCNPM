package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class ContractJob implements Serializable {
    private int id;
    private Job job;
    private double totalShiftWage;
    private ArrayList<ContractJobShift> contractJobShifts = new ArrayList<>();

    public ContractJob() {
        super();
    }

    public ContractJob(int id, Job job, ArrayList<ContractJobShift> contractJobShifts) {
        super();
        this.id = id;
        this.job = job;
        this.contractJobShifts = contractJobShifts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void calculateTotalShiftWage() {
        this.totalShiftWage = 0;
        for (ContractJobShift cjs : contractJobShifts) {
            this.totalShiftWage += cjs.getAgreedWage() * cjs.getRequiredWorkers() * 3;
        }
    }

    public double getTotalShiftWage() {
        return totalShiftWage;
    }

    public void setTotalShiftWage(double totalShiftWage) {
        this.totalShiftWage = totalShiftWage;
    }

    public ArrayList<ContractJobShift> getContractJobShifts() {
        return contractJobShifts;
    }

    public void setContractJobShifts(ArrayList<ContractJobShift> contractJobShifts) {
        this.contractJobShifts = contractJobShifts;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ContractJob that)) return false;
        return Objects.equals(job, that.job);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(job);
    }
}
