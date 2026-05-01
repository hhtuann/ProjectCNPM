package model;

import java.io.Serializable;
import java.util.Objects;

public class ContractJobShift implements Serializable {
    private int id;
    private int requiredWorkers;
    private double agreedWage;
    private Shift shift;

    public ContractJobShift() {
        super();
    }

    public ContractJobShift(int id, int requiredWorkers, double agreedWage, Shift shift) {
        super();
        this.id = id;
        this.requiredWorkers = requiredWorkers;
        this.agreedWage = agreedWage;
        this.shift = shift;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRequiredWorkers() {
        return requiredWorkers;
    }

    public void setRequiredWorkers(int requiredWorkers) {
        this.requiredWorkers = requiredWorkers;
    }

    public double getAgreedWage() {
        return agreedWage;
    }

    public void setAgreedWage(double agreedWage) {
        this.agreedWage = agreedWage;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ContractJobShift that)) return false;
        return Objects.equals(shift, that.shift);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(shift);
    }
}
