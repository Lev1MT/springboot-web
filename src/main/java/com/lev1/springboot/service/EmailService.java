package com.lev1.springboot.service;

import com.lev1.springboot.entities.EmailInfo;

public interface EmailService {

    public int saveEmailMessages(EmailInfo emailInfo);
}
