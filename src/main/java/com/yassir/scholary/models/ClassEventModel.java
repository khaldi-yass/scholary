package com.yassir.scholary.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A ClassEventModel.
 */
@Entity
@Table(name = "class_event")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class ClassEventModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(unique = true)
    private ItemModel pEvent;

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
