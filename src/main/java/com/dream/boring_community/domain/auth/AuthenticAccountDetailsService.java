package com.dream.boring_community.domain.auth;

import com.dream.boring_community.infrastructure.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @program: boring_community
 * @description: 获取用户信息
 * @author: WangChaoLei
 * @create: 2022-07-12 18:40
 **/
@Component
public class AuthenticAccountDetailsService implements UserDetailsService {

    @Autowired
    private AuthenticAccountRepository authenticAccountRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return authenticAccountRepository.findByUsername(username);
    }
}
