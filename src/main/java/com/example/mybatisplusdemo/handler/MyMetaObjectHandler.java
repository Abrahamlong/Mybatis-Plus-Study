package com.example.mybatisplusdemo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author long
 * @version 1.0.0
 * @date 2020/9/4
 */
@Slf4j
@Component  //一定不要忘记把处理器加到IOC容器中
/**
 * 该类主要处理时间自动填充的策略问题
 */
public class MyMetaObjectHandler implements MetaObjectHandler {

    //插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill...");
        //String fieldName, Object fieldVal, MetaObject metaObject
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    //更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill...");
        //String fieldName, Object fieldVal, MetaObject metaObject
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

}
