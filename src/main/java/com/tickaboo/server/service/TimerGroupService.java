package com.tickaboo.server.service;

import com.tickaboo.server.dto.TimerGroupDto;
import com.tickaboo.server.mapper.TimerGroupMapper;
import com.tickaboo.server.mapper.UserMapper;
import com.tickaboo.server.model.TimerGroup;
import com.tickaboo.server.repository.TimerGroupRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TimerGroupService {

    private final TimerGroupRepository timerGroupRepository;
    private final TimerGroupMapper timerGroupMapper;

    @Transactional(readOnly = true)
    public List<TimerGroupDto> getAll(){
        return timerGroupRepository.findAll().stream().map(timerGroupMapper::toDto).toList();
    }
    @Transactional(readOnly = true)
    public Optional <TimerGroupDto> getByName(String name){
        return timerGroupRepository.findByName(name).map(timerGroupMapper::toDto);
    }
}
