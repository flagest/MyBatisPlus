package com.imooc.mybatisplus.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.imooc.mybatisplus.method.DeleteAllMethod;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wu on 2020/5/4 0004
 */
@Component
public class MySqlinjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        methodList.add(new DeleteAllMethod());
        return methodList;
    }
}
