package com.imooc.mybatisplus.controller;

import com.imooc.mybatisplus.entity.SignDetail;
import com.imooc.mybatisplus.service.SignDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wu on 2020/5/12 0012
 */
@Validated
@RestController
@RequestMapping("/signdet")
@Api(value = "签名信息接口类", description = "签名信息接口类的CURD")
public class SignDetailController {
    @Resource
    private SignDetailService signDetailService;

    @GetMapping("/selectById/{id}")
    @ApiOperation(value = "更具主键Id查询")
    @ApiImplicitParam(name = "id", value = "主键id")
    public SignDetail selectById(@PathVariable("id") Integer id) {
        return signDetailService.selectById(id);
    }

    @GetMapping("/selectByAll")
    @ApiOperation("查询所有")
    public List<SignDetail> selectById() {
        return signDetailService.slectAll();
    }

    @PostMapping("/add")
    @ApiOperation("新增签名人")
    public boolean add(@RequestBody SignDetail signDetail) {
        return signDetailService.insertSignDetail(signDetail);
    }

    @PostMapping("/modefiy")
    @ApiOperation("修改签名人")
    public boolean modefiy(@RequestBody SignDetail signDetail) {
        return signDetailService.updateSignDetail(signDetail);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("根据id去删除")
    public boolean modefiy(@PathVariable("id") Integer id) {
        return signDetailService.deleteById(id);
    }
}
