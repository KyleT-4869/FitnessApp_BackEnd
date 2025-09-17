package Group5.FitnessApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Login {

    @Id
    String username;

    String id;

    @Transient
    String password;

    int password_hash;

    public Login() {}

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login(String username, String password, String id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public Login(String username, String id,int password_hash) {
        this.username = username;
        this.id = id;
        this.password_hash = password_hash;
    }

    public Login(String username, String password, String id, int password_hash) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.password_hash = password_hash;

    }

    public String getUsername() {
        return username;
    }

    public void setUserame(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHash() {
        return this.password.hashCode();
    }
    public int getHash2() {
        return this.password_hash;
    }

}
