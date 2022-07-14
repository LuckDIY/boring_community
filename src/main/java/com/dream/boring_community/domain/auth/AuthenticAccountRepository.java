package com.dream.boring_community.domain.auth;

import com.dream.boring_community.domain.account.Account;
import com.dream.boring_community.infrastructure.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Optional;

/**
 * @program: boring_community
 * @description:
 * @author: WangChaoLei
 * @create: 2022-07-12 22:04
 **/
@Slf4j
@Component
public class AuthenticAccountRepository {

    @Autowired
    private AccountMapper accountMapper;


    public UserDetails findByUsername(String userName){

        Example example = new Example(Account.class);
        example.createCriteria().andEqualTo("username",userName);
        List<Account> accounts = accountMapper.selectByExample(example);

        if(CollectionUtils.isEmpty(accounts)){
            log.info("用户不存在:{}",userName);
            return null;
        }

        log.debug("用户信息:{}",accounts);

        return new AuthenticAccount(accounts.get(0));
    }
}
