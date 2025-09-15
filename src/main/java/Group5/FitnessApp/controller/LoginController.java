package Group5.FitnessApp.controller;

import Group5.FitnessApp.model.Login;
import Group5.FitnessApp.model.Member;
import Group5.FitnessApp.repository.LoginRepository;
import Group5.FitnessApp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginRepository logRepo;

    @Autowired
    MemberRepository memRepo;

    @GetMapping("/login")
    public boolean logIn() {
        Login log = new Login();
        Login logCheck = retrieveLog(log);
        if(logCheck == null) {
            return false;
        }
        else {
            if(!authorizePassword(log,logCheck)) {
                return false;
            }
        }
        return true;
    }

    public Login retrieveLog(Login log) {
        Login returnLog;
        if(logRepo.existsById(log.getUsername())) {
            returnLog = logRepo.findById(log.getUsername()).get();
            return returnLog;
        }
        return null;
    }

    public boolean authorizePassword(Login log, Login logCheck) {
        if(log.getHash() == logCheck.getHash()) {
            return true;
        }
        return false;
    }

    @GetMapping("/signup")
    public boolean signUp() {
        // Need to figure out a way to get inputs from JSON
        Member member = new Member();
        memRepo.save(member);
        return true;
    }
    @GetMapping("/createlogin")
    public boolean createLogin() {
        // Need to find a way to pass JSON files and read it into the variables
        Login log = new Login();
        if(!checkUsername(log)){
            System.out.println("Username already exist");
            return false;
        }
        if(!checkPassword(log)) {
            return false;
        }
        logRepo.save(log);
        return true;
    }

    public boolean checkUsername(Login log) {
        if(logRepo.existsById(log.getUsername())) {
            return false;
        }
        return true;
    }

    public boolean checkPassword(Login log) {
        if(log.getPassword().length() < 12) {
            System.out.println("You password needs to be at least 12 characters long");
            return false;
        }
        if(!checkSpecialChar(log)) {
            System.out.println("You need at least one special character in your password");
            return false;
        }
        return true;
    }

    public boolean checkSpecialChar(Login log) {
        for(int i = 0; i < log.getPassword().length(); i++ ) {
            if(!Character.isLetterOrDigit(log.getPassword().charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
