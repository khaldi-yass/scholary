package com.yassir.scholary.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yassir.scholary.models.enumeration.ExamType;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * A ExamModel.
 */
@Entity
@Table(name = "exam")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class ExamModel extends ItemModel {

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type", nullable = false)
    private ExamType type;

    @Column(name = "coefficient")
    private Integer coefficient;

    @ManyToOne
    @JsonIgnoreProperties("")
    private SubjectModel subjectModel;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "exam_medias", joinColumns = @JoinColumn(name = "exams_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "medias_id", referencedColumnName = "id"))
    private Set<MediaModel> mediaModels = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("exams")
    private GradeBookModel gradeBookModel;

}
