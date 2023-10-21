package com.tickaboo.server.repository;

import com.tickaboo.server.model.TimerGroup;
import com.tickaboo.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimerGroupRepository extends JpaRepository<TimerGroup, String> {
    Optional<TimerGroup> findByName(String name);

}
