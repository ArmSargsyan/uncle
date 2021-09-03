package com.example.emploee.security;

import com.example.emploee.model.ModelEmployee;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {

    private final ModelEmployee user;

    public CurrentUser(ModelEmployee user) {
        super(user.getUsername(), user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRole().name()));
        this.user = user;
    }

    public ModelEmployee getUser()   {
        return user;
    }
}
