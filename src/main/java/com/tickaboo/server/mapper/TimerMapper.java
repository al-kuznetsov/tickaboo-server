package com.tickaboo.server.mapper;

import com.tickaboo.server.dto.TimerDto;
import com.tickaboo.server.dto.UserDto;
import com.tickaboo.server.model.Timer;
import com.tickaboo.server.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;


@Mapper(config = StandardMapperConfiguration.class,
        uses = TimeStampMapper.class)
public interface TimerMapper {
    @Mapping(source = "beginTimestamp", target = "beginTimestamp", qualifiedByName = { "LongToInstant" })
    @Mapping(source = "endTimestamp", target = "endTimestamp", qualifiedByName = { "LongToInstant" })
    Timer fromDto(TimerDto timerDto);

    @Mapping(source = "beginTimestamp", target = "beginTimestamp", qualifiedByName = { "InstantToLong" })
    @Mapping(source = "endTimestamp", target = "endTimestamp", qualifiedByName = { "InstantToLong" })
    TimerDto toDto(Timer timer);

    void updateFromDto(@MappingTarget Timer timer, TimerDto timerDto);
}
