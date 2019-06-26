package com.lev1.springboot.service.impl;

import com.lev1.springboot.entities.EmailInfo;
import com.lev1.springboot.mapper.EmailMapper;
import com.lev1.springboot.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    EmailMapper emailMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.READ_COMMITTED)
    @Override
    public int saveEmailMessages(EmailInfo emailInfo) {
        if ("1234565@qq.com".equals(emailInfo.getAddr())){
            throw new RuntimeException(emailInfo.getAddr()+"无法保存");
        }else {
            return emailMapper.saveEmailInfo(emailInfo);
        }
    }
}
