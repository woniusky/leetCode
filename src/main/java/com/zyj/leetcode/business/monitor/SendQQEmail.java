package com.zyj.leetcode.business.monitor;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendQQEmail {

    public static void main(String[] args) {

        // 设置邮件服务器信息
        String host = "smtp.exmail.qq.com";
        final String username = "rdteam@inclution.com";
        final String password = "xVrdD7tX3w";
//        final String username = "zheng.rulin@inclution.com";
//        final String password = "Zrl123";

        // 创建邮件发送会话
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // 获取邮件会话
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // 创建一封邮件
            Message message = new MimeMessage(session);

            // 设置邮件发送者
            message.setFrom(new InternetAddress(username));

            // 设置邮件接收者
            InternetAddress[] receives = new InternetAddress[2];
            receives[0] = new InternetAddress("zhou.yijun@inclution.com");
            receives[1] = new InternetAddress("zhang.xiaojie01@inclution.com");
            message.setRecipients(Message.RecipientType.TO, receives);


            InternetAddress[] ccList = new InternetAddress[2];
            ccList[0] = new InternetAddress("huang.yun@inclution.com");
            ccList[1] = new InternetAddress("qi.jiabo@inclution.com");
            message.setRecipients(Message.RecipientType.CC, ccList);

            // 设置邮件主题 "黄鋆"<huang.yun@inclution.com>;"戚佳波"<qi.jiabo@inclution.com>;
            message.setSubject("Testing Subject");

            // 设置邮件正文
            message.setText("This is a test email  gaocuole");

            // 发送邮件
            Transport.send(message);

            System.out.println("邮件发送成功");

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
