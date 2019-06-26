package com.lev1.springboot.service.impl;

import com.lev1.springboot.entities.EmailInfo;
import com.lev1.springboot.entities.User;
import com.lev1.springboot.mapper.LoginMapper;
import com.lev1.springboot.service.EmailService;
import com.lev1.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    EmailService emailService;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public User login(Integer id) {

        int sum = 0;

        for (int i = 1; i< 10;i++){
            sum += emailService.saveEmailMessages(new EmailInfo("张三","123456"+i+"@qq.com"));
        }
        System.out.println(sum);

        User exsitUser = loginMapper.getUserById(id);
        if (exsitUser != null) {
            System.out.println(exsitUser.getName() + "登录成功");
            return exsitUser;
        } else {
            System.out.println("登录失败，请先注册");
            return null;
        }
    }
}
