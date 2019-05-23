package com.yassir.scholary.dtos.mappers;

import com.yassir.scholary.dtos.UserDto;
import com.yassir.scholary.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface Model2DtoMapper {

    Model2DtoMapper INSTANCE = Mappers.getMapper(Model2DtoMapper.class);

    @Mapping(target = "profilePicture.url", source = "userDto.profilePictureUrl")
    UserModel toUserModel(UserDto userDto);

    @Mapping(target = "profilePictureUrl", source = "userModel.profilePicture.url")
    UserDto toUserDto(UserModel userModel);

}
