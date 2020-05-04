package com.imooc.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.imooc.mybatisplus.dao.UserHighMapper;
import com.imooc.mybatisplus.entity.UserHigh;
import com.imooc.mybatisplus.service.UserHighService;
import org.springframework.stereotype.Service;

/**
 * @author wu on 2020/5/3 0003
 */
@Service
public class UserHighServiceImpl extends ServiceImpl<UserHighMapper, UserHigh> implements UserHighService {
}
