package com.yassir.scholary.coremodule.models;

import com.yassir.scholary.coremodule.models.enumeration.City;
import com.yassir.scholary.coremodule.models.enumeration.Country;
import com.yassir.scholary.coremodule.models.enumeration.Region;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * A AddressModel.
 */
@Entity
@Table(name = "addresses")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class AddressModel extends ItemModel {

    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    private Country country;

    @Enumerated(EnumType.STRING)
    @Column(name = "region")
    private Region region;

    @Enumerated(EnumType.STRING)
    @Column(name = "city")
    private City city;

    @Column(name = "district")
    private String district;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "street_number")
    private Integer streetNumber;

    @Column(name = "house_number")
    private Integer houseNumber;

    @Column(name = "floor_number")
    private Integer floorNumber;

    @Column(name = "appartment_number")
    private Integer apartmentNumber;

    @Column(name = "zip_code")
    private Integer zipCode;

}
