package com.caoxuantung.tdnews.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.caoxuantung.tdnews.models.User} entity
 */
public class UserDto implements Serializable {
    private final String email;
    private final String name;
    private final String role;

    public UserDto(String email, String name, String role) {
        this.email = email;
        this.name = name;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.email, entity.email) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.role, entity.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, role);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "email = " + email + ", " +
                "name = " + name + ", " +
                "role = " + role + ")";
    }
}