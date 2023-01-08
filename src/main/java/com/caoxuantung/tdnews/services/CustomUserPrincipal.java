package com.caoxuantung.tdnews.services;

import javax.security.auth.Subject;
import java.nio.file.attribute.UserPrincipal;

public class CustomUserPrincipal implements UserPrincipal {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return UserPrincipal.super.implies(subject);
    }
}
