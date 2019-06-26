package com.yassir.scholary.coremodule.dtos.mappers;

import com.yassir.scholary.coremodule.dtos.AddressDto;
import com.yassir.scholary.coremodule.dtos.MediaDto;
import com.yassir.scholary.coremodule.dtos.UserDto;
import com.yassir.scholary.coremodule.dtos.UserGroupDto;
import com.yassir.scholary.coremodule.models.AddressModel;
import com.yassir.scholary.coremodule.models.MediaModel;
import com.yassir.scholary.coremodule.models.UserGroupModel;
import com.yassir.scholary.coremodule.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface Model2DtoMapper {

    UserModel toUserModel(UserDto source);

    @Mapping(target = "seq", source = "id")
    UserDto toUserDto(UserModel source);

    List<UserModel> toUserModelList(List<UserDto> source);

    List<UserDto> toUserDtoList(List<UserModel> source);

    //    ---------------------------------------------------------------------------

    UserGroupModel toUserGroupModel(UserGroupDto source);

    UserGroupDto toUserGroupDto(UserGroupModel source);

    List<UserGroupModel> toUserGroupModelList(List<UserGroupDto> source);

    List<UserGroupDto> toUserGroupDtoList(List<UserGroupModel> source);

    //    ---------------------------------------------------------------------------

    MediaModel toMediaModel(MediaDto source);

    MediaDto toMediaDto(MediaModel source);

    List<MediaModel> toMediaModelList(List<MediaDto> source);

    List<MediaDto> toMediaDtoList(List<MediaModel> source);

    //    ---------------------------------------------------------------------------

    AddressModel toAddressModel(AddressDto source);

    AddressDto toAddressDto(AddressModel source);

    List<AddressModel> toAddressModelList(List<AddressDto> source);

    List<AddressDto> toAddressDtoList(List<AddressModel> source);
}
