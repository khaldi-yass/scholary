package com.yassir.scholary.dtos;

import lombok.Data;

import java.util.List;

public @Data
class UserDto {

    private String seq;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private String birthCity;
    private AddressDto primaryAddress;
    private String primaryEmail;
    private String primaryPhone;
    private MediaDto profilePicture;
    private String passwordQuestion;
    private String passwordAnswer;
    private String lastLogin;
    private List<UserGroupDto> userGroups;
    private List<AddressDto> otherAddresses;
}
