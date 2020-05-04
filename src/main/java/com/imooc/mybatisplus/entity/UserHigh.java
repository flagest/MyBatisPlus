package com.imooc.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author wu on 2020/5/3 0003
 */
@Data
public class UserHigh extends Model<UserHigh> {

    private static final long serialVersionUID = -9143358940814651811L;


    @TableId(type = IdType.AUTO)
    private long id;
    private String name;
    private Integer age;
    private String email;
    @TableField("manager_id")
    private long managerId;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;
    @Version
    private long version;
    //0表示未删除，1表示已删除
    @TableLogic
    @TableField(select = false)
    private Integer deleted;

}
