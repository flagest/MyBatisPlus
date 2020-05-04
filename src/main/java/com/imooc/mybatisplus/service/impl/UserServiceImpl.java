package com.imooc.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.mybatisplus.dao.UserMapper;
import com.imooc.mybatisplus.entity.User;
import com.imooc.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author wu on 2020/5/3 0003
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
