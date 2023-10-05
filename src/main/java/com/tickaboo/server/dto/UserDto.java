package com.tickaboo.server.dto;

public record UserDto(Long id, String login, String name, String fullName, String bio, String email, String image) {
}
