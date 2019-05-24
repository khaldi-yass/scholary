package com.yassir.scholary.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A StudentModel.
 */
@Entity
@Table(name = "student")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class StudentModel extends UserModel {

    @NotNull
    @Column(name = "enrollement_date", nullable = false)
    private LocalDate enrollementDate;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "student_parents", joinColumns = @JoinColumn(name = "students_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "parents_id", referencedColumnName = "id"))
    private Set<ParentModel> parentModels = new HashSet<>();

    @OneToOne(mappedBy = "studentModel")
    @JsonIgnore
    private GradeBookModel gradeBookModel;

    @ManyToOne
    @JsonIgnoreProperties("students")
    private SectionModel sectionModel;

}
