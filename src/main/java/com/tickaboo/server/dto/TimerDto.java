package com.tickaboo.server.dto;

import java.util.UUID;

public record TimerDto(
        UUID id,
        String name,
        String description,
        int duration,
        boolean priority,
        boolean repeat,
        boolean enabled,
        Long timerGroupId,
        java.sql.Timestamp beginTimestamp,
        java.sql.Timestamp endTimestamp
        ) {
}
