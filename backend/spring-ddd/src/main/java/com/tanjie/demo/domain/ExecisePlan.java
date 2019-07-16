package com.tanjie.demo.domain;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * A ExecisePlan.
 */
@Entity
@Table(name = "execise_plan")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ExecisePlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time")
    private Instant startTime;

    @Column(name = "end_time")
    private Instant endTime;

    @Column(name = "jhi_group")
    private Integer group;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "execisePlan")
    //@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ExeciseEntry> execiseEntries = new HashSet<>();



    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public ExecisePlan startTime(Instant startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public ExecisePlan endTime(Instant endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public Integer getGroup() {
        return group;
    }

    public ExecisePlan group(Integer group) {
        this.group = group;
        return this;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Set<ExeciseEntry> getExeciseEntries() {
        return execiseEntries;
    }

    public ExecisePlan execiseEntries(Set<ExeciseEntry> execiseEntries) {
        this.execiseEntries = execiseEntries;
        return this;
    }

    public ExecisePlan addExeciseEntry(ExeciseEntry execiseEntry) {
        this.execiseEntries.add(execiseEntry);
        execiseEntry.setExecisePlan(this);
        return this;
    }
    
    public ExecisePlan deleteExeciseEntry(ExeciseEntry execiseEntry) {
        this.execiseEntries.remove(execiseEntry);
        execiseEntry.setExecisePlan(null);
        return this;
    }
    

    public ExecisePlan removeExeciseEntry(ExeciseEntry execiseEntry) {
        this.execiseEntries.remove(execiseEntry);
        execiseEntry.setExecisePlan(null);
        return this;
    }

    public void setExeciseEntries(Set<ExeciseEntry> execiseEntries) {
        this.execiseEntries = execiseEntries;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ExecisePlan)) {
            return false;
        }
        return id != null && id.equals(((ExecisePlan) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ExecisePlan{" +
            "id=" + getId() +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", group=" + getGroup() +
            "}";
    }
}
