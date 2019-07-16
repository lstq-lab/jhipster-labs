package com.tanjie.demo.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A ExeciseEntry.
 */
@Entity
@Table(name = "execise_entry")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ExeciseEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "target")
    private Integer target;

    @Column(name = "is_finished")
    private Boolean isFinished;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "execiseEntry")
  //  @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ExeciseEntryGroup> execiseEntryGroups = new HashSet<>();

    @ManyToOne(targetEntity=ExeciseProject.class, optional=false)
    @JsonIgnoreProperties("execiseEntries")
    private ExeciseProject execiseProject;

    @ManyToOne(targetEntity = ExecisePlan.class ,optional = false)
    @JsonIgnoreProperties("execiseEntries")
    private ExecisePlan execisePlan;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTarget() {
        return target;
    }

    public ExeciseEntry target(Integer target) {
        this.target = target;
        return this;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Boolean isIsFinished() {
        return isFinished;
    }

    public ExeciseEntry isFinished(Boolean isFinished) {
        this.isFinished = isFinished;
        return this;
    }

    public void setIsFinished(Boolean isFinished) {
        this.isFinished = isFinished;
    }

    public Set<ExeciseEntryGroup> getExeciseEntryGroups() {
        return execiseEntryGroups;
    }

    public ExeciseEntry execiseEntryGroups(Set<ExeciseEntryGroup> execiseEntryGroups) {
        this.execiseEntryGroups = execiseEntryGroups;
        return this;
    }

    public ExeciseEntry addExeciseEntryGroup(ExeciseEntryGroup execiseEntryGroup) {
        this.execiseEntryGroups.add(execiseEntryGroup);
        execiseEntryGroup.setExeciseEntry(this);
        return this;
    }

    public ExeciseEntry removeExeciseEntryGroup(ExeciseEntryGroup execiseEntryGroup) {
        this.execiseEntryGroups.remove(execiseEntryGroup);
        execiseEntryGroup.setExeciseEntry(null);
        return this;
    }

    public void setExeciseEntryGroups(Set<ExeciseEntryGroup> execiseEntryGroups) {
        this.execiseEntryGroups = execiseEntryGroups;
    }

    public ExeciseProject getExeciseProject() {
        return execiseProject;
    }

    public ExeciseEntry execiseProject(ExeciseProject execiseProject) {
        this.execiseProject = execiseProject;
        return this;
    }

    public void setExeciseProject(ExeciseProject execiseProject) {
        this.execiseProject = execiseProject;
    }

    public ExecisePlan getExecisePlan() {
        return execisePlan;
    }

    public ExeciseEntry execisePlan(ExecisePlan execisePlan) {
        this.execisePlan = execisePlan;
        return this;
    }

    public void setExecisePlan(ExecisePlan execisePlan) {
        this.execisePlan = execisePlan;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ExeciseEntry)) {
            return false;
        }
        return id != null && id.equals(((ExeciseEntry) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ExeciseEntry{" +
            "id=" + getId() +
            ", target=" + getTarget() +
            ", isFinished='" + isIsFinished() + "'" +
            "}";
    }
}
