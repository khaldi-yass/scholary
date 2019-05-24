package com.yassir.scholary.dtos;

import lombok.Data;

public @Data
class AddressDto {

    private String country;
    private String region;
    private String city;
    private String district;
    private String streetName;
    private Integer streetNumber;
    private Integer houseNumber;
    private Integer floorNumber;
    private Integer apartmentNumber;
    private Integer zipCode;
}
