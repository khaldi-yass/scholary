package com.yassir.scholary.dtos;

import lombok.Data;

public @Data
class UserDto {

    private String username;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private String primaryEmail;
    private String primaryPhone;
    private String profilePictureUrl;

}
