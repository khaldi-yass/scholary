package com.yassir.scholary.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A ProfessionModel.
 */
@Entity
@Table(name = "professions")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class ProfessionModel extends ItemModel {

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "salary")
    private Long salary;

    @ManyToOne
    @JsonIgnoreProperties("")
    private DepartmentModel departmentModel;

}
