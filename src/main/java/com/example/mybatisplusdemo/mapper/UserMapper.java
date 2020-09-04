package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplusdemo.POJO.User;
import org.springframework.stereotype.Repository;

/**
 * @author long
 * @version 1.0.0
 * @date 2020/9/4
 */
// 在对应的Mapper上面实现基本的接口BaseMapper
@Repository //代表持久层
public interface UserMapper extends BaseMapper<User> {

}
