package com.yassir.scholary.coremodule.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A AttendanceModel.
 */
@Entity
@Table(name = "attendance")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class AttendanceModel extends ItemModel {

    @Column(name = "attended")
    private Boolean attended;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne
    @JsonIgnoreProperties("")
    private UserModel userModel;

    @ManyToOne
    @JsonIgnoreProperties("")
    private EventModel eventModel;

}
