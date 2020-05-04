package com.imooc.mybatisplus.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.imooc.mybatisplus.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wu on 2020/5/3 0003
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteUserTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void deleteById() {
        final int rows = userMapper.deleteById(1088248166370832385L);
        System.out.println(rows + "影响行数");
    }

    @Test
    public void deleteByMap() {
        final HashMap<String, Object> sb = new HashMap<>();
        sb.put("name", "李艺伟");
        final int i = userMapper.deleteByMap(sb);
        System.out.println(i + " 影响的纪录行数！");
    }

    @Test
    public void deleteBatchId() {
        final int rows = userMapper.deleteBatchIds(Arrays.asList(1094590409767661570L, 1094592041087729666L));
        System.out.println(rows + " 影响行数！");
    }

    @Test
    public void delete() {
        final LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.<User>lambdaQuery();
        userLambdaQueryWrapper.eq(User::getName,"大boss");
        final int delete = userMapper.delete(userLambdaQueryWrapper);
        System.out.println(delete);
    }
}

