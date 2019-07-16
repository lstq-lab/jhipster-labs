package com.tanjie.demo.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A ExeciseEntryGroup.
 */
@Entity
@Table(name = "execise_entry_group")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ExeciseEntryGroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private Integer number;

    @ManyToOne(targetEntity = ExeciseEntry.class ,optional = false)
    @JsonIgnoreProperties("execiseEntryGroups")
    private ExeciseEntry execiseEntry;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ExeciseEntryGroup name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public ExeciseEntryGroup number(Integer number) {
        this.number = number;
        return this;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public ExeciseEntry getExeciseEntry() {
        return execiseEntry;
    }

    public ExeciseEntryGroup execiseEntry(ExeciseEntry execiseEntry) {
        this.execiseEntry = execiseEntry;
        return this;
    }

    public void setExeciseEntry(ExeciseEntry execiseEntry) {
        this.execiseEntry = execiseEntry;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ExeciseEntryGroup)) {
            return false;
        }
        return id != null && id.equals(((ExeciseEntryGroup) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ExeciseEntryGroup{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", number=" + getNumber() +
            "}";
    }
}
