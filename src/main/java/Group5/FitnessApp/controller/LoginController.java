package Group5.FitnessApp.controller;

import Group5.FitnessApp.model.Login;
import Group5.FitnessApp.model.Member;
import Group5.FitnessApp.repository.LoginRepository;
import Group5.FitnessApp.repository.MemberRepository;
import Group5.FitnessApp.service.AccountRecoveryService;
import Group5.FitnessApp.service.CaloriesService;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api")
@RestController
public class LoginController {

    private final LoginRepository logRepo;
    private final MemberRepository memRepo;
    private final JdbcAggregateTemplate template;
    private final AccountRecoveryService passwordReset;
    private final JdbcTemplate SQLTemplate;
    private final CaloriesService calService;

    public LoginController(
            LoginRepository logRepo,
            MemberRepository memRepo,
            JdbcAggregateTemplate template,
            AccountRecoveryService passwordReset,
            JdbcTemplate SQLTemplate,
            CaloriesService calService
    ) {
        this.logRepo = logRepo;
        this.memRepo = memRepo;
        this.template = template;
        this.passwordReset = passwordReset;
        this.SQLTemplate = SQLTemplate;
        this.calService = calService;
    }

    /*
    @PostMapping("/changeProfile")
    public ResponseEntity<String> changeProfile(@RequestBody Member member) {
        int rows = SQLTemplate.update(
                "UPDATE MEMBER SET NAME = ?, DESCRIPTION = ? WHERE ID = ?",
                member.getName(), member.getDescription(), member.getId()
        );

        if (rows == 0) {
            return new ResponseEntity<>("Unable to change profile information", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok("Your profile information has been changed");
    }
    */

    @PostMapping("/sendCode")
    public ResponseEntity<Integer> sendRecoveryCode(@RequestBody Member member) {
        if (memRepo.existsById(member.getId())) {
            int returnCode = passwordReset.sendRecoveryCode(member.getId());
            return ResponseEntity.ok(returnCode);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestBody Login log) {
        int rows = SQLTemplate.update(
                "UPDATE LOGIN SET password_hash = ? WHERE id = ?",
                log.getHash(), log.getId()
        );
        if (rows == 0) {
            return new ResponseEntity<>("Unable to change password", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok("Your password has been changed");
    }

    @PostMapping("/login")
    public ResponseEntity<Member> logIn(@RequestBody Login log) {
        Login logCheck = retrieveLog(log);
        if (logCheck == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else if (!authorizePassword(log, logCheck)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Member member = memRepo.findById(logCheck.getId()).get();
        return ResponseEntity.ok(member);
    }

    public Login retrieveLog(Login log) {
        if (logRepo.existsById(log.getUsername())) {
            return logRepo.findById(log.getUsername()).get();
        }
        return null;
    }

    public boolean authorizePassword(Login log, Login logCheck) {
        return log.getHash() == logCheck.getHash2();
    }

    @PostMapping("/signup")
    public ResponseEntity<Member> signUp(@RequestBody Member member) {
        template.insert(member);
        return ResponseEntity.ok(member);
    }

    @PostMapping("/createlogin")
    public ResponseEntity<String> createLogin(@RequestBody Login log) {
        if (!checkUsername(log)) {
            return new ResponseEntity<>("Username already exist", HttpStatus.BAD_REQUEST);
        }
        if (log.getPassword().length() < 12) {
            return new ResponseEntity<>("Your password needs to be at least 12 characters long", HttpStatus.BAD_REQUEST);
        }
        if (!checkSpecialChar(log)) {
            return new ResponseEntity<>("You need at least 1 special character in your password", HttpStatus.BAD_REQUEST);
        }

        Login secureLog = new Login(log.getUsername(), log.getId(), log.getHash());
        template.insert(secureLog);
        return ResponseEntity.ok("Sign in created");
    }

    public boolean checkUsername(Login log) {
        return !logRepo.existsById(log.getUsername());
    }

    public boolean checkSpecialChar(Login log) {
        for (int i = 0; i < log.getPassword().length(); i++) {
            if (!Character.isLetterOrDigit(log.getPassword().charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
