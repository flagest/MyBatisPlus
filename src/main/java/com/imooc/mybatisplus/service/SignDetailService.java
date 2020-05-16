package com.imooc.mybatisplus.service;

import com.imooc.mybatisplus.entity.SignDetail;

import java.util.List;

/**
 * @author wu on 2020/5/12 0012
 */
public interface SignDetailService {
    /**
     * @param * @param null
     * @Date:21:20 2020/5/13 0013
     * @Description:根据id查询下
     * @retrun
     */
    public SignDetail selectById(Integer id);

    /**
     * @param * @param null
     * @Date:21:21 2020/5/13 0013
     * @Description:查询所有
     * @retrun
     */
    public List<SignDetail> slectAll();

    /**
     * @param * @param null
     * @Date:22:05 2020/5/13 0013
     * @Description:修改
     * @retrun
     */
    public boolean insertSignDetail(SignDetail signDetail);

    /**
     * @param * @param null
     * @Date:6:20 2020/5/14 0014
     * @Description:修改
     * @retrun
     */
    public boolean updateSignDetail(SignDetail signDetail);

    /**
     * @param * @param null
     * @Date:6:35 2020/5/14 0014
     * @Description:根据id去删除
     * @retrun
     */
    public boolean deleteById(Integer id);
}
