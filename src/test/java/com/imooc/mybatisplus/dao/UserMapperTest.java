package com.imooc.mybatisplus.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.imooc.mybatisplus.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    //创建2019年2月14日并且上级为姓王
    @Test
    public void findByWapper() {
        final QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.apply("date_format(create_time,'%Y-%m-%d')", 2019 - 02 - 14)
                .inSql("manager_id", "select id from user where name like'王%'");
        final List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
    }

    //查看姓名为王姓，(年龄小于40或邮箱不为空)
    @Test
    public void findByWapper1() {
        final QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.likeRight("name", "王")
                .and(wq -> wq.lt("age", 20).or().isNotNull("email"));
        final List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);

    }

    //（年龄小于20或者邮箱不为空）并且姓名为王姓
    @Test
    public void findByWapper2() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.nested(wq -> wq.lt("age", "20")).or().isNotNull("email")
                .and(wq -> wq.likeRight("name", "王"));
        List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
    }

    //查看年龄在30,31,43,
    // age in(30,31,43)
    @Test
    public void findByWapper3() {
        final QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.in("age", Arrays.asList(32, 31, 40));
        final List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
    }

    //只返回一条查询值
    @Test
    public void findByWapper4() {
        final QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.in("age", Arrays.asList(31, 32, 40)).last("limit 1");
        final List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
    }

    //只需要返回固定的列
    @Test
    public void findByWapper5() {
        final QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("id", "name").likeRight("name", "王").lt("age", 40);
        final List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
    }

    //返回只需要的列
    @Test
    public void findByWapper6() {
        final QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select(User.class, info -> !info.getColumn().equals("create_time")
                && !info.getColumn().equals("name"));
        final List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
    }

    //condition 的环境
    @Test
    public void findByWapper7() {
        String name = "";
        String email = " ";
        final QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.likeRight(StringUtils.isNotEmpty(name), "name", name)
                .like(StringUtils.isNotEmpty(email), "email", email);
        final List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
    }

    //构造函数出入为实体
    @Test
    public void findByWrapper8() {
        final User whereUser = new User();
//        user.setAge(28);
        whereUser.setName("王天风");
        final QueryWrapper<User> userQueryWrapper = new QueryWrapper<>(whereUser);
        final List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
    }

    //返回时Map集合
    @Test
    public void findByMap() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.likeRight("name", "王%").lt("age", 50);
        List<Map<String, Object>> list = userMapper.selectMaps(userQueryWrapper);
        System.out.println(list);
    }

    @Test
    public void findByMap2() {
        final QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("avg(age)avg_age", "max(age)max_age", "min(age)min_age")
                .groupBy("manager_id").having("sum(age)<{0}", 500);
        List<Map<String, Object>> list = userMapper.selectMaps(userQueryWrapper);
        System.out.println(list);
    }

    //统计总记录数
    @Test
    public void findCount() {
        final QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.likeRight("name", "王%").lt("age", 50);
        final Integer integer = userMapper.selectCount(userQueryWrapper);
        System.out.println(integer);
    }

    //使用Lambda来查询,三种方式实现lambda构造器
    @Test
    public void findByLambda() {
        //第一种方式实现lambda构造器
//        final LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //第二种方式实现lambda构造器
//        final LambdaQueryWrapper<User> userLambdaQueryWrapper = new QueryWrapper<User>().lambda();
        //第三种方式实现lambda构造器
        final LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.<User>lambdaQuery();
        userLambdaQueryWrapper.like(User::getName, "雨").lt(User::getAge, "40");
        final List<User> users = userMapper.selectList(userLambdaQueryWrapper);
        users.forEach(System.out::println);
    }

    //姓名为王并且，（年龄小于40或者邮箱不为空）
    @Test
    public void findByLambda1() {
        final LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.<User>lambdaQuery();
        lambdaQueryWrapper.likeRight(User::getName, "王")
                .and(laq -> laq.lt(User::getAge, 40).or().isNotNull(User::getEmail));
        final List<User> users = userMapper.selectList(lambdaQueryWrapper);
        users.forEach(System.out::println);
        final User user = new User();
    }

    //第四种方式实现lambda构造器
    @Test
    public void findByLambda2() {
        final List<User> list = new LambdaQueryChainWrapper<User>(userMapper)
                .likeRight(User::getName, "王")
                .and(lqcw -> lqcw.lt(User::getAge, 40)
                        .or().isNotNull(User::getEmail)).list();
        list.forEach(System.out::println);
    }

    //姓名为王并且，（年龄小于40或者邮箱不为空）
    @Test
    public void findByLambda3() {
        final LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.<User>lambdaQuery();
        userLambdaQueryWrapper.likeRight(User::getName, "王")
                .and(lqw -> lqw.lt(User::getAge, 50).or().isNotNull(User::getEmail));
        final List<User> users = userMapper.selectAll(userLambdaQueryWrapper);
        users.forEach(System.out::println);
    }

    //第一种分页方式
    @Test
    public void testPage() {
        final QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.ge("age", 50);
        final Page<User> userPage = new Page<>(1, 4);
        //如果是queryWrapper是null的话就是查询所有
        final IPage<User> userIPage = userMapper.selectPage(userPage, null);
        System.out.println(userIPage.getTotal() + "总条数");
        System.out.println(userIPage.getRecords() );
    }

    //第二种方式分页
    @Test
    public void testBypage() {
        final QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.ge("age", 20);
        final Page<User> userPage = new Page<User>(1, 5);
        final IPage<User> userIPage = userMapper.selectByPage(userPage, userQueryWrapper);
        System.out.println(userIPage.getSize());
        final List<User> records = userIPage.getRecords();
        records.forEach(System.out::println);
    }
}