package model;

import java.io.Serializable;
import java.util.Objects;

public class Job implements Serializable {
    private int id;
    private String jobName;
    private String description;
    private String skill;

    public Job() {
        super();
    }

    public Job(int id, String jobName, String description, String skill) {
        super();
        this.id = id;
        this.jobName = jobName;
        this.description = description;
        this.skill = skill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Job job)) return false;
        return id == job.id && Objects.equals(jobName, job.jobName) && Objects.equals(description, job.description) && Objects.equals(skill, job.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, jobName, description, skill);
    }
}
