package com.imooc.mybatisplus.compent;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author wu on 2020/5/3 0003
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        boolean hasCreateTime = metaObject.hasSetter("createTime");
        System.out.println(hasCreateTime + "sdfas");
        if (hasCreateTime) {
            System.out.println("join fillTest!" + LocalDateTime.now());
            setInsertFieldValByName("createTime", LocalDateTime.now(), metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        final Object updateTime = getFieldValByName("updateTime", metaObject);
        if (updateTime == null) {
            setUpdateFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }
    }
}
