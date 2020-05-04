package com.imooc.mybatisplus.dao;

import com.imooc.mybatisplus.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author wu on 2020/5/3 0003
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ARTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testArInsert() {
        final User user = new User();
        user.setId(1);
        user.setName("霍治林");
        user.setAge(25);
        user.setManagerId(45646565);
        final boolean insert = user.insert();
        System.out.println(insert);
    }

    @Test
    public void testArSelect() {
        final User user = new User();
        user.setId(1);
        final User user1 = user.selectById();
        System.out.println(user1);
    }

    @Test
    public void TestInsertOrUpdate() {
        final User user = new User();
        user.setId(2);
        user.setName("张强");
        user.setAge(22);
        user.setManagerId(456465651);
        final boolean result = user.insertOrUpdate();
        System.out.println(result);
    }

    @Test
    public void TestInsertOrUpdate1() {
        for (int i = 3; i < 100000; i++) {
            final User user = new User();
            user.setId(i);
            user.setName("张强");
            user.setAge(22);
            user.setManagerId(456465651 + i);
            user.setEmail("sdfds@qq.com");
            user.setCreateTime(LocalDateTime.now());
            final boolean result = user.insertOrUpdate();
            System.out.println(result);
        }
    }

    @Test
    public void deleteById() {
        for (int i = 2993; i <= 19495; i++) {
            final User user = new User();
            user.setId(i);
            user.setName("张强");
            user.setAge(22);
            user.setManagerId(456465651 + i);
            user.setEmail("sdfds@qq.com");
            final boolean result = user.deleteById();
            System.out.println(result);
        }
    }

    //设置主键自增后获取新增id
    @Test
    public void testArSelect1() {
         User user = new User();
        user.setName("霍去病1");
        user.setAge(22);
        user.setManagerId(456465652);
        user.setEmail("sdfd2s@qq.com");
        user.setCreateTime(LocalDateTime.now());
        int rows = userMapper.insert(user);
        System.out.println(rows);
        System.out.println(user.getId() + "获取自动增长的Id");
    }
}
