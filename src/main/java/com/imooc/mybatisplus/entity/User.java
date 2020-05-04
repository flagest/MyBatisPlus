package com.imooc.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author wu on 2020/5/1 0001
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> {
    private static final long serialVersionUID = 5068351285072462471L;
    //    @TableId(type = IdType.ID_WORKER_STR) 使用雪花算法自动增长id
//    @TableId(type = IdType.UUID) 是uuid自增id
    @TableId(type = IdType.AUTO)//使用主键自动增长
    private long id;
    private String name;
    private int age;
    private String email;
    private long managerId;
    //    private Date createTime;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}
