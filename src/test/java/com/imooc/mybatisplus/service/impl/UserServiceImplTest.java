package com.imooc.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.imooc.mybatisplus.entity.User;
import com.imooc.mybatisplus.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void testUserService() {
        final User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getName, "霍去病1"), false);
        System.out.println(user);
    }

    @Test
    public void testBatch() {
        User user = new User();
        user.setName("dfasf");
        user.setAge(50);
        user.setEmail("sdfa@baomidou.com");


        User user1 = new User();
        user.setName("小旭旭1");
        user.setAge(49);
        user.setEmail("asdf@baomidou.com");
        user.setManagerId(1087982257332887553L);
        List<User> users = Arrays.asList(user, user1);

        boolean result = userService.saveBatch(users);
        System.out.println(userService);
    }

}