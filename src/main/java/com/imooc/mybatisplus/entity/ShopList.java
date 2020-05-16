package com.imooc.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@ToString
@TableName("shop_list")
public class ShopList implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer shopUserId;

    private String shopName;

    private BigDecimal packageMoney;

    private String areaAddr;

    private Integer status;

    private String community;

    private String level;

    private String memberDate;

    private String beginBusinessHours;

    private String endBusinessHousers;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String ylOne;

    private String ylTwo;
    private String aa;
    private String ylThree;


}