package com.tickaboo.server.repository;

import com.tickaboo.server.model.Timer;
import com.tickaboo.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TimerRepository extends JpaRepository<Timer, UUID> {
}
