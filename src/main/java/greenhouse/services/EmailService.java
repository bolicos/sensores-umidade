package greenhouse.services;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class EmailService{
	
	@Autowired private JavaMailSender mailSender;
		
	@RequestMapping(path = "/email-send", method = RequestMethod.GET)
    public String sendMail() {
        try {
            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper( mail );
            helper.setTo( "sensor.humidity@gmail.com" );
            helper.setSubject( "Teste Envio de e-mail" );
            helper.setText("email/email", true);
            mailSender.send(mail);
            
            return "OK";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
        
    }

}
