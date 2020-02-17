package com.example.mppadmin.security;


import com.example.common.model.User;
import lombok.Data;
import org.springframework.security.core.authority.AuthorityUtils;

@Data
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getEmail(), user.getPassword(),
            user.isEnable(), true, true, true, AuthorityUtils.createAuthorityList(user.getUserType().name()));
        this.user = user;
    }

}
