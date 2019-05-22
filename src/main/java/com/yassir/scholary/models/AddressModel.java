package com.yassir.scholary.models;

import com.yassir.scholary.models.enumeration.City;
import com.yassir.scholary.models.enumeration.Country;
import com.yassir.scholary.models.enumeration.Region;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A AddressModel.
 */
@Entity
@Table(name = "address")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public @Data
class AddressModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private Integer appartmentNumber;

    @Column(name = "zip_code")
    private Integer zipCode;

    @OneToOne
    @JoinColumn(unique = true)
    private ItemModel pItemModel;
}
