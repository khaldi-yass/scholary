package com.yassir.scholary.models;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A GeneralLevelModel.
 */
@Entity
@Table(name = "general_level")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class GeneralLevelModel extends ItemModel {

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

}
