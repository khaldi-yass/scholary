package com.yassir.scholary.dtos.mappers;

import com.yassir.scholary.dtos.AddressDto;
import com.yassir.scholary.dtos.MediaDto;
import com.yassir.scholary.dtos.UserDto;
import com.yassir.scholary.dtos.UserGroupDto;
import com.yassir.scholary.models.AddressModel;
import com.yassir.scholary.models.MediaModel;
import com.yassir.scholary.models.UserGroupModel;
import com.yassir.scholary.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface Model2DtoMapper {

    UserModel toUserModel(UserDto source);

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
