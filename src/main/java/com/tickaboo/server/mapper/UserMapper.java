package com.tickaboo.server.mapper;

import com.tickaboo.server.dto.UserDto;
import com.tickaboo.server.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    User fromDto(UserDto userDto);

    UserDto toDto(User user);

    void updateFromDto(@MappingTarget User user, UserDto userDto);
}
