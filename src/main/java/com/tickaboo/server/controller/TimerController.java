package com.tickaboo.server.controller;

import com.tickaboo.server.dto.TimerDto;
import com.tickaboo.server.dto.UserDto;
import com.tickaboo.server.service.TimerService;
import com.tickaboo.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.version.url}/timer")
public class TimerController {
    //get all (paginated), get by id, post, put, delete.
    private final TimerService timerService;

    @GetMapping
    public List<TimerDto> findAll() {
        return timerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TimerDto> findById(@PathVariable UUID id){
        return timerService.findById(id);
    }

    @PostMapping
    public TimerDto create(@RequestBody TimerDto timerDto) {
        return timerService.create(timerDto);
    }

    @PutMapping("/{id}")
    public TimerDto update(@PathVariable UUID id, @RequestBody TimerDto timerDto) {
        return timerService.update(id, timerDto);
    }

    @DeleteMapping("/{id}")
    public TimerDto delete(@PathVariable UUID id) {
        return timerService.deleteById(id);
    }
}
