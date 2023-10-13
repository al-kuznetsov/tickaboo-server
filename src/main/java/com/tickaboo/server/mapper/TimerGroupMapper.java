package com.tickaboo.server.mapper;

import com.tickaboo.server.dto.TimerGroupDto;
import com.tickaboo.server.model.TimerGroup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = StandardMapperConfiguration.class,
        uses = LocalDateTimeMapper.class)
public interface TimerGroupMapper {

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "lastUpdatedAt", ignore = true)
    TimerGroup fromDto(TimerGroupDto timerGroupDto);

    TimerGroupDto toDto(TimerGroup timerGroup);
}
