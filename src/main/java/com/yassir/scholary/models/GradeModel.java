package com.yassir.scholary.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A GradeModel.
 */
@Entity
@Table(name = "grade")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class GradeModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(unique = true)
    private MediaModel diplomaOrCertificate;

    @OneToOne
    @JoinColumn(unique = true)
    private ItemModel pItemModel;

    @OneToMany(mappedBy = "gradeModel")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<SubjectModel> subjectModels = new HashSet<>();
    @OneToMany(mappedBy = "gradeModel")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<SectionModel> sectionModels = new HashSet<>();
    @ManyToOne
    @JsonIgnoreProperties("")
    private FieldOfStudyModel fieldOfStudyModel;

    @ManyToOne
    @JsonIgnoreProperties("")
    private GeneralLevelModel generalLevelModel;

}
