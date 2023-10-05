package com.tickaboo.server.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.mapstruct.Mapper;

/**
 * This mapper is used in other mappers to map between {@code Long} timestamp in milliseconds and {@code LocalDateTime}.
 */
@Mapper(config = StandardMapperConfiguration.class)
public interface LocalDateTimeMapper {

    /**
     * Maps a {@code Long} timestamp in milliseconds to a {@code LocalDateTime} instance at this System time zone.
     */
    default LocalDateTime fromTimestamp(Long timestamp) {
        return timestamp == null ? null : LocalDateTime.ofInstant(
                Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
    }

    /**
     * Maps a {@code LocalDateTime} instance to a {@code Long} timestamp in milliseconds.
     */
    default Long toTimestamp(LocalDateTime localDateTime) {
        return localDateTime == null ? null : localDateTime.atZone(
                ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
