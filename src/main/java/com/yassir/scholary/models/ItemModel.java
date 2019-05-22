package com.yassir.scholary.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A ItemModel.
 */
@Entity
@Table(name = "item")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class ItemModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "jhi_label")
    private String label;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "last_modified_date")
    private LocalDate lastModifiedDate;

    @Column(name = "description")
    private String description;

    @Column(name = "activated")
    private Boolean activated;

    @ManyToOne
    @JsonIgnoreProperties("")
    private UserModel createdBy;

    @ManyToOne
    @JsonIgnoreProperties("")
    private UserModel lastModifiedBy;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "item_readable_by_usergroups", joinColumns = @JoinColumn(name = "items_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "readable_by_usergroups_id", referencedColumnName = "id"))
    private Set<UserGroupModel> readableByUsergroups = new HashSet<>();

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "item_writeable_by_usergroups", joinColumns = @JoinColumn(name = "items_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "writeable_by_usergroups_id", referencedColumnName = "id"))
    private Set<UserGroupModel> writeableByUsergroups = new HashSet<>();

}
