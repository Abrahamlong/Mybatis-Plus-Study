package com.example.mybatisplusdemo.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author long
 * @version 1.0.0
 * @date 2020/9/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    //对应数据库中的主键（uuid、自增id、雪花算法、redis、zookeeper）
//    @TableId()
    private Long id;
    private String name;
    private Integer age;
    private String email;

    //乐观锁version注解
    @Version
    private Integer version;

    //逻辑删除
    @TableLogic
    private Integer deleted;

    //字段添加填充内容
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
