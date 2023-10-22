package com.zyj.leetcode.business.monitor;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

public class SendALiYunEmail {

    public static String username = "rdteam@inclution.com";
    public static String password = "xVrdD7tX3w";
    public static String receive = "zhou.yijun@inclution.com";



    public static void main(String[] args) {
        try {
            //设置SSL连接、邮件环境
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            Properties props = System.getProperties();
            //协议
            //props.setProperty("mail.transport.protocol", "smtp");

            props.setProperty("mail.smtp.host", "smtp.mxhichina.com");//smtp服务器地址
            //props.setProperty("mail.smtp.port", "25");//非加密端口
            // 使用ssl加密方式，进行如下配置：
            props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.socketFactory.port", "465");

            props.setProperty("mail.smtp.auth", "true");//表示SMTP发送邮件，需要进行身份验证
//            props.setProperty("mail.smtp.from", "发件人地址");//mailfrom 参数
            props.setProperty("mail.user", username);//发件人的账号
            props.setProperty("mail.password", password);// 发件人的账号的密码，如果开启三方客户端安全密码请使用新生产的密码
            //建立邮件会话
            Session session = Session.getDefaultInstance(props, new Authenticator() {
                //身份认证
                protected PasswordAuthentication getPasswordAuthentication() {
                    //发件人的账号、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            });
            //建立邮件对象
            MimeMessage message = new MimeMessage(session);
            //设置邮件的发件人
            InternetAddress from = new InternetAddress("发件人地址", "发件人名称"); //from 参数,可实现代发，注意：代发容易被收信方拒信或进入垃圾箱。
            message.setFrom(from);
            //设置邮件的收件人
            String[] to = {"收件人地址1", "收件人地址2", "收件人地址3"};//收件人列表
            InternetAddress[] sendTo = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++) {
                //System.out.println("发送到：" + to[i]);
                sendTo[i] = new InternetAddress(to[i]);
            }

            //传入收件人
            message.setRecipients(Message.RecipientType.TO, sendTo);
            //设置邮件的主题
            message.setSubject("邮件主题");
            //设置邮件的文本
            String content = "邮件内容";
            message.setContent(content, "text/html;charset=UTF-8");
            //设置时间
            message.setSentDate(new Date());
            message.saveChanges();
            //发送邮件
            Transport.send(message);
            System.out.println("发送成功！");
        } catch (Exception e) {
            System.out.println("异常：" + e.toString());
        }
    }
}