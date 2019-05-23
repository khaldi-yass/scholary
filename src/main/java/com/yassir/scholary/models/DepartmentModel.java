package com.yassir.scholary.models;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A DepartmentModel.
 */
@Entity
@Table(name = "department")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class DepartmentModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "inauguration_date")
    private LocalDate inaugurationDate;

    @Column(name = "budget")
    private Integer budget;

    @OneToOne
    @JoinColumn(unique = true)
    private EmployeeModel chiefOfDepartment;

    @OneToOne
    @JoinColumn(unique = true)
    private ItemModel pItemModel;

    @OneToMany(mappedBy = "departmentModel")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<FieldOfStudyModel> fieldsOfStudies = new HashSet<>();
}
