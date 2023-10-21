package com.tickaboo.server.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "timer")
public class Timer {
    @Id
    @UuidGenerator
    private UUID id;
    private String name;
    private String description;
    private java.time.Duration duration;
    private boolean priority;
    private boolean repeat;
    private boolean enabled;
    private Long userAccountId;
    private Long timerGroupId;
    private Long timerScheduleId;
    private java.time.Instant beginTimestamp;
    private java.time.Instant endTimestamp;

}
