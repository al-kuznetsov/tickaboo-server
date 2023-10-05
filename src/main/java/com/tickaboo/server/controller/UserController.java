package com.tickaboo.server.controller;

import com.tickaboo.server.model.User;
import com.tickaboo.server.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.version.url}/users")
public class UserController {

    private final UserRepository repository;

    @GetMapping
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @Transactional(readOnly = true)
    public Optional<User> findById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping
    @Transactional
    public User create(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @PutMapping("/{id}")
    @Transactional
    public User update(@RequestBody User newUser, @PathVariable Long id) {
        return repository.findById(id).map(user -> {
            user.setName(newUser.getName());
            user.setFullName(newUser.getFullName());
            user.setBio(newUser.getBio());
            user.setEmail(newUser.getEmail());
            user.setImage(newUser.getImage());
            return repository.save(user);
        }).orElseGet(() -> {
            newUser.setId(id);
            return repository.save(newUser);
        });
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}