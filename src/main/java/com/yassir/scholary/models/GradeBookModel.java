package com.yassir.scholary.models;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A GradeBookModel.
 */
@Entity
@Table(name = "grade_book")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class GradeBookModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "year_start")
    private LocalDate yearStart;

    @Column(name = "year_snd")
    private LocalDate yearSnd;

    @Column(name = "final_score")
    private String finalScore;

    @Column(name = "merit")
    private String merit;

    @Column(name = "jury_decision")
    private String juryDecision;

    @Column(name = "jury_remarks")
    private String juryRemarks;

    @Column(name = "parents_remarks")
    private String parentsRemarks;

    @OneToOne
    @JoinColumn(unique = true)
    private StudentModel studentModel;

    @OneToOne
    @JoinColumn(unique = true)
    private ItemModel pItemModel;

    @OneToMany(mappedBy = "gradeBookModel")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ExamModel> examModels = new HashSet<>();

}
