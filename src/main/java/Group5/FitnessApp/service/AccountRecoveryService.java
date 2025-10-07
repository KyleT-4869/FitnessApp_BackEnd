package Group5.FitnessApp.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class AccountRecoveryService {

    @Autowired
    JavaMailSender javaMailSender;

    public AccountRecoveryService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public int sendRecoveryCode(String email) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setFrom("group5.comp490@gmail.com");
        mail.setSubject("Recovery code for account");
        int recoveryCode = generateCode();
        mail.setText("Your account recovery code is " + recoveryCode);

        javaMailSender.send(mail);
        return recoveryCode;
    }

    public int generateCode() {
        Random rand = new Random();
        return rand.nextInt((2000000 - 1000000) + 1) + 1000000;
    }
}
