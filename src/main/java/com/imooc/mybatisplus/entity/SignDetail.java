package com.imooc.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wu on 2020/5/12 0012
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sign_detail")
public class SignDetail implements Serializable {
    private static final long serialVersionUID = -3051138401895188261L;
    private Integer id;
    private String title;
    @TableField("create_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @TableField("open_id")
    private String open_id;
    private String amount;

}
