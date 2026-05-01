package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Shift implements Serializable {
    private int id;
    private LocalDate workingDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public Shift() {
        super();
    }

    public Shift(int id, LocalDate workingDate, LocalTime startTime, LocalTime endTime) {
        super();
        this.id = id;
        this.workingDate = workingDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getWorkingDate() {
        return workingDate;
    }

    public void setWorkingDate(LocalDate workingDate) {
        this.workingDate = workingDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Shift shift)) return false;
        return id == shift.id && Objects.equals(workingDate, shift.workingDate) && Objects.equals(startTime, shift.startTime) && Objects.equals(endTime, shift.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workingDate, startTime, endTime);
    }
}
