package com.yassir.scholary.models;

import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * A EventModel.
 */
@Entity
@Table(name = "event")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public @Data
class EventModel extends ItemModel {

    @Column(name = "start_date_time")
    private LocalDate startDateTime;

    @Column(name = "end_date_time")
    private LocalDate endDateTime;

}
