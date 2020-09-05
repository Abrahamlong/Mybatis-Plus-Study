package com.example.mybatisplusdemo.study.service.impl;

import com.example.mybatisplusdemo.study.auto_pojo.User;
import com.example.mybatisplusdemo.study.auto_mapper.UserMapper;
import com.example.mybatisplusdemo.study.auto_service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author abraham long
 * @since 2020-09-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
