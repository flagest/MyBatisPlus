package com.imooc.mybatisplus.dao;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.imooc.mybatisplus.config.MybatisPlusConfig;
import com.imooc.mybatisplus.entity.User;
import com.imooc.mybatisplus.entity.UserHigh;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wu on 2020/5/3 0003
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FillTest {
    @Resource
    private UserHighMapper userHighMapper;

    @Test
    public void insertTest() {
        UserHigh userHigh = new UserHigh();
        userHigh.setName("王西小于");
        userHigh.setAge(25);
        userHigh.setEmail("awece@qq.com");
        final int insert = userHighMapper.insert(userHigh);
        System.out.println(insert);
    }

    @Test
    public void findAll() {
        //测试sql查询动态表名,动态替换
        MybatisPlusConfig.mytableNmae.set("user_2019");
        List<UserHigh> userHighs = userHighMapper.selectList(null);
        userHighs.forEach(System.out::println);
    }

    @Test
    public void testHappyLock() {
        int version = 3;
        final UserHigh userHigh = new UserHigh();
        userHigh.setId(1094592041087729671L);
        userHigh.setEmail("zhang@qq.com");
        userHigh.setVersion(version);
        final int rows = userHighMapper.updateById(userHigh);
        System.out.println("影响的行数 " + rows);
    }
}
