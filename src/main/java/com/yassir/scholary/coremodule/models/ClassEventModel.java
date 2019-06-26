package com.yassir.scholary.coremodule.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A ClassEventModel.
 */
@Entity
@Table(name = "class_event")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class ClassEventModel extends EventModel {

    @ManyToOne
    @JsonIgnoreProperties("")
    private TeacherModel teacherModel;

    @ManyToOne
    @JsonIgnoreProperties("classes")
    private SectionModel sectionModel;

    @ManyToOne
    @JsonIgnoreProperties("classEvents")
    private ClassRoomModel classRoomModel;

    @ManyToOne
    @JsonIgnoreProperties("classEvents")
    private SubjectModel subjectModel;

}
