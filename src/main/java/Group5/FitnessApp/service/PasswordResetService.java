package Group5.FitnessApp.service;


import Group5.FitnessApp.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetService {

    @Autowired
    JavaMailSender javaMailSender;

    public PasswordResetService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendRecoveryCode(Member member) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(member.getId());
        mail.setFrom("group5.comp490@gmail.com");
        mail.setSubject("Recovery code for account");
        mail.setText("Random number");

        javaMailSender.send(mail);
    }
}
