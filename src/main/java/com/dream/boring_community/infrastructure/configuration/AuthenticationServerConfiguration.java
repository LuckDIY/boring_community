package com.dream.boring_community.infrastructure.configuration;

import com.dream.boring_community.domain.auth.AuthenticAccountDetailsService;
import com.dream.boring_community.domain.auth.provider.PreAuthenticatedAuthenticationProvider;
import com.dream.boring_community.domain.auth.provider.UsernamePasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @program: boring_community
 * @description: 权限控制配置  继承 WebSecurityConfiguration
 * @author: WangChaoLei
 * @create: 2022-07-12 10:27
 **/
@Configuration
@EnableWebSecurity
public class AuthenticationServerConfiguration extends WebSecurityConfiguration{

    @Autowired
    private AuthenticAccountDetailsService authenticAccountDetailsService;

    @Autowired
    private UsernamePasswordAuthenticationProvider userProvider;

    @Autowired
    private PreAuthenticatedAuthenticationProvider preProvider;

    /**
     * 密码编码器
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 构建AuthenticationManager
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticAccountDetailsService).passwordEncoder(passwordEncoder);
        auth.authenticationProvider(userProvider);
        auth.authenticationProvider(preProvider);
    }
}
