package com.imooc.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("normal_user")
public class NormalUser {

    @TableId
    private Integer id;

    @TableField("user_name")
    private String userName;

    private String phoneNumber;

    private String password;

    private String gender;

    private String eMail;

    private String openId;

    private String avatarUrl;

    private String city;

    private String province;

    private String country;

    private String langguage;

    private String nickName;

    private String integral;

    private BigDecimal lessMoney;

    private Integer member;

    private Integer disable;

    private String getGoodsAddress;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastEditTime;

    private String ylOne;

    private String ylTwo;

    private String ylThree;
    //transient 这个关键字用于不对数据字段的映射（这个关键字不能用于序列化）
    private transient String remeark;
    //static 可以不对数据库字段映射（可以用于序列化）
    public static String remeark1;

    //使用这个注解就可以不对数据库字段映射（可以用于序列化,并全局使用）
    @TableField(exist = false)
    public String remeark2;


}