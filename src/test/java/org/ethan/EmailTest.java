package org.ethan;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

public class EmailTest extends BaseTest{

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 简单邮件测试
     */
    @Test
    public void simpleMailTest(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //设置发送人
        mailMessage.setFrom("zingdlc@qq.com");
        //邮件主题
        mailMessage.setSubject("学习资料");
        //邮件内容
        mailMessage.setText("Nice to meet you!!!");
        //收件人
        mailMessage.setTo("1756267448@qq.com");

        javaMailSender.send(mailMessage);
    }

    /**
     * 复杂邮件测试
     * @throws Exception
     */
    @Test
    public void mimeMailTest() throws Exception{
        //创建复杂邮件对象
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //发送复杂邮件的工具类
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true,"utf-8");
        helper.setFrom("zingdlc@qq.com");
        helper.setSubject("Tokyo very Hot");
        helper.setText("<h1>Tokyo very Hot</h1>"+
                "<img src='https://image.baidu.com/search/detail?ct=503316480&z=&tn=baiduimagedetail&ipn=d&word=%E6%B5%85%E4%BB%93%E7%BB%B4&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=-1&hd=&latest=&copyright=&cs=1251556484,4126565434&os=318318453,2647627604&simid=70229445,630898028&pn=38&rn=1&di=5310&ln=120&fr=&fmq=1635386165455_R&ic=&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=0,0&istype=2&ist=&jit=&bdtype=11&spn=0&pi=0&gsm=0&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%253A%252F%252Fi1.go2yd.com%252Fimage.php%253Furl%253D0XQit1yk2Q%26refer%3Dhttp%253A%252F%252Fi1.go2yd.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1637978172%26t%3Ddaf101b9c3f7496b18c2962161dcaa01&rpstart=0&rpnum=0&adpicid=0&nojc=undefined&dyTabStr=MCwxLDMsNiwyLDQsNSw3LDgsOQ%3D%3D'>",true);
        //添加附件
        helper.addAttachment("zzz.jpeg",new File("F:\\downloads\\2号.jpeg"));
        //收件人
        helper.setTo("zingdlc@qq.com");

        javaMailSender.send(mimeMessage);
    }
}
