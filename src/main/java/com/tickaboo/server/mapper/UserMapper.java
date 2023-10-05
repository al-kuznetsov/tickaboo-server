package com.tickaboo.server.mapper;

import com.tickaboo.server.dto.UserDto;
import com.tickaboo.server.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = StandardMapperConfiguration.class,
        uses = LocalDateTimeMapper.class)
public interface UserMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lastUpdatedAt", ignore = true)
    User fromDto(UserDto userDto);

    UserDto toDto(User user);

    void updateFromDto(@MappingTarget User user, UserDto userDto);
}
