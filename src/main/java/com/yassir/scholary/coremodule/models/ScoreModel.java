package com.yassir.scholary.coremodule.models;

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
 * A ScoreModel.
 */
@Entity
@Table(name = "scores")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class ScoreModel extends ItemModel {

    @NotNull
    @Column(name = "score", nullable = false)
    private String score;

    @Column(name = "jury_remarks")
    private String juryRemarks;

    @Column(name = "parent_remarks")
    private String parentRemarks;

    @ManyToOne
    @JsonIgnoreProperties("")
    private StudentModel studentModel;

    @ManyToOne
    @JsonIgnoreProperties("")
    private ExamModel examModel;

}
