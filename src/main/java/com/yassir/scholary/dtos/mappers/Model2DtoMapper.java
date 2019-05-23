package com.yassir.scholary.dtos.mappers;

import com.yassir.scholary.dtos.UserDto;
import com.yassir.scholary.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface Model2DtoMapper {

    @Mapping(target = "profilePicture.url", source = "userDto.profilePictureUrl")
    UserModel toUserModel(UserDto userDto);

    @Mapping(target = "profilePictureUrl", source = "userModel.profilePicture.url")
    UserDto toUserDto(UserModel userModel);

    List<UserModel> toUserModelList(List<UserDto> userDtoList);

    List<UserDto> toUserDtoList(List<UserModel> userModelList);
}
