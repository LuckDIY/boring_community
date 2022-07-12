package com.dream.boring_community.interfaces.web;

import com.dream.boring_community.domain.account.Account;
import com.dream.boring_community.infrastructure.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: boring_community
 * @description: ok接口测试
 * @author: WangChaoLei
 * @create: 2022-07-12 10:23
 **/
@RestController
public class OkController {

    @Autowired
    private AccountMapper accountMapper;

    @GetMapping("/ok")
    public Object ok(){
        List<Account> accounts = accountMapper.selectAll();

        return accounts;
    }
}
