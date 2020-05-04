package com.imooc.mybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.mybatisplus.entity.UserHigh;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wu on 2020/5/3 0003
 */
@Mapper
public interface UserHighMapper extends BaseMapper<UserHigh> {
    /**
     * @param * @param null
     * @Date:12:49 2020/5/4 0004
     * @Description:删除所有返回行数
     * @retrun
     */
    int deleteAll();
}
