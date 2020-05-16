package com.imooc.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.imooc.mybatisplus.dao.SignDetailMapper;
import com.imooc.mybatisplus.entity.SignDetail;
import com.imooc.mybatisplus.service.SignDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author wu on 2020/5/12 0012
 */
@Service
public class SignDetailServiceImpl implements SignDetailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SignDetailServiceImpl.class);
    @Resource
    private SignDetailMapper signDetailMapper;

    @Override
    public SignDetail selectById(Integer id) {

        LambdaQueryWrapper<SignDetail> sdlm = Wrappers.<SignDetail>lambdaQuery();
        sdlm.eq(SignDetail::getId, id);
        SignDetail signDetail = signDetailMapper.selectOne(sdlm);
        return signDetail;
    }

    @Override
    public List<SignDetail> slectAll() {

        return signDetailMapper.selectList(null);
    }

    @Override
    public boolean insertSignDetail(SignDetail signDetail) {
        signDetail.setCreateTime(new Date());
        if (signDetailMapper.insert(signDetail) > 0) {
            LOGGER.info("新增成功！");
            return true;
        }
        LOGGER.info("新增失败！");
        return false;
    }

    @Override
    public boolean updateSignDetail(SignDetail signDetail) {
        signDetail.setCreateTime(new Date());
        if (signDetailMapper.updateById(signDetail) > 0) {
            LOGGER.info("修改成功！");
            return true;
        }
        LOGGER.info("修改失败！");
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {

        if (signDetailMapper.deleteById(id) > 0) {
            LOGGER.info("删除成功！");
            return true;
        }
        LOGGER.info("删除失败！");
        return false;
    }
}
