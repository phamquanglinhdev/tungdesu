package com.caoxuantung.tdnews.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.caoxuantung.tdnews.models.User} entity
 */
public class UserDto implements Serializable {
    private final Long id;
    private final String email;
    private final String name;
    private final String password;
    private final String remember;
    private final String role;

    public UserDto(Long id, String email, String name, String password, String remember, String role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.remember = remember;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRemember() {
        return remember;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.remember, entity.remember) &&
                Objects.equals(this.role, entity.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, name, password, remember, role);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "email = " + email + ", " +
                "name = " + name + ", " +
                "password = " + password + ", " +
                "remember = " + remember + ", " +
                "role = " + role + ")";
    }
}