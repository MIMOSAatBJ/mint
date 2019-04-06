package com.gto.util;

import jodd.mail.Email;
import jodd.mail.MailServer;
import jodd.mail.SendMailSession;
import jodd.mail.SmtpServer;

/**
 * 发送邮件工具类,比起javamail更易于使用,支持邮件使用变量替换
 *
 * @see { * https://jodd.org/email/ * }
 */
public interface EmailSendUtil {

    /**
     * 替换掉source中用 {}包裹的参数  如{value},如果参数未包裹则不执行替换
     *
     * @param source 源字符串
     * @param parm   参数
     * @param value  替换后的值
     * @return
     */
    static String replaceParm(String source, String parm, String value) {
        String regex = "\\{" + parm + "\\}";
        return source.replaceAll(regex, value);
    }

    /**
     * @param host     服务器主机
     * @param port     端口
     * @param ssl      是否启用SSL
     * @param userName 验证用邮箱用户名
     * @param password 验证用邮箱密码
     * @param from     发件人
     * @param to       收件人
     * @param title    邮件标题
     * @param content  邮件内容，支持html
     */
    static void sendMail(String host, int port, boolean ssl, String userName, String password, String from, String to, String title, String content) {
        SmtpServer smtpServer = MailServer.create()
                .host(host)
                .port(port)
                .ssl(ssl)
                .auth(userName, password)
                .buildSmtpMailServer();
        Email email = Email.create()
                .from(from)
                .to(to)
                .subject(title)
                .htmlMessage(content);
        SendMailSession session = smtpServer.createSession();
        session.open();
        session.sendMail(email);
        session.close();
    }
}
