package com.caoxuantung.tdnews.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serial;
import java.util.Collection;

public class UserPrincipal extends User {
    @Serial
    private static final long serialVersionUID = -3531439484732724601L;
    private final String name;


    public UserPrincipal(String username, String password, String name, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
