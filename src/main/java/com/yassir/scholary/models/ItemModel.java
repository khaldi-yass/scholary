package com.yassir.scholary.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import uk.co.jemos.podam.common.PodamExclude;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public @Data
abstract class ItemModel implements Serializable {

    protected static final long serialVersionUID = 1L;

    @PodamExclude
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;

    @Column(name = "label")
    protected String label;

    @Column(name = "created_date")
    protected LocalDate createdDate;

    @Column(name = "last_modified_date")
    protected LocalDate lastModifiedDate;

    @Column(name = "description")
    protected String description;

    @Column(name = "activated")
    protected Boolean activated;

    @PodamExclude
    @ManyToOne
    @JsonIgnoreProperties("")
    protected UserModel createdBy;

    @PodamExclude
    @ManyToOne
    @JsonIgnoreProperties("")
    protected UserModel lastModifiedBy;

    @PodamExclude
    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "item_readable_by_user_groups", joinColumns = @JoinColumn(name = "items_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "readable_by_usergroups_id", referencedColumnName = "id"))
    protected List<UserGroupModel> readableByUserGroups = new ArrayList<>();

    @PodamExclude
    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "item_writable_by_user_groups", joinColumns = @JoinColumn(name = "items_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "writeable_by_usergroups_id", referencedColumnName = "id"))
    protected List<UserGroupModel> writableByUserGroups = new ArrayList<>();

}
