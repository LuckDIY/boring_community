package com.dream.boring_community.domain.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @program: boring_community
 * @description: 获取用户信息
 * @author: WangChaoLei
 * @create: 2022-07-12 18:40
 **/
public class AuthenticAccountDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
