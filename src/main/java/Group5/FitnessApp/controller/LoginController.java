package Group5.FitnessApp.controller;

import Group5.FitnessApp.model.Login;
import Group5.FitnessApp.model.Member;
import Group5.FitnessApp.repository.LoginRepository;
import Group5.FitnessApp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class LoginController {

    @Autowired
    LoginRepository logRepo;

    @Autowired
    MemberRepository memRepo;

    @Autowired
    JdbcAggregateTemplate template;

    public LoginController(LoginRepository logRepo, MemberRepository memRepo, JdbcAggregateTemplate template) {
        this.logRepo = logRepo;
        this.memRepo = memRepo;
        this.template = template;
    }

    @PostMapping("/login")
    public ResponseEntity<Member> logIn(@RequestBody Login log) {
        Login logCheck = retrieveLog(log);
        if(logCheck == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        else {
            if(!authorizePassword(log,logCheck)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
        Member member = memRepo.findById(logCheck.getId()).get();
        return ResponseEntity.ok(member);
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
        if(log.getHash() == logCheck.getHash2()) {
            return true;
        }
        return false;
    }

    @PostMapping("/signup")
    public ResponseEntity<Member> signUp(@RequestBody Member member) {
        template.insert(member);
        return ResponseEntity.ok(member);
    }
    @PostMapping("/createlogin")
    public ResponseEntity<String> createLogin(@RequestBody Login log) {
        if(!checkUsername(log)){
            System.out.println();
            return new ResponseEntity<>("Username already exist",HttpStatus.BAD_REQUEST);
        }
        if(log.getPassword().length() < 12) {
            return new ResponseEntity<>("Your password needs to be at least 12 characters long", HttpStatus.BAD_REQUEST);
        }
        if(!checkSpecialChar(log)) {
            return new ResponseEntity<>("You need at least 1 special character in your password", HttpStatus.BAD_REQUEST);
        }
        Login secureLog = new Login(log.getUsername(), log.getId(), log.getHash());
        template.insert(secureLog);
        return ResponseEntity.ok("Sign in created");
    }

    public boolean checkUsername(Login log) {
        if(logRepo.existsById(log.getUsername())) {
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
