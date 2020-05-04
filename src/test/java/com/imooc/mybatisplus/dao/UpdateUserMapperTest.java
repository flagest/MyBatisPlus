package com.imooc.mybatisplus.dao;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.imooc.mybatisplus.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author wu on 2020/5/2 0002
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UpdateUserMapperTest {
    @Resource
    private UserMapper userMapper;


    @Test
    public void updateTest() {
        final User user = new User();
        user.setId(1088248166370832385L);
        user.setName("王大风");
        user.setAge(33);
        user.setEmail("ee@baomidou.com");
        user.setManagerId(1087982257332887553L);

        final int rows = userMapper.updateById(user);
        System.out.println(rows + "影响的行数");
    }

    @Test
    public void updateWapper() {
        final UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("name", "王大风");
        final User user = new User();
        user.setId(1088248166370832385L);

        user.setAge(49);
        user.setEmail("ee2021@baomidou.com");
        user.setManagerId(1087982257332887553L);
        final int rows = userMapper.update(user, userUpdateWrapper);
        System.out.println(rows + "影响的行数");
    }

    @Test
    public void updateWapper1() {
        final UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("name", "王大风").set("age", 55);
        final int rows = userMapper.update(null, userUpdateWrapper);
        System.out.println(rows + "影响的行数");
    }

    @Test
    public void updateWapper3() {
        final LambdaUpdateWrapper<User> userLambdaUpdateWrapper = Wrappers.<User>lambdaUpdate();
        userLambdaUpdateWrapper.eq(User::getName, "王大风")
                .set(User::getAge,12).set(User::getEmail,"asdfasd@qq.com");
        final int rows = userMapper.update(null, userLambdaUpdateWrapper);
        System.out.println(rows + "影响的行数");
    }
    //Lambda链接
    @Test
    public void updateWapper4(){
        final boolean result = new LambdaUpdateChainWrapper<User>(userMapper).eq(User::getName, "王大风")
                .set(User::getAge, 12).set(User::getEmail, "d@qq.com").update();
        System.out.println(result);
    }
}
