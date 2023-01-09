package com.caoxuantung.tdnews.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.caoxuantung.tdnews.models.Tag} entity
 */
public class TagDto implements Serializable {
    private final String name;

    public TagDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagDto entity = (TagDto) o;
        return Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ")";
    }
}