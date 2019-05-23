package com.yassir.scholary.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A ClassRoomModel.
 */
@Entity
@Table(name = "class_room")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class ClassRoomModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "jhi_zone")
    private String zone;

    @OneToOne
    @JoinColumn(unique = true)
    private ItemModel pItemModel;

    @OneToMany(mappedBy = "classRoomModel")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ClassEventModel> classEventModels = new HashSet<>();
    @ManyToMany(mappedBy = "classRoomModels")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JsonIgnore
    private Set<TeacherModel> teacherModels = new HashSet<>();
}