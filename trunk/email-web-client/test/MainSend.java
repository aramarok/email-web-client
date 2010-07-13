//Mail.java - smtp sending starttls (ssl) authentication enabled
//1.Open a new Java class in netbeans (default package of the project) and name it as "Mail.java"
//2.Copy paste the entire code below and save it.
//3.Right click on the file name in the left side panel and click "compile" then click "Run"
 
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
 
public class MainSend
{
    String  d_email = "",
            d_password = "",
            d_host = "smtp.gmail.com",
            d_port  = "465",
            m_to = "",
            m_subject = "Testing",
            m_text = "Hey, this is the testing email.";
    
    public MainSend()
    {
        Properties props = new Properties();
        props.put("mail.smtp.user", d_email);
        props.put("mail.smtp.host", d_host);
        props.put("mail.smtp.port", d_port);
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", d_port);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
 
        SecurityManager security = System.getSecurityManager();
 
        try
        {
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
            //session.setDebug(true);
 
            MimeMessage msg = new MimeMessage(session);
            msg.setText(m_text);
            msg.setSubject(m_subject);
            msg.setFrom(new InternetAddress(d_email));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
            Transport.send(msg);
        }
        catch (Exception mex)
        {
            mex.printStackTrace();
        } 
    }
    
    public static void main(String[] args)
    {
        MainSend blah = new MainSend();
    }
 
    private class SMTPAuthenticator extends javax.mail.Authenticator
    {
        public PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication(d_email, d_password);
        }
    }
}