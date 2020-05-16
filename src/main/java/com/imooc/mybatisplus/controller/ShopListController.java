package com.imooc.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import com.imooc.mybatisplus.entity.ShopList;
import com.imooc.mybatisplus.service.ShopListService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wu on 2020/5/14 0014
 */
@RestController
@Api(value = "商家信息", description = "实现商家的CRUD")
@RequestMapping("/shoplist")
public class ShopListController {
    @Resource
    private ShopListService shopListService;

    @GetMapping("/selectById/{shopId}")
    @ApiOperation(value = "根据商家主键查询")
    @ApiImplicitParam(name = "shopId", value = "商家主键", dataType = "Integer")
    public ShopList selectById(@PathVariable("shopId") Integer shopId) {
        LambdaQueryWrapper<ShopList> sllqw = Wrappers.<ShopList>lambdaQuery();
        sllqw.eq(ShopList::getShopUserId, shopId);
        ShopList shopList = shopListService.getOne(sllqw);
        /*    System.out.println(shopList.getShopUserId());*/
        return shopList;
    }

    @GetMapping("/selectByCondtion/{contion}")
    @ApiOperation(value = "根据商家其他环境条件查询")
    @ApiImplicitParam(name = "contion", value = "其他环境条件查询", dataType = "String")
    public List<ShopList> selectByContion(@PathVariable("contion") String contion) {
        List<ShopList> shopList = shopListService.lambdaQuery().like(ShopList::getShopName, contion).list();
        return shopList;
    }

    @GetMapping("/selectByDate/{date}")
    @ApiOperation(value = "根据商家小于创建时间查询降序")
    @ApiImplicitParam(name = "date", value = "日期时间", dataType = "Date")
    public List<ShopList> selectByDate(@PathVariable("date") String date) {
        List<ShopList> shopList = shopListService.lambdaQuery()
                .lt(ShopList::getCreateTime, date).orderByDesc(ShopList::getCreateTime).list();
        return shopList;
    }

    @PostMapping("/addbatch")
    @ApiOperation(value = "批量新增")
    @ApiImplicitParam(name = "shopList", value = "商家列表")
    public boolean addbatch(@RequestBody List<ShopList> shopList) {
        boolean b = shopListService.saveBatch(shopList);
        return b;
    }

}
