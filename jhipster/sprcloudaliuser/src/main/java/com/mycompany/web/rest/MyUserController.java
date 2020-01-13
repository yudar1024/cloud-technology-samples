package com.mycompany.web.rest;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mycompany.domain.MyUser;
import com.mycompany.service.IMyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author roger
 * @since 2019-11-22
 */
@RestController
@RequestMapping("/my-user")
public class MyUserController {

    @Autowired
    private IMyUserService myUserService;

    @PostMapping("/users")
    public String addNewUser(@RequestBody MyUser myUser){
        myUserService.save(myUser);
        QueryWrapper<MyUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(myUser.getName()!=null,"name",myUser.getName());
        myUserService.list(queryWrapper);
        return "save suceess";
    }

}

