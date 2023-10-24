package com.tickaboo.server.controller;

import com.tickaboo.server.dto.TimerGroupDto;
import com.tickaboo.server.model.TimerGroup;
import com.tickaboo.server.service.TimerGroupService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.version.url}/timer_group")
public class TimerGroupController {
    private TimerGroupService timerGroupService;

    @GetMapping
    public List<TimerGroupDto> getAll() {
        return timerGroupService.getAll();
    }

    @GetMapping("/{name}")
    public Optional <TimerGroupDto> getByName(@PathVariable String name){
        return timerGroupService.getByName(name);
    }
}
