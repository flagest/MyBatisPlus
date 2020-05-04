package com.imooc.mybatisplus.dao;

import com.imooc.mybatisplus.entity.UserHigh;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wu on 2020/5/3 0003
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlusTest {

    @Resource
    private UserHighMapper userHighMapper;

    @Test
    public void myTest() {
        final int result = userHighMapper.deleteById(1094592041087729666L);
        System.out.println("影响的行数 " + result);
    }

    @Test
    public void findAll() {
        final List<UserHigh> userHighs = userHighMapper.selectList(null);
        userHighs.forEach(System.out::println);
    }

}
