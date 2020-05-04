package com.imooc.mybatisplus.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imooc.mybatisplus.entity.NormalUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author wu on 2020/5/1 0001
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NormalUserMapperTest {

    @Resource
    private NormalUserMapper normalUserMapper;

    @Test
    public void findAllUser() {
        final List<NormalUser> normalUsers = normalUserMapper.selectList(null);
        System.out.println(normalUsers);
    }

    @Test
    public void insetUser() {
        final NormalUser normalUser = new NormalUser();
        normalUser.setId(29);
        normalUser.setUserName("张三");
        normalUser.setCity("北京");
        NormalUser.remeark1 = "哈哈哈哈！";
        normalUser.setRemeark2("xixixii!");
        final int insert = normalUserMapper.insert(normalUser);
        System.out.println("影响的行数是 " + insert);
    }

    @Test
    public void findById() {
        final NormalUser normalUser = normalUserMapper.selectById(28);
        System.out.println(normalUser);
    }

    @Test
    public void selectBatchIds() {
        final List<Integer> list = Arrays.asList(23, 24, 25, 26, 27);
        final List<NormalUser> normalUsers = normalUserMapper.selectBatchIds(list);
        System.out.println(normalUsers);
    }

    @Test
    public void findByMap() {
        final HashMap<String, Object> map = new HashMap<>();
//        map.put("user_name", "张三");
        map.put("open_id", "1c20256890514f1e85dc687ca8a6f164");
        final List<NormalUser> normalUsers = normalUserMapper.selectByMap(map);
        System.out.println(normalUsers);
    }

    //姓名为模糊查询，gender要小于30
    @Test
    public void findByWapper() {
        final QueryWrapper<NormalUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", "三").lt("gender", 30);
        final List<NormalUser> normalUsers = normalUserMapper.selectList(queryWrapper);
        System.out.println(normalUsers);
    }

    //姓名模糊查询，gender在20到40之间，phone_number不为空
    @Test
    public void findByWapper1() {
        final QueryWrapper<NormalUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", "三").between("gender", 20, 30).isNotNull("phone_number");
        final List<NormalUser> normalUsers = normalUserMapper.selectList(queryWrapper);
        System.out.println(normalUsers);
    }

    //按照姓名的右边模糊查询匹配，年龄大于20，按照年龄排序，年龄相同按照id排序
    @Test
    public void  findByWapper2(){
        final QueryWrapper<NormalUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("user_name","张").or().ge("gender",20).orderByDesc("gender")
                .orderByAsc("id");
        final List<NormalUser> normalUsers = normalUserMapper.selectList(queryWrapper);
        System.out.println(normalUsers);
    }
}