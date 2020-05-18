package com.mycompany.service.impl;

import com.mycompany.domain.MyUser;
import com.mycompany.mapper.MyUserMapper;
import com.mycompany.service.IMyUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author roger
 * @since 2019-11-22
 */
@Service
public class MyUserServiceImpl extends ServiceImpl<MyUserMapper, MyUser> implements IMyUserService {

}
