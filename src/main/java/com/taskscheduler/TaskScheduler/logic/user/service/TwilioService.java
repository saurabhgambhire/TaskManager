package com.taskscheduler.TaskScheduler.logic.user.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class TwilioService {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String twilioPhoneNumber;

    public void sendSMS(String toPhoneNumber, String messageBody) {
        Twilio.init(accountSid, authToken);
        PhoneNumber to = new PhoneNumber(toPhoneNumber);
        PhoneNumber from = new PhoneNumber(twilioPhoneNumber);

        Message message = Message.creator(to, from, messageBody).create();
        System.out.println("Message SID: " + message.getSid());
    }
}
