package com.yassir.scholary.models;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A TeacherModel.
 */
@Entity
@Table(name = "teacher")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class TeacherModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(unique = true)
    private EmployeeModel pEmployeeModel;

    @OneToMany(mappedBy = "teacherModel")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<SubjectModel> subjectModels = new HashSet<>();
    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "teacher_sections", joinColumns = @JoinColumn(name = "teachers_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "sections_id", referencedColumnName = "id"))
    private Set<SectionModel> sectionModels = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "teacher_class_rooms", joinColumns = @JoinColumn(name = "teachers_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "class_rooms_id", referencedColumnName = "id"))
    private Set<ClassRoomModel> classRoomModels = new HashSet<>();

}
