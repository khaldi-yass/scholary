package com.yassir.scholary.frontmodule.soap.mappers;

import com.yassir.scholary.coremodule.dtos.AddressDto;
import com.yassir.scholary.coremodule.dtos.MediaDto;
import com.yassir.scholary.coremodule.dtos.UserDto;
import com.yassir.scholary.frontmodule.soap.userschema.AddressType;
import com.yassir.scholary.frontmodule.soap.userschema.PhotoType;
import com.yassir.scholary.frontmodule.soap.userschema.UserType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface Dto2SchemaMapper {

    UserType toUserType(UserDto source);

    UserDto toUserDto(UserType source);

    List<UserType> toUserTypeList(List<UserDto> source);

    List<UserDto> toUserDtoList(List<UserType> source);

    //    ---------------------------------------------------------------------------

    PhotoType toPhotoType(MediaDto source);

    MediaDto toMediaDto(PhotoType source);

    List<PhotoType> toPhotoTypeList(List<MediaDto> source);

    List<MediaDto> toMediaDtoList(List<PhotoType> source);

    //    ---------------------------------------------------------------------------

    AddressType toAddressType(AddressDto source);

    AddressDto toAddressDto(AddressType source);

    List<AddressType> toAddressTypeList(List<AddressDto> source);

    List<AddressDto> toAddressDtoList(List<AddressType> source);
}
