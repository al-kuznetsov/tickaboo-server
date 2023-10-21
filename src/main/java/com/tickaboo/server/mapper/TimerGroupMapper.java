package com.tickaboo.server.mapper;

import com.tickaboo.server.dto.TimerGroupDto;
import com.tickaboo.server.model.TimerGroup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = StandardMapperConfiguration.class)
public interface TimerGroupMapper {

    TimerGroup fromDto(TimerGroupDto timerGroupDto);

    TimerGroupDto toDto(TimerGroup timerGroup);
}
