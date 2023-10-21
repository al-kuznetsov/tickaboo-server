package com.tickaboo.server.service;

import com.tickaboo.server.dto.TimerDto;
import com.tickaboo.server.dto.UserDto;
import com.tickaboo.server.mapper.TimerMapper;
import com.tickaboo.server.mapper.UserMapper;
import com.tickaboo.server.model.Timer;
import com.tickaboo.server.model.User;
import com.tickaboo.server.repository.TimerRepository;
import com.tickaboo.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TimerService {

    private final TimerRepository timerRepository;
    private final TimerMapper timerMapper;

    @Transactional(readOnly = true)
    public List<TimerDto> findAll() {
        return timerRepository.findAll().stream().map(timerMapper::toDto).toList();
    }

    @Transactional(readOnly = true)
    public Optional<TimerDto> findById(UUID id){
        return timerRepository.findById(id).map(timerMapper::toDto);
    }

    public TimerDto create(TimerDto timerDto) {
        Timer timer = timerMapper.fromDto(timerDto);
        Timer savedTimer = timerRepository.save(timer);
        return timerMapper.toDto(savedTimer);
    }

    @Transactional
    public TimerDto update(UUID id, TimerDto timerDto) {
        Timer timer = timerRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: timer not found"));
        timerMapper.updateFromDto(timer, timerDto);
        Timer updatedTimer = timerRepository.save(timer);
        return timerMapper.toDto(updatedTimer);
    }

    @Transactional
    public TimerDto deleteById(UUID id) {
        Timer timer = timerRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: timer not found"));
        timerRepository.deleteById(id);
        return timerMapper.toDto(timer);
    }

}
