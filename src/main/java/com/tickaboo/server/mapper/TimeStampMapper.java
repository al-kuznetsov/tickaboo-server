package com.tickaboo.server.mapper;

import com.tickaboo.server.dto.TimerDto;
import com.tickaboo.server.model.Timer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.Instant;

@Mapper(config = StandardMapperConfiguration.class)
public interface TimeStampMapper {


    @Named("InstantToLong")
    default Long instantToLong(Instant instant) {
        return instant != null ? instant.toEpochMilli() : null;
    }

    @Named("LongToInstant")
    default Instant longToInstant(Long timestamp) {
        return timestamp != null ? Instant.ofEpochMilli(timestamp) : null;
    }
}
