package com.bb.emaildemo.service;

import com.bb.emaildemo.model.Email;
import com.bb.emaildemo.model.EmailAndUserinfo;
import com.bb.emaildemo.model.User;

import java.util.List;

public interface EmailService {
    Boolean sendEmail(Email email);
    String setDeleteEmail(int eId);
    Boolean SetReadEmail(int eId);
    String SetCollection(int eId);
    List<Email> getAllSendEmail(int eSendPeople);
    List<Email> getAllReceiveEmail(int eReceivePeople);
    List<Email> getAllReceiveEmailAndReaded(int eReceivePeople);

    List<Email> getAllReceiveEmailAndUnReaded(int eReceivePeople);
    List<Email> getAllDeleteEmail(int eId);
    List<Email> getAllCollectionEmail(int eSendPeople);
    List<EmailAndUserinfo> getAllReceiveEmailUserinfo(int eReceivePeople);
    List<EmailAndUserinfo> getAllsendEmailUserinfo(int eReceivePeople);
    List<EmailAndUserinfo> getAllReceiveCollectionEmailUserinfo(int eReceivePeople);

    Email getEmailById(int id);

}
